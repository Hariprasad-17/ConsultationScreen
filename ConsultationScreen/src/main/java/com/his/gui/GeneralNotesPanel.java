package com.his.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class GeneralNotesPanel extends JPanel {

	public JTextArea generalNotesArea;
	ClearActionListener clearAction;
	public JButton clear;

	public GeneralNotesPanel() {
		
		

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));

		setBorder(BorderFactory.createTitledBorder("General Notes for Doctor"));
		setLayout(new BorderLayout());
		setBackground(Color.white);
		

		generalNotesArea = new JTextArea(5, 30);
		JScrollPane scroll = new JScrollPane(generalNotesArea);
		add(scroll, BorderLayout.CENTER);
		

	}


	public void ClearActionListener() {
		generalNotesArea.setText("");
		
	}
	public void clear() {
		generalNotesArea.setText(" ");
	}

}
