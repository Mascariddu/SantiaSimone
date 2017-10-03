package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		this.timetableSubject = new String[classes.size()][numHoursWeek];
		this.timetableTeacher = new String[classes.size()][numHoursWeek];
		this.timetableLab = new String[classes.size()][numHoursWeek];
		
		this.trovato = false;
		this.countNotSatisfied = 0;
		this.returnedBack = 5;
		this.loops = 0;
		
		Class c = classes.iterator().next();
		Map<String, Integer[]> cs = new HashMap<>(courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject());
		List<String> listKey = new ArrayList<String>(c.getMapSubjectTeacher().keySet());
		
		long start = System.currentTimeMillis();
		
		recursive(timetableSubject, timetableTeacher, timetableLab, c, listKey, cs, 0, 0);
		
		long end = System.currentTimeMillis();
		
		this.classes.clear();
		this.teachers.clear();
		
		this.teachers = model.getAllTeachers();
		this.classes = model.getAllClasses();
		this.timeProcess = end - start;
	}
	
	public void recursive(String [][] timetableS, String [][] timetableT, String[][] timetableL, Class c, List<String> listSub, Map<String, Integer[]> subHours, int x, int y) {	
		
		int countBusy = 0;
		int tried = 0;
		String[][] tmT = timetableT.clone();
		String[][] tmS = timetableS.clone();
		String[][] tmL = timetableL.clone();
		
		while(listSub.iterator().hasNext()) {
			
			if(trovato || countBusy>(listSub.size()*2) || tried >= listSub.size()+1)
				return;
			
			String sbj = listSub.iterator().next();
			Teacher tch = teachers.get(teachers.indexOf(new Teacher(c.getMapSubjectTeacher().get(sbj))));
			Lab lab = null;
			Boolean busy = false;
			Boolean usedLab = false;
				
			if(subHours.get(sbj)[0] > 0) {			
				
				for(int i = y; i >= 0 ; i--)
					if(tmT[i][x] != null)
						if(tmT[i][x].compareTo(tch.getTeacherID()) == 0 && i!=y) 
							busy = true;
				
				if(x>1 && !busy) 
					if(tmS[y][x-2].compareTo(sbj) == 0) 
						busy = true;
				
				if ((x >= tch.getFreeDay()*numHoursDay && x <= tch.getFreeDay()*(numHoursDay+1) ) && !busy) 
					if(countBusy <= listSub.size())
						busy = true;
				
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
							busy = true;
						
					}
				}
					
				if(busy) {
					listSub.remove(sbj);
					listSub.add(sbj);
					countBusy++;
				} else {
					
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
					
					tmT[y][x] = null;
					listSub.remove(sbj);
					listSub.add(sbj);
					
					if(loops > numHoursWeek)
						if(returnedBack>0 && x>0) {
							returnedBack--;
							return;
						} else {
							returnedBack = (int) (y*x*Math.random());
							loops = 0;
						}	
					
					tried++;
					loops++;
				}
				
			} else listSub.remove(sbj);
			
		}
		
		if(listSub.isEmpty()) {
			classes.remove(c);
			
			if(classes.isEmpty() && !trovato) {
				trovato = true;
				this.timetableSubject = tmS;
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
	
	private String[][] copyTimetable(String[][] matrix) {
		
		String[][] timetable = new String[matrix.length][numHoursWeek];
		
		for(int i=0; i<matrix.length; i++)
			for (int j=0; j<matrix[0].length; j++)
				timetable[i][j] = matrix[i][j];
		
		return timetable;
	}
/*
	private boolean almostOneFreeDay(String teacherID, String[][] timetable, int x, int y) {
		boolean oneDay = false;
		
		for(int d = 0; d<numDays; d++) {
			oneDay = true;
			
			for(int c = 0; c<classes.size(); c++) {				
				for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {		
					
					if((x< numHoursDay*d || x>=numHoursDay*(d+1)) && timetable[c][h] != null) {
						if(timetable[c][h].compareTo(teacherID)==0) {
							oneDay = false;
							break;
						} 
					}
				}
				
				if(!oneDay)
					break;
			}
			
			if(oneDay)
				break;
		}
		
		return oneDay;
	}
	*/
	public String[][] getTimetableByClass(String classID) {

		String[][] t = new String[numHoursDay][numDays];
		int s = 0;
		int p = classes.indexOf(new Class(classID));	
		
		for(int d = 0; d<numDays; d++) {
			for(int h = 0; h < numHoursDay; h++) {
				t[h][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[p][s]))).getName() + "\n" 
						+ teachers.get(teachers.indexOf(new Teacher(timetableTeacher[p][s]))).getName() + " " 
						+ teachers.get(teachers.indexOf(new Teacher(timetableTeacher[p][s]))).getSurname();
				s++;
			}	
		}
		
		return t;
	}
	
	public String[][] getTimetableByTeacher(String teacherID) {

		String[][] t = new String[numHoursDay][numDays];	
		
		for(int d = 0; d<numDays; d++) {
			int r = 0;
			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
				for(int c = 0; c<classes.size(); c++) { 
					if(timetableTeacher[c][h].compareTo(teacherID) == 0)
						t[r][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[c][h]))).getName() + "\n" 
							+ classes.get(c).getGrade() + " " + classes.get(c).getSection();
				}
				r++;
			}
		}
		
		return t;
	}
	
	public String[][] getTimetableByLab(String labID) {

		String[][] t = new String[numHoursDay][numDays];	
		
		for(int d = 0; d<numDays; d++) {
			int r = 0;
			for(int h = numHoursDay*d; h < numHoursDay*(d+1); h++) {
					for(int c = 0; c<classes.size(); c++) { 
						if(timetableLab[c][h] != null)
							if(timetableLab[c][h].compareTo(labID) == 0)
								t[r][d] = subjects.get(subjects.indexOf(new Subject(timetableSubject[c][h]))).getName() + "\n" 
									+ classes.get(c).getGrade() + " " + classes.get(c).getSection();
					}
					r++;
			}
		}
		
		return t;
	}
	
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
	
	public void stamp() {
		for(int i =0; i<classes.size(); i++) {
			System.out.print(classes.get(classes.size()-(i+1)).getClassID() + " | ");
			for(int k = 0; k<numHoursWeek; k++) 
				System.out.print(timetableSubject[i][k] + " ");
			System.out.println();
		}
		System.out.println("Numero professori non soddisfatti " + countNotSatisfied);
	}
	
}
