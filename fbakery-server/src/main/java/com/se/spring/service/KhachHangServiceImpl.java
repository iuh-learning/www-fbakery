package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.KhachHangDAO;
import com.se.spring.entity.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService{

	@Autowired
	private KhachHangDAO khachHangDAO;
	
	@Override
	public List<KhachHang> getCustomers() {
		return khachHangDAO.getCustomers();
	}

	@Override
	public void saveCustomer(KhachHang cus) {
		khachHangDAO.saveCustomer(cus);
		
	}

	@Override
	public KhachHang getCustomerById(int id) {
		return khachHangDAO.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		khachHangDAO.deleteCustomer(id);
		
	}

}
