package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course {

	private String courseID;
	private String name;
	private int grade;
	private Map<String, Integer> mapSubject;
	
	public Course(String courseID, int grade, String name) {
		super();
		this.courseID = courseID;
		this.grade = grade;
		this.name = name;
	}

	public Course(String courseID, int grade, String name, Map<String, Integer> mapSubject) {
		super();
		this.courseID = courseID;
		this.name = name;
		this.grade = grade;
		this.mapSubject = mapSubject;
	}
	
	public Course(String courseID) {
		this.courseID = courseID;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Map<String, Integer> getMapSubject() {
		return mapSubject;
	}

	public void setMapSubject(Map<String, Integer> mapSubject) {
		this.mapSubject = mapSubject;
	}

	public List<String> getListSubject() {
		return new ArrayList<String>(mapSubject.keySet());
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
		return courseID + " - " + name;
	}
	
	
	
}
