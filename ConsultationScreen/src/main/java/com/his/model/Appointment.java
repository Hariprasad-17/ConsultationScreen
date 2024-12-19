package com.his.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointment {
	@JsonProperty("patient")
	private Patient patient;
	
	@JsonProperty("doctor")
	private Doctor doctor;
	
	@JsonProperty("appointment_Date")
	private String appointments;
	
	@JsonProperty("department")
	private String department;
	
	@JsonProperty("consultation_fee")
	private String consultationfee;
	
	@JsonProperty("appointment_time")
	private String appointmentTime;
	
	public Patient getPatient() {
		return patient;
	}
	

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(Patient patient, Doctor doctor, String appointments, String department, String consultationfee,
			String appointmentTime) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.appointments = appointments;
		this.department = department;
		this.consultationfee = consultationfee;
		this.appointmentTime = appointmentTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getAppointments() {
		return appointments;
	}

	public String getDepartment() {
		return department;
	}

	public String getConsultationfee() {
		return consultationfee;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setAppointments(String appointments) {
		this.appointments = appointments;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setConsultationfee(String consultationfee) {
		this.consultationfee = consultationfee;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "\npatient: "+" "+patient.getName()+patient.getTokenNumber()+"\n docotor: "+doctor.getName()+doctor.getId();
	}

	
}
