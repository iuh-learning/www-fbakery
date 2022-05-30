package com.se.spring.entity;

public class ChiTietHoaDon {
	private int soLuong;
	private HoaDon hoaDon;
	private SanPham sanPham;

	public ChiTietHoaDon(int soLuong, HoaDon hoaDon, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}

	public ChiTietHoaDon() {
		super();
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + "]";
	}

	
}
