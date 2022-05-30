package com.se.spring.entityHBN;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@IdClass(HBN_ChiTietHoaDonFK.class)
@Table(name = "ChiTietHoaDon")
public class HBN_ChiTietHoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_hd")
	private int hoaDon;

	@Id
	@Column(name = "ma_sp")
	private int sanPham;

	@Column(name = "so_luong")

	private int soLuong;

	public HBN_ChiTietHoaDon(int hoaDon, int sanPham, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public int getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(int hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSanPham() {
		return sanPham;
	}

	public void setSanPham(int sanPham) {
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
		return "HBN_ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}

}
