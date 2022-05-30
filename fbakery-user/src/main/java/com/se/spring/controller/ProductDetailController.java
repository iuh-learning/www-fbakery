package com.se.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.se.spring.entity.SanPham;
import com.se.spring.service.SanPhamService;

@Controller
public class ProductDetailController {
	
	@Autowired
	private SanPhamService prodService;
	
	@GetMapping("/product-detail")
	public String showProductDetailPage() {
		return "pages/product-detail";
	}
	
	// find by id prod
//	@GetMapping("/product-detail/43")
//	public String showProductDetailByIdPage() {
//		return "pages/product-detail";
//	}
	
	// load find by id prod
	@GetMapping(value = "/product-detail/{id}")
	public String showProductDetailPageById(Model model, @PathVariable int id) {
		SanPham prod = prodService.getProductById(id);
		System.out.println("sp:" + prod);
		model.addAttribute("productDetailById", prod);
		
		return "pages/product-detail";
	}
	
}
