package com.his.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.his.model.Prescription;

public class PatientDetailsPanel extends JPanel {

	public JTextField patientNameField;
	public JTextField MRD;
	public JButton historyButton;
	ClearActionListener clearAction;
	static ArrayList<Prescription> prescriptions;
	static ObjectMapper objectMapper = new ObjectMapper();
	
	

	private MedicalHistoryPanel medicalHistoryPanel;

	public PatientDetailsPanel(MedicalHistoryPanel medicalHistoryPanel) {
		this.medicalHistoryPanel = medicalHistoryPanel;
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));
		setBorder(BorderFactory.createTitledBorder("Patient Details"));

		setLayout(new GridBagLayout());
		setBackground(Color.white);
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;

		JLabel patientNameLabel = new JLabel("Patient Name: ");
		patientNameField = new JTextField(20);
		patientNameField.setEditable(false);
		historyButton = new JButton("History");

		gc.gridx = 0;
		gc.gridy = 0;
		add(patientNameLabel, gc);
		gc.gridx = 1;
		add(patientNameField, gc);

		JLabel patientIdLabel = new JLabel("MRD N.O: ");
		MRD = new JTextField(20);
		MRD.setEditable(false);

		gc.gridx = 0;
		gc.gridy = 1;
		add(patientIdLabel, gc);

		gc.gridx = 1;
		add(MRD, gc);
		
		gc.gridy = 2;
		//add(historyButton,gc);
	}
	

	public void ClearActionListener() {
		patientNameField.setText("");
		MRD.setText("");

	}
	
	

}
