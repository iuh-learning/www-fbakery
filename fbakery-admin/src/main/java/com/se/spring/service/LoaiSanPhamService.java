package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.LoaiSanPham;

public interface LoaiSanPhamService {
	public List<LoaiSanPham> getTypeProducts();

	public void saveTypeProduct(LoaiSanPham typeProduct);

	public LoaiSanPham getTypeProductById(int id);

	public void deleteTypeProduct(int id);
}
