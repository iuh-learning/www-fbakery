package com.se.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.LoaiSanPham;

@Repository
public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<LoaiSanPham> getTypeProducts() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<LoaiSanPham> query = currentSession.createQuery("from LoaiSanPham", LoaiSanPham.class);

		List<LoaiSanPham> typeProducts = query.getResultList();

		return typeProducts;
	}

	@Override
	@Transactional
	public void saveTypeProduct(LoaiSanPham typeProduct) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			currentSession.saveOrUpdate(typeProduct);
		}catch (Exception e) {
			currentSession.clear();
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public LoaiSanPham getTypeProductById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		LoaiSanPham typeProduct = currentSession.get(LoaiSanPham.class, id);
		
		return typeProduct;
	}

	@Override
	@Transactional
	public void deleteTypeProduct(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		LoaiSanPham typeProduct = getTypeProductById(id);
		
		currentSession.delete(typeProduct);

	}

}
