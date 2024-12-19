package com.his.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Prescription {
	
	private Appointment appointment;
	private String date;
	private MedicalHistory medicalHistory;
	private String labExaminations;
	private String prescribedMedicine;
	
	public Appointment getAppointment() {
		return appointment;
	}
	public String getDate() {
		return date;
	}

	public String getLabExaminations() {
		return labExaminations;
	}
	public String getPrescribedMedicine() {
		return prescribedMedicine;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public void setLabExaminations(String labExaminations) {
		this.labExaminations = labExaminations;
	}
	public void setPrescribedMedicine(String prescribedMedicine) {
		this.prescribedMedicine = prescribedMedicine;
	}
	
	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prescription(Appointment appointment, String date, MedicalHistory medicalHistory, String labExaminations,
			String prescribedMedicine) {
		super();
		this.appointment = appointment;
		this.date = date;
		this.medicalHistory = medicalHistory;
		this.labExaminations = labExaminations;
		this.prescribedMedicine = prescribedMedicine;
	}
	

}
