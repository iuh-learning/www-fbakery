package com.se.spring.entity;

public class TrangThaiDonHang {
	private int maTrangThai;
	private String tenTrangThai;

	public TrangThaiDonHang(int maTrangThai, String tenTrangThai) {
		super();
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = tenTrangThai;
	}

	public TrangThaiDonHang() {
		super();
	}

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

	@Override
	public String toString() {
		return "TrangThaiDonHang [maTrangThai=" + maTrangThai + ", tenTrangThai=" + tenTrangThai + "]";
	}

}
