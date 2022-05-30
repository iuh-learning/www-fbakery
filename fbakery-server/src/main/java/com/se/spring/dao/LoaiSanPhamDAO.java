package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.LoaiSanPham;

public interface LoaiSanPhamDAO {
	public List<LoaiSanPham> getTypeProducts();

	public void saveTypeProduct(LoaiSanPham typeProduct);

	public LoaiSanPham getTypeProductById(int id);

	public void deleteTypeProduct(int id);
}
