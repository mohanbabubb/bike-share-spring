package com.bikeShare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.User;



@Repository("bikeDao")
public class BikeDaoImpl extends AbstractDao<Integer, Bikes> implements BikeDao {

	static final Logger logger = LoggerFactory.getLogger(BikeDaoImpl.class);
	

	public void save(Bikes bikes) {
		persist(bikes);
		System.out.println(bikes);
	}
	

	@Override
	public List<Bikes> findByowner_id(Integer id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("owner_id", id));
		crit.add(Restrictions.eq("deletion_status", "no"));
		@SuppressWarnings("unchecked")
		List<Bikes> bikes = (List<Bikes>) crit.list();
		return bikes;
	}


	@Override
	public Bikes findById(Integer id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Bikes bike = (Bikes)crit.uniqueResult();
		return bike;
	}
	

}
