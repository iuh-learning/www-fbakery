package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.HoaDon;

@Repository
public class HoaDonDAOImpl implements HoaDonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<HoaDon> getAllOrder(int idStatus) {
		Session curentSession = sessionFactory.getCurrentSession();
		
		Query<HoaDon> query = curentSession.createQuery("from HoaDon where trangThaiDonHang.maTrangThai =: id", HoaDon.class);
		query.setParameter("id", idStatus);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveOrder(HoaDon order) {
		Session curentSession = sessionFactory.getCurrentSession();
		
		curentSession.saveOrUpdate(order);
		
	}

	@Override
	@Transactional
	public HoaDon findOrderById(int orderId) {
		Session curentSession = sessionFactory.getCurrentSession();
		
		HoaDon order = curentSession.get(HoaDon.class, orderId);
		
		return order;
	}

	@Override
	@Transactional
	public void deleteOrder(int orderId) {
		Session curentSession = sessionFactory.getCurrentSession();
		
		HoaDon order = findOrderById(orderId);
		
		curentSession.delete(order);
	}

}
