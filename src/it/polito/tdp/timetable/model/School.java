package it.polito.tdp.timetable.model;

public class School {
	private String schoolID;
	private String name;
	private String address;
	private int startLessons;
	private int endLessons;
	private int workDays;
	
	public School(String schoolID, String name, String address, int startLessons, int endLessons, int workDays) {
		super();
		this.schoolID = schoolID;
		this.name = name;
		this.address = address;
		this.startLessons = startLessons;
		this.endLessons = endLessons;
		this.workDays = workDays;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public String getName() {
		return this.name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return this.address.toUpperCase();
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	public int getStartLessons() {
		return startLessons;
	}

	public void setStartLessons(int startLessons) {
		this.startLessons = startLessons;
	}

	public int getEndLessons() {
		return endLessons;
	}

	public void setEndLessons(int endLessons) {
		this.endLessons = endLessons;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	@Override
	public String toString() {
		return "[" + schoolID + "] " + name.toUpperCase() + " - " + address.toUpperCase();
	}
	
	
	
}
