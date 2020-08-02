package com.openshift.coursecatalogue.model;

public class Filter {
	
	private String technology;
	
	private String level;

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Filter(String technology, String level) {
		super();
		this.technology = technology;
		this.level = level;
	}
	
	

}
