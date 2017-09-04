package it.polito.tdp.timetable.model;

import java.util.List;

import it.polito.tdp.timetable.db.TimetableDAO;

public class Model {

	private TimetableDAO dao;
	private School school;
	
	public Model() {
		super();
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
