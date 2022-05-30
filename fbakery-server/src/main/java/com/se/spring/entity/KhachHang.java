package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "KhachHang")
public class KhachHang {

	@Id
	@Column(name = "ma_kh")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKH;

	@Column(name = "ten_kh")
	private String tenKH;

	@Column(name = "dia_chi")
	private String diaChi;

	@Column(name = "sdt")
	private String sdt;

	@Column(name = "trang_thai")
	private int trangThai;
	
	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
}
