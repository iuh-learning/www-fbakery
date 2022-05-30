package com.se.spring.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class KhachHang {
	private int maKH;
	@NotBlank(message = "Không được rỗng")
	@Pattern(regexp = "(?:([A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]|[A-Z])\\s?)++", message = "Tên không hợp lệ")
	private String tenKH;
	
	@NotBlank(message = "Không được rỗng")
	private String diaChi;
	
	@NotBlank(message = "Không được rỗng")
	@Pattern(regexp = "^((09(0|3|1|4|6|7|8|9)(\\d){7})|(03(2|3|4|5|6|7|8|9)(\\d){7})|(08(6|8|1|2|3|4|5|9)(\\d){7})|(07(0|6|7|8|9)(\\d){7})|(05(9|6|8)(\\d){7}))$", message = "Số điện thoại không hợp lệ")
	private String sdt;
	
	private int trangThai;

	public KhachHang(int maKH, String tenKH, String diaChi, String sdt, int trangThai) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.trangThai = trangThai;
	}

	public KhachHang() {
		super();
	}

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

	@Override
	public String toString() {
		return "KhachHang [diaChi=" + diaChi + ", maKH=" + maKH + ", sdt=" + sdt + ", tenKH=" + tenKH + ", trangThai="
				+ trangThai + "]";
	}
}
