package com.se.spring.entity;

public class HoaDon {
	private int maHD;

	private String ngayLap;

	private double tongTien;

	private TrangThaiDonHang trangThaiDonHang;

	private KhachHang khachHang;

	public HoaDon(int maHD, String ngayLap, double tongTien, TrangThaiDonHang trangThaiDonHang, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.trangThaiDonHang = trangThaiDonHang;
		this.khachHang = khachHang;
	}

	public HoaDon() {
		super();
	}

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

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", trangThaiDonHang="
				+ trangThaiDonHang + ", khachHang=" + khachHang + "]";
	}

}
