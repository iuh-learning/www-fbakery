package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.SanPham;

public interface SanPhamService {
	public List<SanPham> getProducts();

	public void saveProduct(SanPham product);

	public SanPham getProductById(int id);

	public void deleteProduct(int id);
	
	public List<SanPham> getProductsByIdTypeProduct(int id);
}
