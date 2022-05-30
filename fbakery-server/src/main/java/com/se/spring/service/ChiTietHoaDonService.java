package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getAllOrderDetails(int orderId);

	public void saveOrderDetail(ChiTietHoaDon orderDetail);

	public ChiTietHoaDon findOrderDetailById(int orderId, int productId);

	public boolean deleteOrderDetail(int orderId, int productId);

	public boolean deleteAllOrderDetail(int orderId);
}
