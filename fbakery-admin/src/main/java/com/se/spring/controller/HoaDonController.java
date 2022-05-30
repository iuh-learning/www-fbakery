package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.entity.HoaDon;
import com.se.spring.entity.TrangThaiDonHang;
import com.se.spring.service.HoaDonService;
import com.se.spring.service.TrangThaiDonHangService;

@Controller
public class HoaDonController {

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	TrangThaiDonHangService trangThaiDonHangService;

	@GetMapping("/don-hang-cho-xac-nhan")
	public String movePageOrderWaitApprove(Model model) {
		List<HoaDon> list = hoaDonService.getAllOrder(1);

		System.out.println("LIST ORDER: " + list);
		model.addAttribute("list", list);

		return "pages/don-hang-cho-xac-nhan";
	}

	@GetMapping("/cap-nhat-thong-tin-hoa-don-cho-xac-nhan")
	public String updateInforOrder(@RequestParam("orderID") int orderId, Model model) {
		HoaDon order = hoaDonService.findOrderById(orderId);

		TrangThaiDonHang orderStatus = trangThaiDonHangService.findOrderStatus(2);

		order.setTrangThaiDonHang(orderStatus);

		hoaDonService.saveOrder(order);

		List<HoaDon> list = hoaDonService.getAllOrder(2);
		model.addAttribute("list", list);

		return "redirect:/don-hang-dang-chuan-bi";
	}

	@GetMapping("/don-hang-dang-chuan-bi")
	public String movePageOrdePreparing(Model model) {
		List<HoaDon> list = hoaDonService.getAllOrder(2);

		System.out.println("LIST ORDER PREPARING: " + list);
		model.addAttribute("list", list);

		return "pages/don-hang-dang-chuan-bi";
	}

	@GetMapping("/cap-nhat-thong-tin-hoa-don-dang-chuan-bi")
	public String updateInforOrderPreparing(@RequestParam("orderID") int orderId, Model model) {
		HoaDon order = hoaDonService.findOrderById(orderId);

		TrangThaiDonHang orderStatus = trangThaiDonHangService.findOrderStatus(3);

		order.setTrangThaiDonHang(orderStatus);

		hoaDonService.saveOrder(order);

		List<HoaDon> list = hoaDonService.getAllOrder(3);

		System.out.println("LIST ORDER MOVING UPDATE: " + list);

		model.addAttribute("list", list);

		return "redirect:/don-hang-dang-van-chuyen";
	}

	@GetMapping("/don-hang-dang-van-chuyen")
	public String movePageOrdeMoving(Model model) {
		List<HoaDon> list = hoaDonService.getAllOrder(3);

		System.out.println("LIST ORDER MOVING:  " + list);
		model.addAttribute("list", list);

		System.out.println("LIST ORDER MOVING: " + list);
		return "pages/don-hang-dang-van-chuyen";
	}
	
	@GetMapping("/cap-nhat-thong-tin-hoa-don-dang-van-chuyen")
	public String updateInforOrderMoving(@RequestParam("orderID") int orderId, Model model) {
		HoaDon order = hoaDonService.findOrderById(orderId);

		TrangThaiDonHang orderStatus = trangThaiDonHangService.findOrderStatus(4);

		order.setTrangThaiDonHang(orderStatus);

		hoaDonService.saveOrder(order);

		//Order success
		List<HoaDon> list = hoaDonService.getAllOrder(4);

		System.out.println("LIST ORDER MOVING UPDATE: " + list);

		model.addAttribute("list", list);

		return "redirect:/don-hang-hoan-thanh";
	}

	@GetMapping("/don-hang-hoan-thanh")
	public String movePageOrdeSucess(Model model) {
		List<HoaDon> list = hoaDonService.getAllOrder(4);

		System.out.println("LIST ORDER SUCCESS:  " + list);
		model.addAttribute("list", list);

		return "pages/don-hang-hoan-thanh";
	}
	
	@GetMapping("/xoa-hoa-don")
	public String deleteOrder(@RequestParam("orderID") int id) {
		hoaDonService.deleteOrder(id);
		return "redirect:/don-hang-cho-xac-nhan";
	}
}
