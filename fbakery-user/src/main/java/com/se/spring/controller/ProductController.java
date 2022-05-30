package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.entity.LoaiSanPham;
import com.se.spring.entity.SanPham;
import com.se.spring.service.LoaiSanPhamService;
import com.se.spring.service.SanPhamService;


@Controller
public class ProductController {
	
	@Autowired
	private LoaiSanPhamService lspService;
	
	@Autowired
	private SanPhamService spService;
	
	// load all type product
	@GetMapping("/product")
	public String showProductPage(Model model) {
		List<LoaiSanPham> lsp = lspService.getTypeProducts();
		List<SanPham> sp = spService.getProducts();
		model.addAttribute("productType", lsp);
		model.addAttribute("product", sp);
		
		return "pages/product";
		
	}

	
	// find by id type product
	@RequestMapping("/product/{id}")
	public String showProductTypePage(Model model, @PathVariable int id) {
		List<LoaiSanPham> lsp = lspService.getTypeProducts();
		List<SanPham> sp = spService.getProductsByIdTypeProduct(id);
		model.addAttribute("product", sp);
		model.addAttribute("productType", lsp);
		
		return "pages/product";
	}
	
}
