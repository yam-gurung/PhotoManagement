package com.dao;

import java.util.List;

import com.model.Profile;

public interface ProfileDao {
	
	 void saveProfile(Profile profile);
	 
	 public List<Profile> getProfileList();
	 
	 public Profile getProfile(String name);

}
