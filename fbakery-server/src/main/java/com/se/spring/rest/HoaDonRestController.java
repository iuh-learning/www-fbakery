package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.HoaDon;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.ChiTietHoaDonService;
import com.se.spring.service.HoaDonService;

@RestController
@RequestMapping("/api")
public class HoaDonRestController {

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	//lấy theo trạng thái
	@GetMapping("/orders/status/{idStatus}")
	public List<HoaDon> getOrders(@PathVariable int idStatus) {
		List<HoaDon> list = hoaDonService.getAllOrder(idStatus);
		
		if(list == null) {
			throw new CustomNotFoundException("Find list order from statusId is null" + idStatus);
		}
		return list;
	}

	@GetMapping("orders/{idOrder}")
	public HoaDon getOrderById(@PathVariable int idOrder) {
		HoaDon order = hoaDonService.findOrderById(idOrder);
		if(order == null) {
			throw new CustomNotFoundException("Order not found" + idOrder);
		}
		return hoaDonService.findOrderById(idOrder);
	}

	@PostMapping("/orders")
	public HoaDon addOrder(@RequestBody HoaDon hoaDon) {
		hoaDonService.saveOrder(hoaDon);

		return hoaDon;
	}

	@PutMapping("/orders")
	public HoaDon updateOrder(@RequestBody HoaDon hoaDon) {
		hoaDonService.saveOrder(hoaDon);

		return hoaDon;
	}

	@DeleteMapping("/orders/{idOrder}")
	public void deleteOrder(@PathVariable int idOrder) {
		HoaDon order = getOrderById(idOrder);
		if(order == null) {
			throw new CustomNotFoundException("Order not found" + idOrder);
		}
		
		chiTietHoaDonService.deleteAllOrderDetail(idOrder);
		hoaDonService.deleteOrder(idOrder);
	}
}
