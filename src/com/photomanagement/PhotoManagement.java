package com.photomanagement;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.dao.impl.ProfileDaoImpl;
import com.model.Profile;

public class PhotoManagement implements ActionListener {

	private JButton searchButton;
	JTextField namefield;
	JTextField photofield;
	JMenuBar jMenuBar;
	JMenu jMenu;
	JMenuItem menuItem;

	public PhotoManagement() {

		PhotoManagementFrame photoFrame = new PhotoManagementFrame();
		photoFrame.setTitle("PhotoManagement");
		//photoFrame.setSize(150, 150);
		photoFrame.setLayout(new GridLayout(2,1));
		photoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jMenuBar = new JMenuBar();
		jMenu = new JMenu("Photo");
		menuItem = new JMenuItem("Add photo");

		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add photo event");
				new AddProfile();

			}

		});

		jMenuBar.add(jMenu);

		jMenu.add(menuItem);

		JLabel nameLabel = new JLabel("Name");
		JLabel photoLabel = new JLabel("Photo");

		namefield = new JTextField(20);
		photofield = new JTextField(20);

		searchButton = new JButton("Search");

		searchButton.addActionListener(this);

		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout());
		jpanel.add(nameLabel);
		jpanel.add(namefield);

		jpanel.add(photoLabel);
		jpanel.add(photofield);

		jpanel.add(searchButton);
		
		
		DefaultTableModel model= new DefaultTableModel();
		
		ResultSet resultSet=getResultSet();
		
		try {
			for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
				model.addColumn(resultSet.getMetaData().getColumnName(i));
			}
			
			
			while(resultSet.next()) {
				Object[] row=new Object[resultSet.getMetaData().getColumnCount()];
				for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
					row[i-1]=resultSet.getObject(i);
				}
				
				model.addRow(row);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JTable table=new JTable(model);
		
		
		
		
		JPanel dPanel=new JPanel();
		
		dPanel.add(new JScrollPane(table));
		
		
		photoFrame.add(jpanel);
		photoFrame.add(dPanel);

		photoFrame.setJMenuBar(jMenuBar);

		photoFrame.pack();

		photoFrame.setVisible(true);

	}
	
	
	public ResultSet getResultSet() {
		Connection connection;
		ConnectionManager connectionManager;
		ResultSet resultSet=null;
		try {
			connectionManager=new ConnectionManager();
			connection = connectionManager.getConnection();
			
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from person_profile");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new PhotoManagement();
			}

		});

	}

	ArrayList<Profile> getProfileList() {
		ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();

		ArrayList<Profile> profileList = profileDaoImpl.getProfileList();

		return profileList;
	};

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == searchButton) {

			System.out.println("name: " + namefield.getText());

			System.out.println("photo: " + photofield.getText());

			ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();

			Profile profile = profileDaoImpl.getProfile(namefield.getText());
				System.out.println("name: " + profile.getName());
				System.out.println("photoId: " + profile.getPhotoId());
				System.out.println("photoPath: "+profile.getPhotoPath());
				new ShowProfile(profile);

		}

	}

}
