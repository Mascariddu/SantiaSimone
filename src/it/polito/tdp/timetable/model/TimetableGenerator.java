package it.polito.tdp.timetable.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class TimetableGenerator {
	
	private List<Class> classes;
	private List<Teacher> teachers;
	private List<Course> courses;
	private List<Subject> subjects;
	private List<Lab> labs;
	private Model model;
	private int numHoursWeek;
	private int numHoursDay;
	private int numDays;
	private boolean trovato;
	private int countNotSatisfied;
	private int returnedBack;
	private int loops;
	private long timeProcess;
	
	private String[][] timetableSubject;
	private String[][] timetableTeacher;
	private String[][] timetableLab;
	
	public TimetableGenerator(Model model) {
		super();
		this.model = model;
		this.classes = new ArrayList<>(model.getAllClasses());
		this.teachers = new ArrayList<>(model.getAllTeachers());
		this.courses = model.getAllCourses();
		this.subjects = model.getAllSubjects();
		this.labs = model.getAllLab();
		this.numHoursWeek = model.getHoursWeekSchool();
		this.numHoursDay = model.getHoursDaySchool();
		this.numDays = model.getSchool().getWorkDays();
	}
	
	public void generateTimetable() {
		/* genero i timetable dove per righe ho le classi e per colonne le ore*/
		this.timetableSubject = new String[classes.size()][numHoursWeek];
		this.timetableTeacher = new String[classes.size()][numHoursWeek];
		this.timetableLab = new String[classes.size()][numHoursWeek];
		
		this.trovato = false;
		this.countNotSatisfied = 0; /* conta i professori di cui non è stata rispettata la loro preferenza di giorno libero*/
		this.returnedBack = (int) ((numHoursWeek*2)/3); 
		this.loops = 0;
		
		Class c = classes.iterator().next();
		Map<String, Integer[]> cs = new HashMap<>(courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject());
		List<String> listKey = new ArrayList<String>(c.getMapSubjectTeacher().keySet());
		
		/* inizio recursione */
		long start = System.currentTimeMillis();
		while(!trovato) {
			timeProcess = System.currentTimeMillis();
			recursive(timetableSubject, timetableTeacher, timetableLab, c, listKey, cs, 0, 0);
		}
		
		this.classes.clear();
		this.teachers.clear();
		
		this.teachers = model.getAllTeachers();
		this.classes = model.getAllClasses();
		this.timeProcess = System.currentTimeMillis() - start;
	}
	
	public void recursive(String [][] timetableS, String [][] timetableT, String[][] timetableL, Class c, List<String> listSub, Map<String, Integer[]> subHours, int x, int y) {	
		
		if((System.currentTimeMillis() - this.timeProcess) > 180000) // se impiega più di tre minuti ricomincia da capo
			return;
		
		int countBusy = 0;
		int tried = 0;
		String[][] tmT = timetableT.clone();
		String[][] tmS = timetableS.clone();
		String[][] tmL = timetableL.clone();
		
		while(listSub.iterator().hasNext()) {
			
			if(trovato || countBusy>(listSub.size()*2) || tried >= listSub.size()+1) /*check per uscire dal ciclo ed evitare loop*/
				return;
			
			String sbj = listSub.iterator().next();
			Teacher tch = teachers.get(teachers.indexOf(new Teacher(c.getMapSubjectTeacher().get(sbj))));
			Lab lab = null;
			Boolean busy = false;
			Boolean usedLab = false;
				
			if(subHours.get(sbj)[0] > 0) {			
				
				/* controllo se insegnate già occupato per quell'ora e giorno*/
				for(int i = y; i >= 0 ; i--)
					if(tmT[i][x] != null)
						if(tmT[i][x].compareTo(tch.getTeacherID()) == 0 && i!=y) 
							busy = true;
				
				/* controllo se il numero di ore consecutive della materia non sia superiore a 2 ore*/
				if(x>1 && !busy) 
					if(tmS[y][x-2].compareTo(sbj) == 0) 
						busy = true;
				
				/* controllo se il giorno su cui si sta lavorando non corrisponde al giorno libero dell'insegnante */
				if ((x >= tch.getFreeDay()*numHoursDay && x <= tch.getFreeDay()*(numHoursDay+1) ) && !busy) 
					if(countBusy <= listSub.size()) /* se ho provato tutte le materie e non ho trovato quella giusta "sacrifico" la preferenza dell'insegnante*/
						busy = true;
				
				/* controllo se la materia necessita l'uso di un laboratorio e se è libero*/
				if(subHours.get(sbj)[1] != 0 && !busy) {					
					for(Lab l : labs) {						
						if(l.getType() == subHours.get(sbj)[2]) { 
							usedLab = true;
							
							for(int k = y; k >= 0 ; k--)
								if(tmL[k][x] != null)
									if(tmL[k][x].compareTo(l.getLabID()) == 0 && k!=y)
										usedLab = false;
						}
						
						if(usedLab) { 
							lab = l;
							busy = false;
							break;
						} else if(subHours.get(sbj)[0] <= subHours.get(sbj)[1]) 
							busy = true; /* se devo necessariamente avere il laboratorio libero allora non posso assegnare la materia*/
						
					}
				}
					
				if(busy) { /* se materia non disponibile la posizione in fondo alla lista */
					listSub.remove(sbj);
					listSub.add(sbj);
					countBusy++;
				} else {
					/* se disponibile posiziono nei timetable di materia, insegnate ed eventualmente laboratorio*/
					tmS[y][x] = sbj;
					tmT[y][x] = tch.getTeacherID();
					
					if(usedLab) {
						tmL[y][x] = lab.getLabID();
						subHours.put(sbj, new Integer[] {subHours.get(sbj)[0]-1, subHours.get(sbj)[1]-1, subHours.get(sbj)[2]});
					} else 
						subHours.put(sbj, new Integer[] {subHours.get(sbj)[0]-1, subHours.get(sbj)[1], subHours.get(sbj)[2]});
					
					recursive(tmS, tmT, tmL, c, listSub, subHours, x+1, y);										
					
					if(usedLab) {
						tmL[y][x] = null;
						subHours.put(sbj, new Integer[] {subHours.get(sbj)[0]+1, subHours.get(sbj)[1]+1, subHours.get(sbj)[2]});
					} else 
						subHours.put(sbj, new Integer[] {subHours.get(sbj)[0]+1, subHours.get(sbj)[1], subHours.get(sbj)[2]});
					
					tmS[y][x] = null;
					tmT[y][x] = null;
					listSub.remove(sbj);
					listSub.add(sbj);
					
					if(loops > numHoursWeek/4) /* se ripeto per un certo numero di volte lo stesso percorso senza andare avanti (loop), torno indietro un certo numero di passi*/
						if(returnedBack>0 ) {
							returnedBack--;
							return;
						} else {
							returnedBack = (int)(numHoursWeek*Math.random());
							loops = 0;
						}	
					
					tried++;
					loops++;
				}
				
			} else listSub.remove(sbj);
			
		}
		
		if(listSub.isEmpty()) { /* quando ho posizionato tutte le materie della classe passo alla classe successiva*/
			classes.remove(c);
			
			if(classes.isEmpty() && !trovato) { /* finite le classi copio i timetable in nuovi oggetti */
				trovato = true;
				this.timetableSubject = copyTimetable(tmS);
				this.timetableTeacher = copyTimetable(tmT);
				this.timetableLab = copyTimetable(tmL);
				
				return;
			}
			
			Class nw = classes.iterator().next();
			
			recursive(tmS, tmT, tmL, nw, 
					new ArrayList<String>(nw.getMapSubjectTeacher().keySet()), 
					new HashMap<>(courses.get(courses.indexOf(new Course(nw.getCourseID()))).getMapSubject()), 
					0, y+1);
			
			classes.add(c);
		}
		
	}
	
	/**
	 * Metodo per ricopiare il timetable in un nuovo oggetto
	 * @param matrix
	 * @return copia matrice
	 */
	
	
	private String[][] copyTimetable(String[][] matrix) {
		
		String[][] timetable = new String[matrix.length][numHoursWeek];
		
		for(int i=0; i<matrix.length; i++)
			for (int j=0; j<matrix[0].length; j++)
				timetable[i][j] = matrix[i][j];
		
		return timetable;
	}
	
	
	/**
	 * Metodo per realizzare il timetable di una classe data
	 * @param classID
	 * @return timetable classe
	 */
	
	public String[][] getTimetableByClass(String classID) {

		String[][] t = new String[numHoursDay][numDays];
		int s = 0;
		int p = classes.indexOf(new Class(classID));	
		
		for(int d = 0; d<numDays; d++) {
			for(int h = 0; h < numHoursDay; h++) {
				t[h][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[p][s]))).getName().toUpperCase() + "\n	"
						+ teachers.get(teachers.indexOf(new Teacher(timetableTeacher[p][s]))).getSurname() + " " 
						+ teachers.get(teachers.indexOf(new Teacher(timetableTeacher[p][s]))).getName();
				
				if(timetableLab[p][s] != null)
					t[h][d] += "\n	" + labs.get(labs.indexOf(new Lab(timetableLab[p][s]))).getName();
				
				s++;
			}	
		}
		
		return t;
	}
	
	
	
	/**
	 * Metodo per realizzare il timetable di un insegnante dato
	 * @param classID
	 * @return timetable insegnante
	 */
	
	public String[][] getTimetableByTeacher(String teacherID) {

		String[][] t = new String[numHoursDay][numDays];	
		
		for(int d = 0; d<numDays; d++) {
			int r = 0;
			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
				for(int c = 0; c<classes.size(); c++) { 
					if(timetableTeacher[c][h].compareTo(teacherID) == 0) {
						t[r][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[c][h]))).getName().toUpperCase() + "\n" 
							+ classes.get(c).getGrade() + " " + classes.get(c).getSection();
						
						if(timetableLab[c][h] != null)
							t[r][d] += " - " + labs.get(labs.indexOf(new Lab(timetableLab[c][h]))).getName();
					}
				}
				r++;
			}
		}
		
		return t;
	}
	
	
	
	/**
	 * Metodo per realizzare il timetable di un laboratorio dato
	 * @param classID
	 * @return timetable laboratorio
	 */	
	
	public String[][] getTimetableByLab(String labID) {

		String[][] t = new String[numHoursDay][numDays];	
		
		for(int d = 0; d<numDays; d++) {
			int r = 0;
			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
					for(int c = 0; c<classes.size(); c++) { 
						if(timetableLab[c][h] != null)
							if(timetableLab[c][h].compareTo(labID) == 0)
								t[r][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[c][h]))).getName().toUpperCase() + "\n" 
									+ classes.get(c).getGrade() + " " + classes.get(c).getSection();
					}
					r++;
			}
		}
		
		return t;
	}
	
	
	/**
	 * Metodo per contare il numero di professori non soddisfatti nella loro preferenza di giorno libero
	 * @return professori non soddisfatti
	 */
	
	public int getCountNotSatisfied() {
		this.countNotSatisfied = 0;
		for(Teacher t : teachers) {
			Boolean work = false;
			for(int d = 0; d<numDays && !work; d++) 
				for(int c = 0; c<classes.size() && !work; c++)  
					for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
						if(timetableTeacher[c][h].compareTo(t.getTeacherID())==0 && d==t.getFreeDay()) {
							work = true;
							break;
						}
					}
			
			if(work)
				countNotSatisfied++;
		}
						
		return countNotSatisfied;
	}
	
	public long getTimeProcess() {
		return timeProcess/1000;
	}
	
	public void saveTimetable() {
        PrintStream printStream;
		try {
			File file = new File("save/"+ model.getSchool().getName() +".txt");
			printStream = new PrintStream(new FileOutputStream(file));
	        System.setOut(printStream);
	        System.out.print("CLASS	|");
	        
	        for(int d = 1; d<=numDays; d++) {
	        	for(int h = 1; h<=numHoursDay; h++)
	        		 System.out.print("	" + h);
	        	System.out.print("	|");
	        
	        }
	        
	        System.out.println();
	        
	        for(int c = 0 ; c< classes.size(); c++) {
	        	System.out.print(classes.get(c).getClassID() + "	|");
				for(int d = 0; d<numDays; d++) {
					for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
						 System.out.print("	" + timetableSubject[c][h]);
					}
					System.out.print("	|");
				}
				System.out.println();
	        }
	        
	        System.out.println();
	        System.out.println("TEACHER");
	        System.out.println();
	        
	        for(Teacher t : teachers) {
	        	System.out.print(t.getTeacherID() + "	|");
	        	for(int d = 0; d<numDays; d++) {
	    			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
	    				Boolean work = false;
	    				for(int c = 0; c<classes.size(); c++) { 
	    					if(timetableTeacher[c][h].compareTo(t.getTeacherID()) == 0) {
	    						 System.out.print("	" + classes.get(c).getClassID());
	    						 work = true;
	    					} 
	    				}
	    				if(!work)
	    					System.out.print("	#####");
	    			}
	    			System.out.print("	|");
	    		}
				System.out.println();
	        }
	        
	        System.out.println();
	        System.out.println("LAB");
	        System.out.println();
	        
	        for(Lab l : labs) {
	        	System.out.print(l.getLabID() + "	|");
	        	for(int d = 0; d<numDays; d++) {
	    			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
	    				Boolean work = false;
	    				for(int c = 0; c<classes.size(); c++) { 
	    					if(timetableLab[c][h] != null) 
		    					if(timetableLab[c][h].compareTo(l.getLabID()) == 0) {
		    						 System.out.print("	" + classes.get(c).getClassID());
		    						 work = true;
		    					} 
	    				}
	    				if(!work)
	    					System.out.print("	#####");
	    			}
	    			System.out.print("	|");
	    		}
				System.out.println();
	        }
	        
	        JOptionPane.showMessageDialog(null, "L'orario completo è stato salvato in " + file.getAbsolutePath());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
