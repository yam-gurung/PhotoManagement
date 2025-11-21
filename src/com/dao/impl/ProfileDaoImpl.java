package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.dao.ProfileDao;
import com.model.Profile;
import com.photomanagement.ConnectionManager;

public class ProfileDaoImpl implements ProfileDao {

	ConnectionManager connectionManager;
	
	@Override
	public void saveProfile(Profile profile) {
		connectionManager=new ConnectionManager();
		try {
			Connection connection=connectionManager.getConnection();
			
			System.out.println("person name: "+profile.getName());
			System.out.println("person id: "+profile.getPhotoPath());
			
			
			PreparedStatement preparedStatement =connection.prepareStatement("insert into person_profile(person_name,photo_id,photo_path) values(?,?,?)");
			preparedStatement.setString(1, profile.getName());
			preparedStatement.setString(2, profile.getPhotoId());
			preparedStatement.setString(3, profile.getPhotoPath());
			
			int rowsaffected = preparedStatement.executeUpdate();
			
			System.out.println("rows affected "+rowsaffected);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Profile> getProfileList() {
		connectionManager=new ConnectionManager();
		ArrayList<Profile> profileList=new ArrayList<Profile>();
		try {
			Connection connection=connectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from person_profile");
			
			while(resultSet.next()) {
				String person_name=resultSet.getString("person_name");
				String photoId=resultSet.getString("photo_id");
				String photoPath=resultSet.getString("photo_path");
				
				Profile profile=new Profile(person_name,photoId,photoPath);
				profileList.add(profile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return profileList;
	}

	@Override
	public Profile getProfile(String name) {
		connectionManager=new ConnectionManager();
		Profile profile=null;
		try {
			Connection connection=connectionManager.getConnection();
			String sql="select * from person_profile where person_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String person_name=resultSet.getString("person_name");
				String photoId=resultSet.getString("photo_id");
				String photoPath=resultSet.getString("photo_path");
				
				profile=new Profile(person_name,photoId,photoPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return profile;
	}
	
	

}
