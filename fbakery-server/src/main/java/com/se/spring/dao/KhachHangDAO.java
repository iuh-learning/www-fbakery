package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.KhachHang;

public interface KhachHangDAO {
	public List<KhachHang> getCustomers();

	public void saveCustomer(KhachHang cus);

	public KhachHang getCustomerById(int id);

	public void deleteCustomer(int id);
}
