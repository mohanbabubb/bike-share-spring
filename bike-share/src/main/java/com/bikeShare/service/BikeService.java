package com.bikeShare.service;

import java.util.List;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.User;


public interface BikeService {
	
	Bikes findById(int id);
	
	void saveBikes(Bikes bikes);
	
	List<Bikes> findByowner_id(Integer id);
	
	void updateBikeShareStart(Integer id, String stat);
	
	void deleteBike(Integer id);
}
