package com.bikeShare.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bikeShare.dao.SharesBooksDao;
import com.bikeShare.model.SharesBooks;

@Service("sharesBooksService")
@Transactional
public class SharesBooksServiceImpl implements SharesBooksService {

	@Autowired
	private SharesBooksDao dao;

	@Override
	public void saveSharesBooks(SharesBooks shbs) {
		// TODO Auto-generated method stub
		dao.save(shbs);
	}

	@Override
	public List<SharesBooks> getSharedatesbyID(Integer id) {
		// TODO Auto-generated method stub
		return (List<SharesBooks>) dao.getSharedatesbyID(id);
	}

	@Override
	public void updateBookedDates(Integer shbid, Integer userid) {
		SharesBooks entity = dao.findById(shbid);
		if (entity != null) {
			try {
				entity.setBookingstatus("Booked");
				entity.setBooked_by(userid);
				entity.setBooked_date(new Date());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deletebyShareBookId(Integer id) {
		// TODO Auto-generated method stub
		dao.deletebyShareBookId(id);
	}

}
