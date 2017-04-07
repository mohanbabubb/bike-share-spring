package com.bikeShare.dao;

import java.util.List;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.User;


public interface BikeDao {

	
	Bikes findById(Integer id);
	
	void save(Bikes bikes);
	
	List<Bikes> findByowner_id(Integer id);
	
}

