package com.his.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PrescribedMedicinePanel extends JPanel {

	public JComboBox<String> medicinesCombo;
	public JTextArea prescribedMedicinesArea;
	JTextField dosageField;
	JTextField timePeriod;
	JButton timePeriodButton;
	JButton clearButton;

	public PrescribedMedicinePanel() {

		setBorder(BorderFactory.createTitledBorder("Prescribed Medicines"));
		setLayout(new BorderLayout());

		String[] medicines = { "Aspirin", "Paracetamol", "Mefthal", "Ciprofloxacin" };
		medicinesCombo = new JComboBox<>(medicines);
		dosageField = new JTextField(10);
		timePeriod = new JTextField(10);
		prescribedMedicinesArea = new JTextArea(5, 30);
		prescribedMedicinesArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(prescribedMedicinesArea);
		JPanel inputPanel = new JPanel(new FlowLayout());
	//	JButton dosageButton = new JButton("Add");
		timePeriodButton = new JButton("Add");
		clearButton = new JButton("Clear");

		inputPanel.add(new JLabel("Medicine: "));
		inputPanel.add(medicinesCombo);
		inputPanel.add(new JLabel("Dosage: "));
		inputPanel.add(dosageField);
		
		inputPanel.add(new JLabel("Medication Period: "));
		inputPanel.add(timePeriod);
		inputPanel.add(timePeriodButton);
		inputPanel.add(clearButton);
		
		clearButton.setBackground(new Color(0,150,139));
		clearButton.setForeground(Color.WHITE);
		
		timePeriodButton.setBackground(new Color(0,150,139));
		timePeriodButton.setForeground(Color.WHITE);
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));
		setBackground(Color.white);

		
		timePeriodButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedMedicine = (String) medicinesCombo.getSelectedItem();
				String dosage = dosageField.getText().trim();
				String medicationtime = timePeriod.getText().trim(); 
			//	List<Object> medicalHistoryList = new ArrayList<>();
				
			//	medicalHistoryList.add(Med);
						

				if (medicationtime.isEmpty()) {
					JOptionPane.showMessageDialog(PrescribedMedicinePanel.this, "ENTER MEDICATION TIME", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					prescribedMedicinesArea.append(selectedMedicine + "-Dosage: " + dosage + "Medication time : "+medicationtime+"\n");
					timePeriod.setText("");
				}
				
				
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				prescribedMedicinesArea.setText("");
				medicinesCombo.setSelectedIndex(0);
				dosageField.setText("");
				
			}
		});

		add(inputPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

	}

	public String getPrescribedMedicine() {
		return prescribedMedicinesArea.getText();
	}

	public void ClearActionListener() {
		prescribedMedicinesArea.setText("");
		medicinesCombo.setSelectedIndex(0);
		dosageField.setText("");

	}

	public void clear() {
		prescribedMedicinesArea.setText("");
		medicinesCombo.setSelectedIndex(0);
		dosageField.setText("");
	}

}
