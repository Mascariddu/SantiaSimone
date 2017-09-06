package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	private String courseID;
	private String name;
	private int hoursWeek;
	private List<Subject> listSubject;
	
	public Course(String courseID, String name, int hoursWeek) {
		super();
		this.courseID = courseID;
		this.name = name;
		this.hoursWeek = hoursWeek;
		this.listSubject = new ArrayList<Subject>();
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}

	public List<Subject> getListSubject() {
		return listSubject;
	}

	public void setListSubject(List<Subject> listSubject) {
		this.listSubject = listSubject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
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
		Course other = (Course) obj;
		if (courseID == null) {
			if (other.courseID != null)
				return false;
		} else if (!courseID.equals(other.courseID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + courseID + "] - " + name;
	}
	
	
	
}
