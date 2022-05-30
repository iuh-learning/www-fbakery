package com.se.spring.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoaiSanPham {
	private int maLoaiSP;
	
	@NotBlank(message = "Không được rỗng")
	@Pattern(regexp = "(?:([A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]|[A-Z])\\s?)++", message = "Tên loại sản phẩm không hợp lệ")
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
