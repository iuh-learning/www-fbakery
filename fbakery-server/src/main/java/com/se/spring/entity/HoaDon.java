package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "HoaDon")
public class HoaDon {
	@Id
	@Column(name = "ma_hd")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHD;

	@Column(name = "ngay_lap")
	private String ngayLap;

	@Column(name = "tong_tien")
	private double tongTien;

	@ManyToOne
	@JoinColumn(name = "ma_trang_thai")
	private TrangThaiDonHang trangThaiDonHang;

	@ManyToOne
	@JoinColumn(name = "ma_kh")
	private KhachHang khachHang;

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public TrangThaiDonHang getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(TrangThaiDonHang trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
}
