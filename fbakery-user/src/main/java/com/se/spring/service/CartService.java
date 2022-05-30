package com.se.spring.service;

import java.util.HashMap;

import com.se.spring.dto.CartDTO;

public interface CartService {

	public HashMap<Integer, CartDTO> addCart(int id, HashMap<Integer, CartDTO> cart);

	public HashMap<Integer, CartDTO> editCart(int id, int soLuong, HashMap<Integer, CartDTO> cart);

	public HashMap<Integer, CartDTO> deleteCart(int id, HashMap<Integer, CartDTO> cart);

	public int totalQuanty(HashMap<Integer, CartDTO> cart);

	public double totalPrice(HashMap<Integer, CartDTO> cart);

}
