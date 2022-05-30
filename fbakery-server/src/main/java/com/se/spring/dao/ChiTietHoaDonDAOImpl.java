package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.ChiTietHoaDon;

@Repository
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<ChiTietHoaDon> getAllOrderDetails(int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<ChiTietHoaDon> query = currentSession.createQuery("from ChiTietHoaDon where hoaDon.maHD = :id",
				ChiTietHoaDon.class);

		query.setParameter("id", orderId);

		List<ChiTietHoaDon> list = query.getResultList();

		return list;
	}

	@Override
	@Transactional
	public void saveOrderDetail(ChiTietHoaDon orderDetail) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(orderDetail);

	}

	@Override
	@Transactional
	public ChiTietHoaDon findOrderDetailById(int orderId, int productId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<ChiTietHoaDon> query = currentSession.createQuery(
				"from ChiTietHoaDon where hoaDon.maHD = :orderId and sanPham.maSP = :productId", ChiTietHoaDon.class);
		query.setParameter("orderId", orderId);
		query.setParameter("productId", productId);

		ChiTietHoaDon orderDetail = query.getSingleResult();

		return orderDetail;
	}

	@Override
	@Transactional
	public boolean deleteOrderDetail(int orderId, int productId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<ChiTietHoaDon> query = currentSession.createQuery(
				"delete from ChiTietHoaDon where hoaDon.maHD = :orderId and sanPham.maSP = :productId",
				ChiTietHoaDon.class);
		query.setParameter("orderId", orderId);
		query.setParameter("orderId", productId);

		return query.executeUpdate() > 0;
	}

	@Override
	@Transactional
	public boolean deleteAllOrderDetail(int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete from ChiTietHoaDon where hoaDon.maHD = :orderId");
		query.setParameter("orderId", orderId);

		return query.executeUpdate() > 0;
	}

}
