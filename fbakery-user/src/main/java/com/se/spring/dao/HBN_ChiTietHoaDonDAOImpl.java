package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entityHBN.HBN_ChiTietHoaDon;

@Repository
public class HBN_ChiTietHoaDonDAOImpl implements HBN_ChiTietHoaDonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveOrderDetail(HBN_ChiTietHoaDon orderDetail) {
		Session currentSession;
		try {
			currentSession = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			currentSession = sessionFactory.openSession();
		}

		try {
			currentSession.save(orderDetail);
			System.out.println("save sucess order detail");
		} catch (Exception e) {
			System.out.println("save sucess order fail");
		}

	}

	@Override
	public HBN_ChiTietHoaDon findOrderDetailById(int orderId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HBN_ChiTietHoaDon> getAllOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrderDetail(int orderId, int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllOrderDetail(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
