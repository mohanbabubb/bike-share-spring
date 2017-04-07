package com.bikeShare.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.SharesBooks;
import com.bikeShare.model.User;


public interface SharesBooksService {
	
	void deletebyShareBookId(Integer id);
	
	void saveSharesBooks(SharesBooks shbs);
	
	List<SharesBooks> getSharedatesbyID(Integer id);
	
	void updateBookedDates(Integer shbid,Integer userid) throws ParseException;

}
