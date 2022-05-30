package com.se.spring.dao;

import java.util.List;

import com.se.spring.entityHBN.HBN_ChiTietHoaDon;

public interface HBN_ChiTietHoaDonDAO {
	public List<HBN_ChiTietHoaDon> getAllOrderDetails(int orderId);

	public void saveOrderDetail(HBN_ChiTietHoaDon orderDetail);

	public HBN_ChiTietHoaDon findOrderDetailById(int orderId, int productId);

	public boolean deleteOrderDetail(int orderId, int productId);

	public boolean deleteAllOrderDetail(int orderId);
}
