package com.bikeShare.dao;

import java.util.List;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.SharesBooks;;


public interface SharesBooksDao {

	void deletebyShareBookId(Integer id);
	
	void save(SharesBooks shbs);
	
	SharesBooks findById(Integer shbid);
	
	List<SharesBooks> findBybooked_by(Integer shbid);

	List<SharesBooks> getSharedatesbyID(Integer id);
	
}

