package com.bikeShare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.SharesBooks;
import com.bikeShare.model.User;



@Repository("SharesBooksDao")
public class SharesBooksDaoImpl extends AbstractDao<Integer, SharesBooks> implements SharesBooksDao {

	static final Logger logger = LoggerFactory.getLogger(SharesBooksDaoImpl.class);
	

	public void save(SharesBooks shbs) {
		persist(shbs);
	}


	@Override
	public SharesBooks findById(Integer shbid) {
		// TODO Auto-generated method stub

			Criteria crit = createEntityCriteria();
			crit.add(Restrictions.eq("id", shbid));
			SharesBooks shares_and_bookings = (SharesBooks)crit.uniqueResult();
			return shares_and_bookings;
	}


	@Override
	public List<SharesBooks> findBybooked_by(Integer shbid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<SharesBooks> getSharedatesbyID(Integer id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("bike_id", id));
		crit.add(Restrictions.eq("bookingstatus", "NotBooked"));
		@SuppressWarnings("unchecked")
		List<SharesBooks> shareddates = (List<SharesBooks>) crit.list();
		return shareddates;
	}


	@Override
	public void deletebyShareBookId(Integer id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		SharesBooks shb = (SharesBooks)crit.uniqueResult();
		delete(shb);
	}


}
