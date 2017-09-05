package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.timetable.db.TimetableDAO;

public class Model {

	private TimetableDAO dao;
	private School school;
	private List<Subject> subjects;
	
	
	public Model() {
		super();
		this.subjects = new ArrayList<>();
	}
	
	public List<Subject> getAllSubjects() {
		if(subjects.isEmpty()) {
			this.dao = new TimetableDAO();
			this.subjects = dao.getAllSubjects(school.getSchoolID());
		}
		return subjects;
	}
	
	public Subject addNewSubject(String name, int hoursWeek, int hoursLab, String typeLab) {
		this.dao = new TimetableDAO();
		int num = this.subjects.size() + 1;
		
		Subject s = new Subject("SJB00"+num, name, hoursWeek, hoursLab, typeLab);
		dao.addSubject(s,school.getSchoolID());
		subjects.add(s);
		return s;
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
