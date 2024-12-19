package com.his.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.his.app.EPrescriptionApp;
import com.his.model.Patient;
import com.his.model.Prescription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ButtonPanel extends JPanel {
	String prescriptionJsonFilePath ="Prescription.json";
	public ClearActionListener clearActionListener;
	ClearActionListener clearAction;

	public ButtonPanel(EPrescriptionApp ePrescriptionApp, ClearActionListener clearActionListener) {

		this.clearActionListener = clearActionListener;

		setLayout(new FlowLayout());

		JButton saveButton = new JButton("Save");
		JButton clearButton = new JButton("Clear");
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(0,150,139));
		submitButton.setForeground(Color.WHITE);
		
		

		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				savePrescriptionToJson();

			}

			private void savePrescriptionToJson() {
				/*
				 * try { PatientModelClass record = new PatientModelClass(); record.setName(pa);
				 * }
				 * 
				 */
			}
		});

		// clearButton.addActionListener(e-> JOptionPane.showMessageDialog(this,
		// "clear"));
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource()!=null) {
					Prescription prescription = ePrescriptionApp.getPrescriptionObject();

						ObjectMapper objectMapper = new ObjectMapper();
						List<Prescription> prescriptions = new ArrayList<>();
						File file = new File(prescriptionJsonFilePath);
						if(file.exists()) {
							try {
								prescriptions = objectMapper.readValue(file, new TypeReference<ArrayList<Prescription>>() {});
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					//	Prescription updatedPrescription =newPrescription();
						
						prescriptions.add(prescription);
						
						try {
							objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, prescriptions);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println("Prescription details added successfully");
					}
				}
				
		});

	//	add(clearButton);
		add(submitButton);
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));
		setBackground(Color.white);
		setVisible(true);
		
		clearButton.addActionListener((e) -> {
			clearActionListener.clearActionPerformed();
		});
	}

}
