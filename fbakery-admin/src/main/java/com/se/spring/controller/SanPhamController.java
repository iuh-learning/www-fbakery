package com.se.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.se.spring.entity.LoaiSanPham;
import com.se.spring.entity.SanPham;
import com.se.spring.service.LoaiSanPhamService;
import com.se.spring.service.SanPhamService;

@Controller
public class SanPhamController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	ServletContext servletContext;

	@GetMapping("/san-pham")
	public String getProducts(Model model) {
		List<SanPham> listProduct = sanPhamService.getProducts();
		System.out.println(listProduct);
		List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();
		model.addAttribute("products", listProduct);
		model.addAttribute("types", listTypeProduct);

		return "pages/san-pham";
	}

	@GetMapping("/them-san-pham")
	public String movePageAddProduct(Model model) {
		SanPham product = new SanPham();
		List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();

		model.addAttribute("product", product);
		model.addAttribute("types", listTypeProduct);

		return "pages/them-san-pham";
	}

	@PostMapping("/luu-san-pham")
	public String saveProduct(@Valid @ModelAttribute("product") SanPham product, Errors errors,
			@RequestParam("idTypeProduct") int id, Model model) {
		if (errors.hasErrors()) {
			List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();

			model.addAttribute("types", listTypeProduct);
			return "pages/them-san-pham";
		}

		if (id == 0) {
			model.addAttribute("status", "fail");
			return "redirect:/them-san-pham";
		}

		if (product.getDonGia() < 10000) {
			model.addAttribute("decimal", "fail");
			return "redirect:/them-san-pham";
		}

		List<SanPham> listProduct = sanPhamService.getProducts();

		for (SanPham sp : listProduct) {
			if (sp.getTenSP().equals(product.getTenSP())) {
				model.addAttribute("name", "fail");
				return "redirect:/them-san-pham";
			}
		}

		LoaiSanPham loaiSanPham = loaiSanPhamService.getTypeProductById(id);
		String nameFile = uploadFile(product.getImage());

		System.out.println(product);
		SanPham sanPham = new SanPham(product.getMaSP(), product.getTenSP(), product.getDonGia(), loaiSanPham, nameFile,
				product.getMoTa(), product.getTrangThai());
		sanPhamService.saveProduct(sanPham);

		return "redirect:/san-pham";

	}

	private String uploadFile(MultipartFile _multipartFile) {
		MultipartFile multipartFile = _multipartFile;
		String nameFile = "";
		if (multipartFile != null || !multipartFile.isEmpty()) {
			System.out.println("File ! null");
			nameFile = multipartFile.getOriginalFilename();
			String fileName = servletContext.getRealPath("/") + "resources\\img\\" + nameFile;

			try {
				multipartFile.transferTo(new File(fileName));
				return nameFile;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nameFile;
	}

	// Cập nhật đụng với thêm!
	@GetMapping("/cap-nhat-thong-tin-san-pham")
	public String updateProduct(@RequestParam("productId") int productId, Model model) {
		List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();

		SanPham product = sanPhamService.getProductById(productId);

		model.addAttribute("types", listTypeProduct);

		model.addAttribute("product", product);

		return "pages/cap-nhat-san-pham";
	}

	@PostMapping("/cap-nhat-thong-tin-san-pham")
	public String updateProduct(@Valid @ModelAttribute("product") SanPham product, Errors errors,
			@RequestParam("idTypeProduct") int id, Model model) {
		List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();
		if (errors.hasErrors()) {
			model.addAttribute("types", listTypeProduct);

			return "pages/cap-nhat-san-pham";
		}

		if (id == 0) {
			model.addAttribute("types", listTypeProduct);

			model.addAttribute("status", "false");

			return "pages/cap-nhat-san-pham";
		}

		if (product.getDonGia() < 10000) {
			model.addAttribute("types", listTypeProduct);

			model.addAttribute("decimal", "fail");

			return "pages/cap-nhat-san-pham";
		}

		System.out.println("PRODUCT UPDATE: " + product);
		LoaiSanPham loaiSanPham = loaiSanPhamService.getTypeProductById(id);
		String nameFile = uploadFile(product.getImage());

		System.out.println(product);
		SanPham sanPham = new SanPham(product.getMaSP(), product.getTenSP(), product.getDonGia(), loaiSanPham, nameFile,
				product.getMoTa(), product.getTrangThai());
		
		sanPhamService.saveProduct(sanPham);

		return "redirect:/san-pham";
	}

	@PostMapping("/loc-san-pham")
	public String fillterProduct(@RequestParam("loai_san_pham") int id, Model model) {
		List<SanPham> list = null;
		if (id == 0) {
			list = sanPhamService.getProducts();
		} else {
			list = sanPhamService.getProductsByIdTypeProduct(id);
		}
		List<LoaiSanPham> listTypeProduct = loaiSanPhamService.getTypeProducts();
		model.addAttribute("products", list);
		model.addAttribute("types", listTypeProduct);

		return "pages/san-pham";
	}

}
