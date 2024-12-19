package com.his.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.his.model.MedicalHistory;

public class MedicalHistoryPanel extends JPanel {
	public JTable medicalHistoryTable;
	ClearActionListener clearAction;
	public JButton addButton;
	public static ArrayList<MedicalHistory> medicalHistories=new ArrayList<MedicalHistory>();
	public MedicalHistory medicalHistory;
	JTextField notesField = new JTextField(/*"Enter notes Here"*/);
	public AbstractTableModel tableModel;
	public MedicalHistoryPanel() {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#64B5F6")),null, TitledBorder.LEFT,
				TitledBorder.TOP, new Font("Arial" , Font.BOLD, 14),Color.decode("#1565C0")));
	
		setBorder(BorderFactory.createTitledBorder("Patient Medical History"));
		setLayout(new BorderLayout());
		setBackground(Color.white);
		

		String[] columnNames = {"Date","Patient Medical History"};
		addButton = new JButton("Add");
		addButton.setBackground(new Color(0,150,139));
		addButton.setForeground(Color.WHITE);
		
		tableModel = new AbstractTableModel() {

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return medicalHistories.size();
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 2;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				MedicalHistory history = medicalHistories.get(rowIndex);
				switch (columnIndex){
					case 0:
						return history.getDate();
					case 1:
						return history.getHistory();
					default:
						return null;
				}	
			}

			@Override
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return columnNames[column];
			}
			
		};
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String newData = notesField.getText();
				System.out.println(newData);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String date = LocalDate.now().toString();
				medicalHistory = new MedicalHistory(newData, date);
				medicalHistories.add(medicalHistory);
				tableModel.fireTableDataChanged();
			//	addButton.setVisible(false);
			}
		});
		
		
		medicalHistoryTable = new JTable(tableModel);
		medicalHistoryTable.setPreferredScrollableViewportSize(new Dimension(300,80));
		JScrollPane scrollPane = new JScrollPane(medicalHistoryTable);
		
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new FlowLayout());
		newPanel .add(addButton);
		
		
		add(notesField,BorderLayout.CENTER);
		add(scrollPane, BorderLayout.NORTH);
		
		add(newPanel, BorderLayout.SOUTH);

	}
	
	
	public void addMedicalHistory(String history, String date) {
		DefaultTableModel model = (DefaultTableModel) medicalHistoryTable.getModel();
		model.addRow(new Object[] {history,date});
	}

	public void ClearActionListener () {
		
		DefaultTableModel model = (DefaultTableModel) medicalHistoryTable.getModel();
		model.setRowCount(0);
		
	}
	

}
