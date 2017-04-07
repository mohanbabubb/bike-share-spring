package com.bikeShare.dao;

import java.util.List;

import com.bikeShare.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	
}
