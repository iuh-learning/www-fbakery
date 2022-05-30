package com.se.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.spring.dto.CartDTO;
import com.se.spring.service.CartService;
//import com.se.spring.service.CartServiceImps;

@Controller
public class ProductCartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/product-cart")
	public String showProductCartPage() {
		return "pages/product-cart";
	}
	
	// add product in cart
	@RequestMapping(value = "/add-cart/{id}")
	public String addCart(HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		
		if(cart == null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		
		cart = cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		
		return "redirect:/product-detail/"+id;
	}
	
	// delete product in cart
	@RequestMapping(value = "/delete-cart/{id}")
	public String deleteCart(HttpServletRequest req, HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		
		if(cart == null) {
			cart = new HashMap<Integer, CartDTO>();
		}
		
		cart = cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		
		return "redirect:"+req.getHeader("Referer");
	}
	
}
