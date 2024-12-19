package com.his.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.his.gui.ButtonPanel;
import com.his.gui.DoctorInfoPanel;
import com.his.gui.GeneralNotesPanel;
import com.his.gui.LabExaminationsPanel;
import com.his.gui.MedicalHistoryPanel;
import com.his.gui.PatientDetailsPanel;
import com.his.gui.PatientPanel;
import com.his.gui.PrescribedMedicinePanel;
import com.his.model.Appointment;
import com.his.model.Doctor;
import com.his.model.MedicalHistory;
import com.his.model.Patient;
import com.his.model.Prescription;

public class EPrescriptionApp extends JFrame {
	

	//HeaderPanel headerPanel = new HeaderPanel();
	PatientPanel patientPanel = new PatientPanel(this);
	DoctorInfoPanel doctorInfoPanel = new DoctorInfoPanel(this,patientPanel);
	MedicalHistoryPanel medicalHistoryPanel = new MedicalHistoryPanel();
	PatientDetailsPanel patientDetailsPanel = new PatientDetailsPanel(medicalHistoryPanel);
	GeneralNotesPanel generalNotesPanel = new GeneralNotesPanel();
	PrescribedMedicinePanel prescribedMedicinePanel = new PrescribedMedicinePanel();
	LabExaminationsPanel labExaminationsPanel = new LabExaminationsPanel();
	Doctor doctor;
	Patient patient;
	private ObjectMapper mapper = new ObjectMapper();
	ArrayList<Appointment> appointments;
	ArrayList<Prescription> prescriptions;
	public static Appointment appointment;
	ButtonPanel buttonPanel;
	Prescription prescription;
	public EPrescriptionApp() {
		setTitle("Doctor Consultation");
		setSize(1200, 900);
		try {
			prescriptions = mapper.readValue(new File("Prescription.json"), new TypeReference<ArrayList<Prescription>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			prescriptions=new ArrayList<Prescription>();
		}
		try {
			appointments = mapper.readValue(new File("Appointments.json"), new TypeReference<ArrayList<Appointment>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			appointments = new ArrayList<Appointment>();
		}
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel headerPanel=new JPanel(new BorderLayout());
		headerPanel.setBackground(new Color(0,150,139));
		
		JLabel headerLabel=new JLabel("Consultation",JLabel.CENTER);
//		headerLabel.setOpaque(true);
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("Arial",Font.BOLD,20));
		headerPanel.add(headerLabel);
		
		
		

		buttonPanel = new ButtonPanel(this,() -> {
			doctorInfoPanel.doctorNameField.setText("");
			patientDetailsPanel.patientNameField.setText("");
			patientDetailsPanel.MRD.setText("");
			labExaminationsPanel.labExamsCombo.setSelectedIndex(0);
			labExaminationsPanel.labExaminatinsArea.setText("");
			prescribedMedicinePanel.medicinesCombo.setSelectedIndex(0);
			prescribedMedicinePanel.prescribedMedicinesArea.setText("");
			generalNotesPanel.generalNotesArea.setText(" ");
		//	medicalHistoryPanel.medicalHistoryArea.setText("");
		});

		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GridBagLayout());
		panelMain.setPreferredSize(new Dimension(900, 800));
		panelMain.setSize(900, 800);
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setBackground(Color.WHITE);
		
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(5, 0, 5, 0);

		// gc.weightx=1.0;
		gc.weighty = 1.0;

		gc.gridx = 0;
		gc.gridy = 0;
		panelMain.add(doctorInfoPanel, gc);
		
		
		gc.gridy = 1;
		panelMain.add(patientDetailsPanel, gc);

		gc.gridy = 2;
		panelMain.add(medicalHistoryPanel, gc);

		gc.gridy = 3;
		panelMain.add(generalNotesPanel, gc);

		gc.gridy = 4;
		panelMain.add(prescribedMedicinePanel, gc);

		gc.gridy = 5;
		panelMain.add(labExaminationsPanel, gc);

		gc.gridy = 6;
		panelMain.add(buttonPanel, gc);

		add(panelMain, BorderLayout.CENTER);
		add(headerPanel,BorderLayout.NORTH);
		

//        add(buttonPanel,BorderLayout.SOUTH);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, patientPanel,
				new JScrollPane(panelMain));
		splitPane.setDividerLocation(300);
		splitPane.setResizeWeight(0.2);
		splitPane.disable();

		add(splitPane, BorderLayout.CENTER);

		setVisible(true);

	}

	public DoctorInfoPanel getDoctorInfoPanel() {
		return doctorInfoPanel;
	}

	public MedicalHistoryPanel getMedicalHistoryPanel() {
		return medicalHistoryPanel;
	}

	public PatientDetailsPanel getPatientDetailsPanel() {
		return patientDetailsPanel;
	}

	public GeneralNotesPanel generalNotesPanel() {
		return generalNotesPanel;

	}
	public PrescribedMedicinePanel getPrescribedMedicinePanel() {
		return prescribedMedicinePanel;
	}
	public LabExaminationsPanel getLabExaminationsPanel() {
		return labExaminationsPanel;
	}


	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}


	public static void main(String[] args) {
		try {
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if("Nimbus".equals(info.getClassName()));{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
						
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		SwingUtilities.invokeLater(()-> new EPrescriptionApp());
		
		
	}

	public void doctorSelected(Doctor doctor) {
		//patientDetailsPanel.patientNameField.setText(appointment.getPatient().getName());
		//patientDetailsPanel.MRD.setText(new Integer(appointment.getPatient().getId()).toString());
		doctorInfoPanel.doctorNameField.setText(doctor.getName());
		this.doctor = doctor;
	}
	public void patientSelected(Patient patient) {
		patientDetailsPanel.patientNameField.setText(patient.getName());
		patientDetailsPanel.MRD.setText(new Integer(patient.getId()).toString());
		this.patient=patient;
		for(Appointment appointment:appointments) {
			if(appointment.getDoctor().equals(doctor)&&appointment.getPatient().equals(patient)) {
				this.appointment=appointment;
				break;
			}
		}
		
		for(Prescription prescription:prescriptions) {
			if(prescription.getAppointment().getPatient().equals(patient)) {
				MedicalHistoryPanel.medicalHistories.add(prescription.getMedicalHistory());
			}
		}
		medicalHistoryPanel.tableModel.fireTableDataChanged();
//		for(Prescription prescription: prescriptions) {
//			System.out.println(prescription);
//			if(prescription.getAppointment().equals(appointment)) {
//				this.prescription=prescription;
//				medicalHistoryPanel.medicalHistoryArea.setText(prescription.getMedicalHistory());
//				break;
//			}
//		}
	}
	public Prescription getPrescriptionObject() {
		Prescription prescription =new Prescription(appointment,LocalDate.now().toString(),
				medicalHistoryPanel.medicalHistory,
				labExaminationsPanel.labExaminatinsArea.getText(),
				prescribedMedicinePanel.prescribedMedicinesArea.getText());
		return prescription; 
	} 
}


