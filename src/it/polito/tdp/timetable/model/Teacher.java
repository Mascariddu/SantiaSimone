package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	
	private final static int DAYS = 3; // Numero dei giorni possibili da specificare per giorno di riposo
	
	private String teacherID;
	private String name;
	private String surname;
	private int hoursWeek;
	private int[] preferencesDay;
	private List<Subject> enablingSub;
	
	public Teacher(String teacherID, String name, String surname, int hoursWeek, int[] preferencesDay,
			List<Subject> enablingSub) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.surname = surname;
		this.hoursWeek = hoursWeek;
		this.preferencesDay = new int[DAYS];
		this.enablingSub = new ArrayList<Subject>();
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

	public int[] getPreferencesDay() {
		return preferencesDay;
	}

	public void setPreferencesDay(int[] preferencesDay) {
		this.preferencesDay = preferencesDay;
	}

	public List<Subject> getEnablingSub() {
		return enablingSub;
	}

	public void setEnablingSub(List<Subject> enablingSub) {
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
	
	
	
	
}