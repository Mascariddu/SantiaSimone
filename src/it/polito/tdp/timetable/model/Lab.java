package it.polito.tdp.timetable.model;

public class Lab {
	
	private String labID;
	private String name;
	private int type;
	
	public Lab(String labID, String name, int type) {
		super();
		this.labID = labID;
		this.name = name;
		this.type = type;
	}

	public Lab(String labID) {
		this.labID = labID;
	}

	public String getLabID() {
		return labID;
	}

	public void setLabID(String labID) {
		this.labID = labID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[" + labID + "] " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labID == null) ? 0 : labID.hashCode());
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
		Lab other = (Lab) obj;
		if (labID == null) {
			if (other.labID != null)
				return false;
		} else if (!labID.equals(other.labID))
			return false;
		return true;
	}
	
	
	

}
