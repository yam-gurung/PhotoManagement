package com.photomanagement;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dao.impl.ProfileDaoImpl;
import com.model.Profile;

public class AddProfile implements ActionListener {
	
	JLabel nameLabel;
	JLabel photoLabel;
	JLabel photoPathLabel;
	JTextField nameTextField;
	JTextField photoTextField;
	JTextField photoPathField;
	JButton saveButton;
	JPanel jPanel;
	
	public AddProfile() {
		AddProfileFrame addProfileFrame=new AddProfileFrame();
		addProfileFrame.setTitle("AddProfile");
		addProfileFrame.setSize(150,300);
		
		
		nameLabel=new JLabel("name: ");
		photoLabel=new JLabel("photo: ");
		photoPathLabel=new JLabel("photoPath: ");
		nameTextField=new JTextField(20);
		photoTextField=new JTextField(20);
		photoPathField=new JTextField(20);
		saveButton=new JButton("Save");
		
		saveButton.addActionListener(this);
		
		jPanel=new JPanel();
		jPanel.setLayout(new GridLayout(0,2));
		
		jPanel.add(nameLabel);
		jPanel.add(nameTextField);
		
		jPanel.add(photoLabel);
		jPanel.add(photoTextField);
		
		jPanel.add(photoPathLabel);
		jPanel.add(photoPathField);
		
		jPanel.add(saveButton);
		
		addProfileFrame.add(jPanel);
		
		
		addProfileFrame.pack();
		
		addProfileFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==saveButton) {
			System.out.println("name: "+nameTextField.getText());
			System.out.println("photo: "+photoTextField.getText());
			System.out.println("photoPath: "+photoPathField.getText());
			Profile profile=new Profile(nameTextField.getText(),photoTextField.getText(),photoPathField.getText());
			ProfileDaoImpl profileDaoImpl=new ProfileDaoImpl();
			profileDaoImpl.saveProfile(profile);
			
		}
	}

}
