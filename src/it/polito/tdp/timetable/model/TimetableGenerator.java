package it.polito.tdp.timetable.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimetableGenerator {
	
	private List<Class> classes;
	private List<Teacher> teachers;
	private List<Course> courses;
	private int numHoursWeek;
	private int numHoursDay;
	private int numDays;
	private boolean trovato;
	private int countNotSatisfied;
	private long timeProcess;
	
	private String[][] timetableSubject;
	private String[][] timetableTeacher;
	
	public TimetableGenerator(List<Class> classes, List<Teacher> teachers, List<Course> courses,
			int numHoursWeek, int numHoursDays, int numDays) {
		super();
		this.classes = classes;
		this.teachers = teachers;
		this.courses = courses;
		this.numHoursWeek = numHoursWeek;
		this.numHoursDay = numHoursDays;
		this.numDays = numDays;
	}
	

	
	public void generateTimetable() {
		String[][]tmS = new String[classes.size()][numHoursWeek];
		String[][]tmT = new String[classes.size()][numHoursWeek];
		Class c = classes.iterator().next();
		Map<String, Integer> cs = new HashMap<>(courses.get(courses.indexOf(new Course(c.getCourseID()))).getMapSubject());
		
		this.trovato = false;
		this.countNotSatisfied = 0;
		
		long start = System.currentTimeMillis();
		recursive(tmS, tmT, c, cs, 0, 0);
		long end = System.currentTimeMillis();
		
		this.timeProcess = end - start;
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
					} else countNotSatisfied++;
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
						this.timetableSubject = tmS;
						this.timetableTeacher = tmT;
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
	
	public int getCountNotSatisfied() {
		return countNotSatisfied;
	}
	
	public long getTimeProcess() {
		return timeProcess/1000;
	}

	public String[][] getTimetableByClass(String classID) {

		String[][] t = new String[numHoursDay][numDays];
		int s = 0;
		int p = classes.indexOf(new Class(classID));	
		
		for(int d = 0; d<numDays; d++) {
			for(int h = 0; h < numHoursDay; h++) {
				t[h][d] = timetableSubject[p][s];
				s++;
			}	
		}
		
		return t;
	}
	
/*
	public TableView<Line> getTimetableBySubject() {
		TableView<Line> tv = newTableView();
		ObservableList<Line> lineData = FXCollections.observableArrayList();

		for(int h = 0; h < numHoursDay; h++) {
			String[] s;
			s[0] = String.valueOf(h);
			for(int d = 0; d < numDays; d++ )
				s[d+1] = timetableSubject[0][h*d];
						
			lineData.add(new Line(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
		}
		
		for(int i = 0; i<tv.getColumns().size(); i++)
			tv.getColumns().get(i).setCellValueFactory(new PropertyValueFactory<Line, String>("mon"));
		
		return tv;
	}
	
	private TableView<Line> newTableView() {
		List<TableColumn<Line, String>> c = new LinkedList<>();
		TableView<Line> tv = new TableView<Line>();
		
		c.add(new TableColumn<>("Lunedì"));
		c.add(new TableColumn<>("Martedì"));
		c.add(new TableColumn<>("Mercoledì"));
		c.add(new TableColumn<>("Giovedì"));
		c.add(new TableColumn<>("Venerdì"));
		c.add(new TableColumn<>("Sabato"));
		
		for(int i = 0; i < numDays; i++)
			tv.getColumns().add(c.get(i));
		
		return tv;
	}
	
	public class Line {
		private String h;
		private final StringProperty mon;
		private String tue;
		private String wen;
		private String thu;
		private String fri;
		private String sat;
		
		public Line(String h, String mon, String tue, String wen, String thu, String fri, String sat) {
			super();
			this.h = h;
			this.mon = new SimpleStringProperty(mon);
			this.tue = tue;
			this.wen = wen;
			this.thu = thu;
			this.fri = fri;
			this.sat = sat;
		}

		public String getH() {
			return h;
		}

		public StringProperty getMon() {
			return mon;
		}

		public String getTue() {
			return tue;
		}

		public String getWen() {
			return wen;
		}

		public String getThu() {
			return thu;
		}

		public String getFri() {
			return fri;
		}

		public String getSat() {
			return sat;
		}
		
		
		
	}
*/
}
