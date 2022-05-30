package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.KhachHang;


public interface KhachHangService {
    public List<KhachHang> getCustomers();
	public void saveCustomer(KhachHang cus);
	public KhachHang getCustomerById(int id);
	public void deleteCustomer(int id);
}
