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

import com.se.spring.entity.LoaiSanPham;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.LoaiSanPhamService;

@RestController
@RequestMapping("/api")
public class LoaiSanPhamRestController {
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@GetMapping("/typeProducts")
	public List<LoaiSanPham> getTypeProducts() {
		return loaiSanPhamService.getTypeProducts();
	}
	
	@GetMapping("/typeProducts/{typeId}")
	public LoaiSanPham getTypeProduct(@PathVariable int typeId) {
		LoaiSanPham typeProduct = loaiSanPhamService.getTypeProductById(typeId);
		if(typeProduct == null)
			throw new CustomNotFoundException("Type product not found" + typeId);
		
		return typeProduct;
	}
	
	@PostMapping("/typeProducts")
	public LoaiSanPham addTyepProduct(@RequestBody LoaiSanPham type) {
		loaiSanPhamService.saveTypeProduct(type);
		return type;
	}
	
	@PutMapping("/typeProducts")
	public LoaiSanPham updateTypeProduct(@RequestBody LoaiSanPham type) {
		loaiSanPhamService.saveTypeProduct(type);
		return type;
	}
	
	@DeleteMapping("/typeProducts/{typeId}")
	public String deleteTypeProduct(@PathVariable int typeId) {
		LoaiSanPham temp = loaiSanPhamService.getTypeProductById(typeId);
		if(temp == null)
			throw new CustomNotFoundException("Type product not found" + typeId);
		loaiSanPhamService.deleteTypeProduct(typeId);
		return "Deleted typeProduct id - " + typeId;
	}
}
