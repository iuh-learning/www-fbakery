package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.KhachHang;

@Repository
public class KhachHangDAOImpl implements KhachHangDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<KhachHang> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// current session query ...sort by last name
		Query<KhachHang> query = currentSession.createQuery("from KhachHang", KhachHang.class);

		// execute query and get result list
		List<KhachHang> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(KhachHang cus) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/ update the customer
		currentSession.saveOrUpdate(cus);

	}

	@Override
	@Transactional
	public KhachHang getCustomerById(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// read from database using the primary key
		KhachHang customer = currentSession.get(KhachHang.class, id);

		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		KhachHang customer = getCustomerById(id);

		currentSession.delete(customer);

	}

}
