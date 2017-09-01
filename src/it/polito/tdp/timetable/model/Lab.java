package it.polito.tdp.timetable.model;

public class Lab {
	
	private String labID;
	private String name;
	private String type;
	
	public Lab(String labID, String name, String type) {
		super();
		this.labID = labID;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
