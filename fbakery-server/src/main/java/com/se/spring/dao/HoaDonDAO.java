package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.HoaDon;

public interface HoaDonDAO {
	public List<HoaDon> getAllOrder(int idStatus);
	public void saveOrder(HoaDon order);
	public HoaDon findOrderById(int orderId);
	public void deleteOrder(int orderId);
}
