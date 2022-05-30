package com.se.spring.dao;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.dto.CartDTO;
import com.se.spring.entity.SanPham;
import com.se.spring.service.SanPhamService;

@Repository
public class CartDAOImps implements CartDAO {

	@Autowired
	private SanPhamService spService;

	// add cart
	@Override
	@Transactional
	public HashMap<Integer, CartDTO> addCart(int id, HashMap<Integer, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		SanPham prod = spService.getProductById(id);

		if (prod != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setSoLuong(itemCart.getSoLuong() + 1);
			itemCart.setTongGia(itemCart.getSoLuong() * itemCart.getProduct().getDonGia());
		} else {
			itemCart.setProduct(prod);
			itemCart.setSoLuong(1);
			itemCart.setTongGia(prod.getDonGia());
		}
		cart.put(id, itemCart);

		return cart;
	}

	// delete cart
	@Override
	@Transactional
	public HashMap<Integer, CartDTO> deleteCart(int id, HashMap<Integer, CartDTO> cart) {
		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			cart.remove(id);
		}

		return cart;
	}

	// edit quanty cart
	@Override
	@Transactional
	public HashMap<Integer, CartDTO> editCart(int id, int soLuong, HashMap<Integer, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setSoLuong(soLuong);
			double tongGia = soLuong * itemCart.getProduct().getDonGia();
			// update total price
			itemCart.setTongGia(tongGia);
		}

		cart.put(id, itemCart);

		return cart;
	}

	// total quanty cart
	@Override
	@Transactional
	public int totalQuanty(HashMap<Integer, CartDTO> cart) {
		int tongSoLuong = 0;
		for (Map.Entry<Integer, CartDTO> itemCart : cart.entrySet()) {
			tongSoLuong += itemCart.getValue().getSoLuong();
		}

		return tongSoLuong;
	}

	// total price
	@Override
	@Transactional
	public double totalPrice(HashMap<Integer, CartDTO> cart) {
		double tongGia = 0;
		for (Map.Entry<Integer, CartDTO> itemCart : cart.entrySet()) {
			tongGia += itemCart.getValue().getTongGia();
		}

		return tongGia;
	}

}
