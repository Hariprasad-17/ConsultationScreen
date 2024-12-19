package com.his.model;

public class Medicine {

	private String name;
	private String dosage;


	public String getName() {
		return name;
	}

	public String getDosage() {
		return dosage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	@Override
	public String toString() {
		return "Medicine [name=" + name + ", dosage=" + dosage + "]";
	}


}
