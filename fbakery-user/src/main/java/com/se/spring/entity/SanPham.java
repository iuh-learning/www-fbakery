package com.se.spring.entity;

public class SanPham {
	private int maSP;
	private String tenSP;
	private double donGia;
	private LoaiSanPham loaiSP;
	private String anh;
	private String moTa;
	private int trangThai;

	public SanPham(int maSP, String tenSP, double donGia, LoaiSanPham loaiSP, String anh, String moTa, int trangThai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
		this.anh = anh;
		this.moTa = moTa;
		this.trangThai = trangThai;
	}

	public SanPham() {
		super();
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public LoaiSanPham getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", loaiSP=" + loaiSP + ", anh="
				+ anh + ", trangThai=" + trangThai + "]";
	}

}
