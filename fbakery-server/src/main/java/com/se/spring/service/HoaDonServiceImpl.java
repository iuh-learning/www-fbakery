package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.HoaDonDAO;
import com.se.spring.entity.HoaDon;

@Service
public class HoaDonServiceImpl implements HoaDonService{

	@Autowired
	private HoaDonDAO hoaDonDAO;

	@Override
	public List<HoaDon> getAllOrder(int idStatus) {
		return hoaDonDAO.getAllOrder(idStatus);
	}

	@Override
	public void saveOrder(HoaDon order) {
		hoaDonDAO.saveOrder(order);
	}

	@Override
	public HoaDon findOrderById(int orderId) {
		return hoaDonDAO.findOrderById(orderId);
	}

	@Override
	public void deleteOrder(int orderId) {
		hoaDonDAO.deleteOrder(orderId);
	}
}
