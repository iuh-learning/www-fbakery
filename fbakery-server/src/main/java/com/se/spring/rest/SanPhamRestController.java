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

import com.se.spring.dto.SanPhamDTO;
import com.se.spring.entity.SanPham;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class SanPhamRestController {
	@Autowired
	private SanPhamService sanPhamService;

	@GetMapping("/products")
	public List<SanPham> getProducts() {
		return sanPhamService.getProducts();
	}

	@GetMapping("/products/{productId}")
	public SanPham getProductById(@PathVariable int productId) {
		SanPham product = sanPhamService.getProductById(productId);
		if (product == null)
			throw new CustomNotFoundException("Product not found" + productId);

		return product;
	}
	
	//lấy theo loại
	@GetMapping("/products/role/{id}")
	public List<SanPham> getProductById1(@PathVariable int id) {
		List<SanPham> list = sanPhamService.getProductsByIdTypeProduct(id);
		
		if(list == null) {
			throw new CustomNotFoundException("List product not found by id not exist" + id);
		}
		
		return list;
	}

	@PostMapping("/products")
	public SanPham addProduct(@RequestBody SanPhamDTO product) {
		System.out.println("PRODUCT: " + product);

		// convert data from dto
		SanPham sanPham = new SanPham(product.getMaSP(), product.getTenSP(), product.getDonGia(), product.getLoaiSP(),
				product.getAnh(), product.getMoTa(), product.getTrangThai());

		sanPhamService.saveProduct(sanPham);

		return sanPham;
	}

	@PutMapping("/products")
	public SanPham updateProduct(@RequestBody SanPhamDTO product) {
		// convert data from dto
		SanPham sanPham = new SanPham(product.getMaSP(), product.getTenSP(), product.getDonGia(), product.getLoaiSP(),
				product.getAnh(), product.getMoTa(), product.getTrangThai());

		sanPhamService.saveProduct(sanPham);

		return sanPham;
	}

	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		SanPham product = sanPhamService.getProductById(productId);

		if (product == null)
			throw new CustomNotFoundException("Product not found" + productId);

		sanPhamService.deleteProduct(productId);

		return "Deleted product id - " + productId;
	}
}
