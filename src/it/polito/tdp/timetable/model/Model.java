package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.timetable.db.TimetableDAO;
import javafx.collections.ObservableList;

public class Model {

	private TimetableDAO dao;
	private School school;
	private List<Subject> subjects;
	private List<Course> courses;
	
	
	public Model() {
		super();
		this.subjects = new ArrayList<>();
		this.courses = new ArrayList<>();
	}
	
	public List<Subject> getAllSubjects() {
		if(subjects.isEmpty()) {
			this.dao = new TimetableDAO();
			this.subjects = dao.getAllSubjects(school.getSchoolID());
		}
		return subjects;
	}
	
	public List<Course> getAllCourses() {
		if(courses.isEmpty()) {
			this.dao = new TimetableDAO();
			this.courses = dao.getAllCourses(school.getSchoolID());
		}
		return courses;
	}
	
	public Course addNewCourse(String name, int hoursWeek, List<Subject> items) {
		this.dao = new TimetableDAO();
		int num = this.courses.size() + 1;
		
		Course c = new Course("CRS00"+num, name, hoursWeek);
		c.setListSubject(items);
		dao.addNewCourse(c,school.getSchoolID());
		courses.add(c);
		return c;
		
	}
	
	public Subject addNewSubject(String name, int hoursWeek, int hoursLab, String typeLab) {
		this.dao = new TimetableDAO();
		int num = this.subjects.size() + 1;
		
		Subject s = new Subject("SJB00"+num, name, hoursWeek, hoursLab, typeLab);
		dao.addSubject(s,school.getSchoolID());
		subjects.add(s);
		return s;
	}
	
	public void updateSubject(Subject s) {
		this.dao = new TimetableDAO();
		dao.updateSubject(s, school.getSchoolID());
		
		subjects.remove(s);
		subjects.add(s);
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public School getSchool() {
		return this.school;
	}
	
	public List<School> getAllSchools() {
		this.dao = new TimetableDAO();
		return dao.getAllSchools();
	}
	
	public void addSchool(String name, String address, int startLessons, int endLessons, int workDays) {
		this.dao = new TimetableDAO();
		int num = dao.getAllSchools().size() + 1;
		School s = new School("SCH00"+num, name, address, startLessons, endLessons, workDays);
		dao.addSchool(s);
	}

}
