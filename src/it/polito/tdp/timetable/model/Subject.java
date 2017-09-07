package it.polito.tdp.timetable.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private String subjectID;
	private String name;
	private List<Teacher> teachers;
	
	public Subject(String subjectID, String name) {
		super();
		this.subjectID = subjectID;
		this.name = name;
		this.teachers = new ArrayList<Teacher>();
	}
	
	public Subject(String subjectID) {
		this.subjectID = subjectID;
	}
	
	public void addTeacher(Teacher t) {
		teachers.add(t);
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectID == null) ? 0 : subjectID.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectID == null) {
			if (other.subjectID != null)
				return false;
		} else if (!subjectID.equals(other.subjectID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + subjectID + "] " + name;
	}
	
	

}
