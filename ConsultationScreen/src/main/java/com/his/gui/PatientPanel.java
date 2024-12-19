package com.his.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.his.app.EPrescriptionApp;
import com.his.model.Patient;

public class PatientPanel extends JPanel {

	private JList<Patient> patientList;
	DefaultListModel<Patient> patientListModel;
	public PatientPanel(EPrescriptionApp mainFrame) {
		setBorder(BorderFactory.createTitledBorder("Patient Appointment"));
		setLayout(new BorderLayout());
		setBackground(Color.white);
		setBorder(BorderFactory.createEtchedBorder());
		patientListModel = new DefaultListModel<Patient>();
		patientList = new JList<Patient>(patientListModel);
		patientList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO Auto-generated method stub
				Patient patient = patientListModel.get(patientList.getSelectedIndex());
				mainFrame.patientSelected(patient);
			}

		});


		JScrollPane scrollPane = new JScrollPane(patientList);

		add(scrollPane, BorderLayout.CENTER);

	}

}
