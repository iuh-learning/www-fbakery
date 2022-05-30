package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "loaiSanPham")
public class LoaiSanPham {

	@Id
	@NotNull
	@Column(name = "ma_loai_san_pham")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoaiSP;

	@Column(name = "ten_loai_san_pham")
	private String tenLoaiSP;

	public int getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [maLoaiSP=" + maLoaiSP + ", tenLoaiSP=" + tenLoaiSP + "]";
	}
	
	
	
}
