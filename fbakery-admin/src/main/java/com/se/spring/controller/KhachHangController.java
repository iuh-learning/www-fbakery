package com.se.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.entity.KhachHang;
import com.se.spring.service.KhachHangService;

@Controller
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/cap-nhat-thong-tin")
	public String movePageUpdateCustomer(@RequestParam("customerId") int id, Model model) {
		KhachHang customer = khachHangService.getCustomerById(id);

		model.addAttribute("customer", customer);

		return "pages/cap-nhat-thong-tin-khach-hang";
	}
	
	@GetMapping("/luu-thong-tin-khach-hang")
	public String saveInforCustomer(@ModelAttribute("customer") KhachHang customer) {
		khachHangService.saveCustomer(customer);
		return "redirect:/dashboard";
	}
}
