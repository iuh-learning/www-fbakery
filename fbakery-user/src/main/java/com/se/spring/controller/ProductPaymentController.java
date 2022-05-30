package com.se.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.dto.CartDTO;
import com.se.spring.entity.ChiTietHoaDon;
import com.se.spring.entity.HoaDon;
import com.se.spring.entity.KhachHang;
import com.se.spring.entity.SanPham;
import com.se.spring.entity.TrangThaiDonHang;
import com.se.spring.entityHBN.HBN_ChiTietHoaDon;
import com.se.spring.service.CartService;
import com.se.spring.service.ChiTietHoaDonService;
import com.se.spring.service.HBN_ChiTietHoaDonService;
import com.se.spring.service.HoaDonService;
import com.se.spring.service.KhachHangService;
import com.se.spring.service.LoaiSanPhamService;
import com.se.spring.service.TrangThaiDonHangService;

@Controller
public class ProductPaymentController {

	@Autowired
	private CartService cartService;

	@Autowired
	private KhachHangService khService;

	@Autowired
	private TrangThaiDonHangService trangThaiDonHangService;

	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private HBN_ChiTietHoaDonService chiTietHoaDonService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private ChiTietHoaDonService orderDetailService;

	@GetMapping("/product-payment")
	public String showProductPayment(Model model) {
		model.addAttribute("customer", new KhachHang());

		return "pages/product-payment";
	}

	// delete product in page payment
	@RequestMapping(value = "/delete-product-pay/{id}")
	public String deleteCart(HttpServletRequest req, HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Integer, CartDTO>();
		}

		cart = cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));

		return "redirect:" + req.getHeader("Referer");
	}
	
	// edit cart in page payment
	@RequestMapping(value = "/edit-cart-pay/{id}/{quanty}")
	public String editCart(HttpServletRequest req, HttpSession session, @PathVariable int id, @PathVariable int quanty) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		
		cart = cartService.editCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		
		return "redirect:" + req.getHeader("Referer");
	}

	// Handle payment
	@PostMapping(value = "/customer-payment")
	public String handleSelling(@Valid @ModelAttribute("customer") KhachHang customer, Errors errors,
			HttpSession session, Model model) {
		if (errors.hasErrors()) {
			return "pages/product-payment";
		}

		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		System.out.println("Cart size: " + cart.size());

		if (cart.size() == 0 || cart == null) {
			model.addAttribute("size", "0");
			return "redirect:/product-payment"; // size = 0 no payment
		}

		customer.setTrangThai(1);
		System.out.println("Customer save: " + customer);
		khService.saveCustomer(customer);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());

		TrangThaiDonHang ttdh = trangThaiDonHangService.findOrderStatus(1);
		KhachHang kh = khService.getCustomers().get(khService.getCustomers().size() - 1);

		HoaDon hd = new HoaDon(0, date, 0, ttdh, kh);
		hoaDonService.saveOrder(hd);

		HoaDon hoaDonServer = hoaDonService.getAllOrder(1).get(hoaDonService.getAllOrder(1).size() - 1);

		double totalMoney = 0;

//		LoaiSanPham lsp = loaiSanPhamService.getTypeProductById(1006);

		for (Map.Entry<Integer, CartDTO> itemCart : cart.entrySet()) {
			SanPham sp = itemCart.getValue().getProduct();
//			sp.setLoaiSP(lsp);

			HBN_ChiTietHoaDon cthd = new HBN_ChiTietHoaDon(hoaDonServer.getMaHD(), sp.getMaSP(),
					itemCart.getValue().getSoLuong());

			System.out.print("CTHD: " + cthd);
			chiTietHoaDonService.saveOrderDetail(cthd);
			totalMoney += itemCart.getValue().getTongGia();
		}

		// delete cart after payment
		session.removeAttribute("Cart");

		hoaDonServer.setTongTien(totalMoney);
		hoaDonService.saveOrder(hoaDonServer);

		return "redirect:/done-payment/" + hoaDonServer.getMaHD();
	}

	@RequestMapping(value = "done-payment/{id}")
	public String showDetailPayment(Model model, @PathVariable("id") int id) {
		List<ChiTietHoaDon> listOrderDetail = orderDetailService.getListOrderDetailByIdOrder(id);
		System.out.println("List Order detail" + listOrderDetail);

		model.addAttribute("list", listOrderDetail);
		model.addAttribute("totalMoney", hoaDonService.findOrderById(id).getTongTien());
		
		return "pages/product-order-tracking";
	}

}
