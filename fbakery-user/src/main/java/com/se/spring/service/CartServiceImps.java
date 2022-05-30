package com.se.spring.service;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.CartDAO;
import com.se.spring.dto.CartDTO;

@Service
public class CartServiceImps implements CartService {

	@Autowired
	private CartDAO cartDAO;

	// add cart
	@Override
	public HashMap<Integer, CartDTO> addCart(int id, HashMap<Integer, CartDTO> cart) {
		return cartDAO.addCart(id, cart);
	}

	// delete cart
	@Override
	public HashMap<Integer, CartDTO> deleteCart(int id, HashMap<Integer, CartDTO> cart) {
		return cartDAO.deleteCart(id, cart);
	}

	// edit quanty cart
	@Override
	public HashMap<Integer, CartDTO> editCart(int id, int soLuong, HashMap<Integer, CartDTO> cart) {
		return cartDAO.editCart(id, soLuong, cart);
	}

	// total quanty
	@Override
	public int totalQuanty(HashMap<Integer, CartDTO> cart) {
		return cartDAO.totalQuanty(cart);
	}

	// total price
	@Override
	public double totalPrice(HashMap<Integer, CartDTO> cart) {
		return cartDAO.totalPrice(cart);
	}

}
