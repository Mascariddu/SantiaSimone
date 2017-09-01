package it.polito.tdp.timetable.model;

import it.polito.tdp.timetable.db.TimetableDAO;

public class Model {

	private TimetableDAO dao;
	public School school;
	
	public Model() {
		super();
		

	}
	
	public School getSchool() {
		return school;
	}
	
}
