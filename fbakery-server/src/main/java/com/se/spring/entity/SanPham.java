package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SanPham")
public class SanPham {

	@Id
	@Column(name = "ma_sp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSP;

	@Column(name = "ten_sp")
	private String tenSP;

	@Column(name = "don_gia")
	private double donGia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ma_loai_san_pham")
	private LoaiSanPham loaiSanPham;

	@Column(name = "anh")
	private String anh;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "trang_thai")
	private int trangThai;

	public SanPham(@NotNull int maSP, String tenSP, double donGia, @NotNull LoaiSanPham loaiSanPham, String anh,
			String moTa, int trangThai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.loaiSanPham = loaiSanPham;
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

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
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

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", loaiSanPham=" + loaiSanPham
				+ ", anh=" + anh + ", moTa=" + moTa + ", trangThai=" + trangThai + "]";
	}

	
}
