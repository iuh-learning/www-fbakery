package com.se.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.HBN_ChiTietHoaDonDAO;
import com.se.spring.entityHBN.HBN_ChiTietHoaDon;

@Service
public class HBN_ChiTietHoaDonServiceImpl implements HBN_ChiTietHoaDonService {

	@Autowired
	private HBN_ChiTietHoaDonDAO chiTietHoaDonDAO;

	@Override
	public void saveOrderDetail(HBN_ChiTietHoaDon orderDetail) {
		chiTietHoaDonDAO.saveOrderDetail(orderDetail);

	}

}
