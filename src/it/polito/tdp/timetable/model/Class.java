package it.polito.tdp.timetable.model;

import java.util.HashMap;
import java.util.Map;

public class Class {
	
	private String classID;
	private int grade;
	private String section;
	private String courseID;
	private Map<String,String> mapSubjectTeacher;
	
	public Class(String classID, int grade, String section, String courseID, Map<String,String> mapSubjectTeacher) {
		super();
		this.classID = classID;
		this.grade = grade;
		this.section = section;
		this.courseID = courseID;
		this.mapSubjectTeacher = mapSubjectTeacher;
	}
	
	public Class(String classID, int grade, String section, String courseID) {
		super();
		this.classID = classID;
		this.grade = grade;
		this.section = section;
		this.courseID = courseID;
		this.mapSubjectTeacher = new HashMap<>();
	}
	public Class(String classID) {
		this.classID = classID;
	}
	
	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}	

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public Map<String, String> getMapSubjectTeacher() {
		return mapSubjectTeacher;
	}

	public void setMapSubjectTeacher(Map<String, String> mapSubjectTeacher) {
		this.mapSubjectTeacher = mapSubjectTeacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classID == null) ? 0 : classID.hashCode());
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
		Class other = (Class) obj;
		if (classID == null) {
			if (other.classID != null)
				return false;
		} else if (!classID.equals(other.classID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return grade  + section + " [" + courseID
				+ "]";
	}
	
	
	

}
