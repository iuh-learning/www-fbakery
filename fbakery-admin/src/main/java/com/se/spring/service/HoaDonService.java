package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.HoaDon;

public interface HoaDonService {
	public List<HoaDon> getAllOrder(int idStatus);
	public void saveOrder(HoaDon order);
	public HoaDon findOrderById(int orderId);
	public void deleteOrder(int orderId);
}
