package com.se.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.entity.LoaiSanPham;
import com.se.spring.service.LoaiSanPhamService;

@Controller
public class LoaiSanPhamController {
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@GetMapping("/loai-san-pham")
	public String movePageTypeProduct(Model model) {
		List<LoaiSanPham> list = loaiSanPhamService.getTypeProducts();

		model.addAttribute("typeProducts", list);

		return "pages/loai-san-pham";
	}

	@GetMapping("/them-loai-san-pham")
	public String movePageAddTypeProduct(Model model) {
		LoaiSanPham type = new LoaiSanPham();

		model.addAttribute("type", type);

		return "pages/them-loai-san-pham";
	}

	@GetMapping("/luu-loai-san-pham")
	public String saveTypeProduct(@Valid @ModelAttribute("type") LoaiSanPham type, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pages/them-loai-san-pham";
		}

		List<LoaiSanPham> listTypeProducts = loaiSanPhamService.getTypeProducts();
		for (LoaiSanPham _type : listTypeProducts) {
			if (_type.getTenLoaiSP().equals(type.getTenLoaiSP())) {
				model.addAttribute("status", "fail");
				model.addAttribute("type", type);
				return "pages/them-loai-san-pham";
			}
		}

		loaiSanPhamService.saveTypeProduct(type);
		return "redirect:/loai-san-pham";
	}

	@GetMapping("/cap-nhat-thong-tin-loai-san-pham")
	public String updateProductType(@RequestParam("typeId") int id, Model model) {
		LoaiSanPham type = loaiSanPhamService.getTypeProductById(id);

		model.addAttribute("type", type);

		return "pages/them-loai-san-pham";
	}


	
}
