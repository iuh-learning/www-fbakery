package com.se.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.TrangThaiDonHangDAO;
import com.se.spring.entity.TrangThaiDonHang;

@Service
public class TrangThaiDonHangServiceImpl implements TrangThaiDonHangService{

	@Autowired
	private TrangThaiDonHangDAO trangThaiDonHangDAO;
	
	@Override
	public TrangThaiDonHang findOrderStatus(int id) {
		return trangThaiDonHangDAO.findOrderStatus(id);
	}

}
