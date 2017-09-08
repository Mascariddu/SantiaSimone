package it.polito.tdp.timetable.model;

import java.util.List;

public class Teacher {
	
	private String teacherID;
	private String name;
	private String surname;
	private int hoursWeek;
	private int hoursWork;
	private int freeDay;
	private List<String> enablingSub;
	
	public Teacher(String teacherID, String name, String surname, int hoursWeek, int freeDay,
			List<String> enablingSub) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.surname = surname;
		this.hoursWeek = hoursWeek;
		this.hoursWork = 0;
		this.freeDay = freeDay;
		this.enablingSub = enablingSub;
	}
	
	public Teacher(String teacherID, String name, String surname, int hoursWeek, int freeDay) {
		this.teacherID = teacherID;
		this.name = name;
		this.surname = surname;
		this.hoursWeek = hoursWeek;
		this.hoursWork = 0;
		this.freeDay = freeDay;
	}
	
	public Teacher(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}
	
	public int getHoursWork() {
		return hoursWork;
	}

	public void setHoursWork(int hoursWork) {
		this.hoursWork = hoursWork;
	}

	public int getFreeDay() {
		return freeDay;
	}

	public void setPreferencesDay(int freeDay) {
		this.freeDay = freeDay;
	}

	public List<String> getEnablingSub() {
		return enablingSub;
	}

	public void setEnablingSub(List<String> enablingSub) {
		this.enablingSub = enablingSub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teacherID == null) ? 0 : teacherID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (teacherID == null) {
			if (other.teacherID != null)
				return false;
		} else if (!teacherID.equals(other.teacherID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + teacherID + "] " + name + " " + surname;
	}
	
	
	
	
}