package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.entity.ChiTietHoaDon;
import com.se.spring.service.ChiTietHoaDonService;

@Controller
public class ChiTietHoaDonController {
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("chi-tiet-hoa-don")
	public String showOrderDetail(@RequestParam("orderID") int id, Model model) {
		List<ChiTietHoaDon> list = chiTietHoaDonService.getListOrderDetailByIdOrder(id);
		
		System.out.println("LIST ORDER DETAIL: " + list);
		
		model.addAttribute("list", list);
		return "pages/chi-tiet-hoa-don";
	}
}
