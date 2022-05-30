package com.se.spring.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.se.spring.entity.HoaDon;
import com.se.spring.entity.KhachHang;
import com.se.spring.entity.User;
import com.se.spring.service.HoaDonService;
import com.se.spring.service.KhachHangService;

@Controller
public class LoginController {
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private HoaDonService hoaDonService;

	@GetMapping("/")
	public String movePageLogin(Model model) {
		model.addAttribute("userFormData", new User());
		return "pages/login";
	}

	@PostMapping("/check-login")
	public String checkLogin(@ModelAttribute("userFormData") User user, Model model) {
		if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
			return "redirect:/dashboard";
		}
		model.addAttribute("status", "fail");

		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String showDashBoard(Model model) {
		List<KhachHang> customers = khachHangService.getCustomers();
		List<HoaDon> orders = hoaDonService.getAllOrder(4);

		long total = 0;
		for(HoaDon hd : orders) {
			total += hd.getTongTien();
		}
		
		DecimalFormat df = new DecimalFormat("#,###");
		int successOrders = orders.size();
		int loadingOrders = hoaDonService.getAllOrder(1).size();
		
		model.addAttribute("customers", customers);
		model.addAttribute("customerSize", customers.size());
		model.addAttribute("loadingOrder", loadingOrders);
		model.addAttribute("successOrder", successOrders);
		model.addAttribute("totalMoney", df.format(total));
		return "index";
	}


	@GetMapping("/logout")
	public String movePageForgotPassword() {
		return "redirect:/";
	}
}
