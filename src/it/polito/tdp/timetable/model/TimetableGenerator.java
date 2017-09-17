package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimetableGenerator {
	
	private List<Class> classes;
	private List<Teacher> teachers;
	private List<Course> courses;
	private int numHoursWeek;
	private int numHoursDay;
	private boolean trovato;
	private int countNotSatisfied;
	private String[][] timetableSubject;
	
	public TimetableGenerator(List<Class> classes, List<Teacher> teachers, List<Course> courses,
			int numHoursWeek, int numHoursDays) {
		super();
		this.classes = classes;
		this.teachers = teachers;
		this.courses = courses;
		this.numHoursWeek = numHoursWeek;
		this.numHoursDay = numHoursDays;
	}
	
	public void generateTimetable() {
		String[][]tmS = new String[classes.size()][numHoursWeek];
		String[][]tmT = new String[classes.size()][numHoursWeek];
		Class c = classes.iterator().next();
		Map<String, Integer> cs = new HashMap<>(courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject());
		this.trovato = false;
		this.countNotSatisfied = 0;
		
		recursive(tmS, tmT, c, cs, 0, 0);
	}
	
	public void recursive(String [][] tmS, String [][] tmT, Class c, Map<String, Integer> cs, int x, int y) {	
		List<String> listKey = new ArrayList<String>(c.getMapSubjectTeacher().keySet());
		int countBusy = 0;
		
		while(listKey.iterator().hasNext()) {
			
			if(trovato || countBusy>(listKey.size()*2))
				break;
			
			String sbj = listKey.iterator().next();
			Teacher tch = teachers.get(teachers.indexOf(new Teacher(c.getMapSubjectTeacher().get(sbj))));
			Boolean busy = false;
				
			if(cs.get(sbj) > 0) {			
				
				for(int i = y; i >= 0 ; i--)
					if(tmT[i][x] != null)
						if(tmT[i][x].compareTo(tch.getTeacherID()) == 0 ) {
							busy = true;
							listKey.remove(sbj);
							listKey.add(sbj);
							countBusy++;
						}
				
				if ((x >= tch.getFreeDay()*numHoursDay && x <= tch.getFreeDay()*(numHoursDay+1))) {
					if(countBusy < listKey.size()) {
						busy = true;
						listKey.remove(sbj);
						listKey.add(sbj);
						countBusy++;
					} else {
						countNotSatisfied++;
					}
				}
					
				
				if(!busy) {
					tmS[y][x] = sbj;
					tmT[y][x] = tch.getTeacherID();
					
					cs.put(sbj, cs.get(sbj)-1);
					recursive(tmS, tmT, c, cs, x+1, y);
					cs.put(sbj, cs.get(sbj)+1);
				}
				
			} else {
				
				listKey.remove(sbj);
				
				if(listKey.isEmpty()) {
					classes.remove(c);
					
					if(classes.isEmpty()) {
						trovato = true;
						this.timetableSubject = tmT;
						classes.add(c);
						break;
					}
					
					Class nw = classes.iterator().next();
					cs = new HashMap<>(courses.get(courses.indexOf(new Course(nw.getCourseID()))).getMapSubject());
					recursive(tmS, tmT, nw, cs, 0, y+1);
					classes.add(c);
				}
			}
		}
		
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
