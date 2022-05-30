package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.ChiTietHoaDonDAO;
import com.se.spring.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

	@Autowired
	private ChiTietHoaDonDAO chiTietHoaDonDAO;

	@Override
	@Transactional
	public List<ChiTietHoaDon> getAllOrderDetails(int orderId) {
		return chiTietHoaDonDAO.getAllOrderDetails(orderId);
	}

	@Override
	@Transactional
	public void saveOrderDetail(ChiTietHoaDon orderDetail) {
		chiTietHoaDonDAO.saveOrderDetail(orderDetail);

	}

	@Override
	@Transactional
	public ChiTietHoaDon findOrderDetailById(int orderId, int productId) {
		return chiTietHoaDonDAO.findOrderDetailById(orderId, productId);
	}

	@Override
	@Transactional
	public boolean deleteOrderDetail(int orderId, int productId) {
		return chiTietHoaDonDAO.deleteOrderDetail(orderId, productId);
	}

	@Override
	@Transactional
	public boolean deleteAllOrderDetail(int orderId) {
		return chiTietHoaDonDAO.deleteAllOrderDetail(orderId);
	}

}
