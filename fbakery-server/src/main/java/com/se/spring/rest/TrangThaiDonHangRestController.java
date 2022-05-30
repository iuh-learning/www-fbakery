package com.se.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.TrangThaiDonHang;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.TrangThaiDonHangService;

@RestController
@RequestMapping("/api")
public class TrangThaiDonHangRestController {
	@Autowired
	private TrangThaiDonHangService trangThaiDonHangService;
	
	@GetMapping("/statusOrders/{id}")
	public TrangThaiDonHang getOrderStatusById(@PathVariable int id) {
		TrangThaiDonHang orderStatus = trangThaiDonHangService.findOrderStatus(id);
		
		if(orderStatus == null) {
			throw new CustomNotFoundException("List product not found by id not exist" + id);
		}
		
		return orderStatus;
	}
}
