package com.Ep.gui;

import com.Ep.bean.EP;
import com.Ep.daoimpl.EpDaoImpl;
import java.util.List;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EuropePopulation {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable table;
	private static DefaultTableModel model;

	static EpDaoImpl dd = new EpDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EuropePopulation window = new EuropePopulation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EuropePopulation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				String Cname = textField_1.getText();
				Float Cpopulation = Float.parseFloat(textField_2.getText());
				EP ep = new EP();
				ep.setId(id);
				ep.setCname(Cname);
				ep.setCpopulation(Cpopulation);
				dd.addEP(ep);
				JOptionPane.showMessageDialog(null, "Data Added succesfully");
				viewTable();
			}
		});
		btnNewButton.setBounds(33, 348, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				EP country = dd.findById(id);
				country.setCname(textField_1.getText());
				country.setCpopulation(Float.parseFloat(textField_2.getText()));
				dd.update(country);
				JOptionPane.showMessageDialog(null, "Data updated succesfully");
			}
		});
		btnNewButton_1.setBounds(147, 348, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTable();
			}
		});
		btnNewButton_2.setBounds(265, 348, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = textField.getText();
				EP ep = new EP();
				ep.getCname();
				dd.delByName(Name);
				JOptionPane.showMessageDialog(null, "deleted success fully");
			}
		});
		btnNewButton_3.setBounds(394, 348, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		textField = new JTextField();
		textField.setBounds(473, 46, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(473, 108, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(473, 178, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(381, 49, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(381, 111, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Population");
		lblNewLabel_2.setBounds(381, 181, 82, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 50, 295, 256);
		frame.getContentPane().add(scrollPane);

		table = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Population" }));
		scrollPane.setViewportView(table);

	}

	public static void viewTable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<EP> ep = dd.findAll();
		for (EP ep2 : ep) {
			Object[] dataTable = { ep2.getId(), ep2.getCname(), ep2.getCpopulation() };
			model.addRow(dataTable);
		}
	}
}
