package com.his.model;

import java.util.ArrayList;
import java.util.Date;

public class MedicalHistory {

	private String history;
	private String date;
	public String getHistory() {
		return history;
	}
	public String getDate() {
		return date;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public MedicalHistory(String history, String date) {
		super();
		this.history = history;
		this.date = date;
	}
	public MedicalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}