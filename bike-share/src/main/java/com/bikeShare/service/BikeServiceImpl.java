package com.bikeShare.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bikeShare.dao.BikeDao;
import com.bikeShare.model.Bikes;
import com.bikeShare.model.User;


@Service("bikeService")
@Transactional
public class BikeServiceImpl implements BikeService{

	@Autowired
	private BikeDao dao;

	@Override
	public void saveBikes(Bikes bikes) {
		// TODO Auto-generated method stub
		dao.save(bikes);
	}

	@Override
	public List<Bikes> findByowner_id(Integer id) {
		// TODO Auto-generated method stub
			return (List<Bikes>) dao.findByowner_id(id);
	}

	@Override
	public void updateBikeShareStart(Integer id, String stat) {
		// TODO Auto-generated method stub
		Bikes entity = dao.findById(id);
			entity.setSharestatus(stat);
	}

	@Override
	public void deleteBike(Integer id) {
		// TODO Auto-generated method stub
		Bikes entity = dao.findById(id);
		entity.setDeletion_status("yes");
	}

	@Override
	public Bikes findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}


}
