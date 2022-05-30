package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.SanPham;

@Repository
public class SanPhamDAOImpl implements SanPhamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<SanPham> getProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<SanPham> query = currentSession.createQuery("from SanPham", SanPham.class);
		
		return query.getResultList();
	}	
	
	
	@Override
	@Transactional
	public void saveProduct(SanPham product) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			currentSession.saveOrUpdate(product);
		}catch (Exception e) {
			e.printStackTrace();
			currentSession.clear();
		}
		
	}

	@Override
	@Transactional
	public SanPham getProductById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		SanPham product = currentSession.get(SanPham.class, id);
		
		return product;
	}
	

	@Override
	@Transactional
	public void deleteProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		SanPham product = getProductById(id);
		
		currentSession.delete(product);
		
	}


	@Override
	@Transactional
	public List<SanPham> getProductsByIdTypeProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<SanPham> query = currentSession.createQuery("from SanPham where loaiSanPham.maLoaiSP =: id", SanPham.class);
		query.setParameter("id", id);
		
		List<SanPham> list = query.getResultList();
		return list;
	}

}
