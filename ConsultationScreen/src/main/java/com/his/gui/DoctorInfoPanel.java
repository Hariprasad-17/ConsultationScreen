package com.his.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.his.app.EPrescriptionApp;
import com.his.model.Appointment;
import com.his.model.Doctor;
import com.his.model.Patient;

public class DoctorInfoPanel extends JPanel {
	public JTextField doctorIdField;
	public JTextField doctorNameField;
	
	ImageIcon originalIcon = new ImageIcon("C://Users//2021645//Downloads//OIP (1).jpg");
	Image resizedImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	ImageIcon resizedIcon = new ImageIcon(resizedImage);
	JButton searchButton = new JButton(resizedIcon);
	
	
//	JButton searchButton = new JButton(searchIcon);
//	JButton searchButton = new JButton("SEARCH");
	public JTextField dateField;
	
	ClearActionListener clearAction;
	private ArrayList<Appointment> appointments;
	private ObjectMapper mapper = new ObjectMapper();
	public DoctorInfoPanel(EPrescriptionApp ePrescriptionApp,PatientPanel patientPanel) {
		searchButton.setBorder(BorderFactory.createEmptyBorder());

		try {
			appointments = mapper.readValue(new File("Appointments.json"), new TypeReference<ArrayList<Appointment>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No appointments");
			appointments=new ArrayList<Appointment>();
		}
		setLayout(new FlowLayout());
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));
		setBackground(Color.white);
		
		
		JLabel doctorIdLabel = new JLabel("Doctor Id: ");
		JLabel doctorLabel = new JLabel("Doctor's Name: ");
		
		doctorIdField = new JTextField(5);
		doctorNameField = new JTextField(20);
		doctorIdField.setText(" ");
		doctorNameField.setText("");
		doctorNameField.setEditable(false);

		JLabel dateLabel = new JLabel("Date:");
		dateField = new JTextField(15);
		dateField.setText(getCurrentDate());
		dateField.setEditable(false);

		
		add(doctorIdLabel);
		add(doctorIdField);
		add(searchButton);
		add(doctorLabel);
		add(doctorNameField);
		add(dateLabel);
		add(dateField);

		searchButton.addActionListener((e)->{
			Doctor doctor = null;
			ArrayList<Patient> patients = new ArrayList<Patient>();
			for(Appointment appointment:appointments) {
				if(appointment.getDoctor().getId()==Integer.parseInt(doctorIdField.getText().trim())) {
					ePrescriptionApp.doctorSelected(appointment.getDoctor());
					doctor=appointment.getDoctor();
					ePrescriptionApp.appointment=appointment;
				}
			}
			for(Appointment appointment:appointments) {
				if(appointment.getDoctor().equals(doctor)) {
					patients.add(appointment.getPatient());
				}
			}
			patientPanel.patientListModel.removeAllElements();
			patientPanel.patientListModel.addAll(patients);
		});
	}
	

	private String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

	
	
	public void ClearActionListener() {
		
		doctorNameField.setText("");
	}
	
}
