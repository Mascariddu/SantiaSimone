package it.polito.tdp.timetable.model;

public class School {
	private String schoolID;
	private String name;
	private String Adress;
	private int startLessons;
	private int endLessons;
	private int workDays;
	
	public School(String schoolID, String name, String adress, int startLessons, int endLessons, int workDays) {
		super();
		this.schoolID = schoolID;
		this.name = name;
		Adress = adress;
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
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
	
	
	
}
