package com.his.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class LabExaminationsPanel extends JPanel {

	public JComboBox<String> labExamsCombo;
	public JTextArea labExaminatinsArea;
	ClearActionListener clearAction;
	JButton clear = new JButton("Clear");

	public LabExaminationsPanel() {
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));

		setBorder(BorderFactory.createTitledBorder("Select Lab Examinations"));
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		clear.setBackground(new Color(0,150,139));
		clear.setForeground(Color.WHITE);
		

		String[] labExams = { "Blood Test", "X-Ray", "Ultrasound", "CT Scan", "MRI" };
		labExamsCombo = new JComboBox<>(labExams);

		labExaminatinsArea = new JTextArea(5, 30);
		labExaminatinsArea.setEditable(false);

		add(labExamsCombo,BorderLayout.NORTH);
		add(clear,BorderLayout.EAST);
		add(labExaminatinsArea, BorderLayout.CENTER);
		add(clear,BorderLayout.SOUTH);

		labExamsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedMedicine = (String) labExamsCombo.getSelectedItem();
				labExaminatinsArea.append(selectedMedicine + "\n");
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				labExamsCombo.setSelectedIndex(0);
				labExaminatinsArea.setText(" ");
				
				
			}
		});

	}

	public void ClearActionListener() {
		
	}

	public void clear() {
	
		labExamsCombo.setSelectedIndex(0);
		labExaminatinsArea.setText(" ");
		
	}


}
