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
	
	public TimetableGenerator(Model model) {
		super();
		this.model = model;
		this.classes = model.getAllClasses();
		this.teachers = model.getAllTeachers();
		this.courses = model.getAllCourses();
		this.subjects = model.getAllSubjects();
		this.numHoursWeek = model.getHoursWeekSchool();
		this.numHoursDay = model.getHoursDaySchool();
		this.numDays = model.getSchool().getWorkDays();
	}
	
	public void generateTimetable() {
		String[][]tmS = new String[classes.size()][numHoursWeek];
		String[][]tmT = new String[classes.size()][numHoursWeek];
		this.trovato = false;
		this.countNotSatisfied = 0;
		this.returnedBack = 10;
		this.loops = 0;
		
		Class c = classes.iterator().next();
		Map<String, Integer> cs = new HashMap<>(courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject());
		List<String> listKey = new ArrayList<String>(c.getMapSubjectTeacher().keySet());
		
		long start = System.currentTimeMillis();
		recursive(tmS, tmT, c, listKey, cs, 0, 0);
		long end = System.currentTimeMillis();
		
		classes.clear();
		this.classes = model.getAllClasses();
		this.timeProcess = end - start;
	}
	
	public void recursive(String [][] tmS, String [][] tmT, Class c, List<String> listSub, Map<String, Integer> subHours, int x, int y) {	
		
		int countBusy = 0;
		int tried = 0;
		
		while(listSub.iterator().hasNext()) {
			
			if(trovato || countBusy>(listSub.size()*2) || tried > listSub.size() + 2)
				return;
			
			String sbj = listSub.iterator().next();
			Teacher tch = teachers.get(teachers.indexOf(new Teacher(c.getMapSubjectTeacher().get(sbj))));
			Boolean busy = false;
				
			if(subHours.get(sbj) > 0) {			
				
				for(int i = y; i >= 0 ; i--)
					if(tmT[i][x] != null)
						if(tmT[i][x].compareTo(tch.getTeacherID()) == 0 ) 
							busy = true;
				
				if(x>1 && !busy) 
					if(tmS[y][x-2].compareTo(sbj) == 0) 
						busy = true;
				
				if ((x >= tch.getFreeDay()*numHoursDay && x <= tch.getFreeDay()*(numHoursDay+1)) && !busy) 
					if(countBusy < listSub.size()) 
						busy = true;
					
				
				if(busy) {
					listSub.remove(sbj);
					listSub.add(sbj);
					countBusy++;
				} else {
					
					tmS[y][x] = sbj;
					tmT[y][x] = tch.getTeacherID();
					
					subHours.put(sbj, subHours.get(sbj)-1);
					
					recursive(tmS, tmT, c, listSub, subHours, x+1, y);										
					
					subHours.put(sbj, subHours.get(sbj)+1);
					listSub.remove(sbj);
					listSub.add(sbj);
					
					if(loops > 50)
						if(returnedBack>0) {
							returnedBack--;
							return;
						} else {
							returnedBack = 15;
							loops = 0;
						}	
					
					tried++;
					loops++;
				}
				
			} else listSub.remove(sbj);
			
		}
		
		if(listSub.isEmpty()) {
			classes.remove(c);
			
			if(classes.isEmpty()) {
				trovato = true;
				this.timetableSubject = tmS;
				this.timetableTeacher = tmT;
				return;
			}
			
			Class nw = classes.iterator().next();
			
			recursive(tmS, tmT, nw, 
					new ArrayList<String>(nw.getMapSubjectTeacher().keySet()), 
					new HashMap<>(courses.get(courses.indexOf(new Course(nw.getCourseID()))).getMapSubject()), 
					0, y+1);
			
			classes.add(c);
		}
		
	}

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
	
	public int getCountNotSatisfied() {
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
