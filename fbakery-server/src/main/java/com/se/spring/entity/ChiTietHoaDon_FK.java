package com.se.spring.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDon_FK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hoaDon;
	private int sanPham;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoaDon, sanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon_FK other = (ChiTietHoaDon_FK) obj;
		return hoaDon == other.hoaDon && sanPham == other.sanPham;
	}

}
