package com.his.model;

public class Doctor {

	private int id;
	private String name;
	private String contact;
	private int age;
	private String specialization;
	private String startTime;
	private String endTime;


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	public int getAge() {
		return age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
