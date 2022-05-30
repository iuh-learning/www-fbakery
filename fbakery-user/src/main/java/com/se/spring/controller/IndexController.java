package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.se.spring.entity.SanPham;
import com.se.spring.service.SanPhamService;

@Controller
public class IndexController {
	
	@Autowired 
	private SanPhamService prodService;
	
	// load all Product
	@GetMapping("/")
	public String showIndexPage(Model model) {
		List<SanPham> listProd = prodService.getProducts();
		for(SanPham sanPham : listProd) {
			System.out.println("GET PRODUCT: " + sanPham);
		}
		model.addAttribute("products", listProd);
		
		return "index";
	}
	
}
