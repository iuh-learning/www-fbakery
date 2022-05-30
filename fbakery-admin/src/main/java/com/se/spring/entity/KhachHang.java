package com.se.spring.entity;

public class KhachHang {
    private int maKH;
    private String tenKH;
    private String diaChi;
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
