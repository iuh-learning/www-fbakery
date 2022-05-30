package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getListOrderDetailByIdOrder(int id);
}
