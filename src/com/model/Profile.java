package com.model;

public class Profile {
	
	private String name;
	private String photoId;
	private String photoPath;
	
	public Profile(String name,String photoId,String photoPath) {
		this.name=name;
		this.photoId=photoId;
		this.photoPath=photoPath;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	
	

}
