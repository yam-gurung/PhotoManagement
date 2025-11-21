package com.photomanagement;

import java.awt.*;
import javax.swing.*;

import com.model.Profile;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class ShowProfile extends JFrame {

    private static final long serialVersionUID = 1L;

	public ShowProfile(Profile profile) {
        setTitle("Profile");
        setLayout(new BorderLayout());
        setSize(500,500);

        ImageIcon originalIcon;
        
		originalIcon=new ImageIcon(profile.getPhotoPath()+profile.getPhotoId());
        
        // Get the Image object
        Image originalImage = originalIcon.getImage();

        // Scale the image
        int newWidth = 400;
        int newHeight = 400;
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Display the scaled image in a JLabel
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel name=new JLabel(profile.getName());
        
        add(name,BorderLayout.LINE_START);
        add(imageLabel,BorderLayout.LINE_END);

        pack();
        setVisible(true);
    }

    }
