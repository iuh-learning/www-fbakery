package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.SanPham;

public interface SanPhamDAO {
	public List<SanPham> getProducts();

	public void saveProduct(SanPham product);

	public SanPham getProductById(int id);

	public void deleteProduct(int id);
	
	public List<SanPham> getProductsByIdTypeProduct(int id);
}
