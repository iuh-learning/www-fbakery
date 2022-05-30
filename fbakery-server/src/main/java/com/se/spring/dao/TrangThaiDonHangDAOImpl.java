package com.se.spring.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.TrangThaiDonHang;

@Repository
public class TrangThaiDonHangDAOImpl implements TrangThaiDonHangDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public TrangThaiDonHang findOrderStatus(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		TrangThaiDonHang orderStatus = currentSession.get(TrangThaiDonHang.class, id);
		return orderStatus;
	}

}
