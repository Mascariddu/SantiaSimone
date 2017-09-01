package it.polito.tdp.timetable.model;

public class Subject {
	
	private String subjectID;
	private String name;
	private int hoursWeek;
	private int hoursLab;
	private int typeLab;
	
	public Subject(String subjectID, String name, int hoursWeek, int hoursLab, int typeLab) {
		super();
		this.subjectID = subjectID;
		this.name = name;
		this.hoursWeek = hoursWeek;
		this.hoursLab = hoursLab;
		this.typeLab = typeLab;
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

	public int getHoursWeek() {
		return hoursWeek;
	}

	public void setHoursWeek(int hoursWeek) {
		this.hoursWeek = hoursWeek;
	}

	public int getHoursLab() {
		return hoursLab;
	}

	public void setHoursLab(int hoursLab) {
		this.hoursLab = hoursLab;
	}

	public int getTypeLab() {
		return typeLab;
	}

	public void setTypeLab(int typeLab) {
		this.typeLab = typeLab;
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
	
	

}
