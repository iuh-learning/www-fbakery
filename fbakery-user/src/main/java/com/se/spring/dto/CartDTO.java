package com.se.spring.dto;

import java.io.Serializable;

import com.se.spring.entity.SanPham;

public class CartDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int soLuong;
	private double tongGia;
	private SanPham product;

	public CartDTO() {
		super();
	}

	public CartDTO(int soLuong, double tongGia, SanPham product) {
		super();
		this.soLuong = soLuong;
		this.tongGia = tongGia;
		this.product = product;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

	public SanPham getProduct() {
		return product;
	}

	public void setProduct(SanPham product) {
		this.product = product;
	}

}
