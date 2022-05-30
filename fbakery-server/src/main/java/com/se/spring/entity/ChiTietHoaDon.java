
package com.se.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "ChiTietHoaDon")

@IdClass(ChiTietHoaDon_FK.class)
public class ChiTietHoaDon {

	@Id @ManyToOne @JoinColumn(name = "ma_hd") private HoaDon hoaDon;

	@Id @ManyToOne @JoinColumn(name = "ma_sp") private SanPham sanPham;

	@Column(name = "so_luong")
	
	
	private int soLuong;

	public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	
	public ChiTietHoaDon() {
		super();
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}

	
}
