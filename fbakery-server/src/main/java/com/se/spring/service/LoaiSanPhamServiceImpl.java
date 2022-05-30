package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.LoaiSanPhamDAO;
import com.se.spring.entity.LoaiSanPham;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{

	@Autowired
	private LoaiSanPhamDAO loaiSanPhamDAO;
	@Override
	public List<LoaiSanPham> getTypeProducts() {
		// TODO Auto-generated method stub
		return loaiSanPhamDAO.getTypeProducts();
	}

	@Override
	public void saveTypeProduct(LoaiSanPham typeProduct) {
		loaiSanPhamDAO.saveTypeProduct(typeProduct);
		
	}

	@Override
	public LoaiSanPham getTypeProductById(int id) {
		return loaiSanPhamDAO.getTypeProductById(id);
	}

	@Override
	public void deleteTypeProduct(int id) {
		loaiSanPhamDAO.deleteTypeProduct(id);
	}

}
