package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TrangThaiDonHang")
public class TrangThaiDonHang {

	@Id
	@Column(name = "ma_trang_thai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTrangThai;

	@Column(name = "ten_trang_thai")
	private String tenTrangThai;

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
	
}
