package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.SanPhamDAO;
import com.se.spring.entity.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService{

	@Autowired
	private SanPhamDAO sanPhamDAO;
	
	@Override
	public List<SanPham> getProducts() {
		return sanPhamDAO.getProducts();
	}

	@Override
	public void saveProduct(SanPham product) {
		sanPhamDAO.saveProduct(product);
		
	}

	@Override
	public SanPham getProductById(int id) {
		return sanPhamDAO.getProductById(id);
	}

	@Override
	public void deleteProduct(int id) {
		sanPhamDAO.deleteProduct(id);
		
	}

	@Override
	public List<SanPham> getProductsByIdTypeProduct(int id) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getProductsByIdTypeProduct(id);
	}

}
