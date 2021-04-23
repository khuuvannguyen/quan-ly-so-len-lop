/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Model;

import java.sql.Date;

/**
 *
 * @author Nguyen
 */
public class DetailTrang {

    private String maSV;
    private String maTrang;
    private String ngayLL;
    private String buoi;
    private String phong;
    private int lyThuyet;
    private int thucHanh;
    private String tomTat;
    private String sinhvienVang;
    private boolean giaovienKy;

    public DetailTrang(String maSV, String maTrang, String ngayLL, String buoi, String phong, int lyThuyet, int thucHanh, String tomTat, String sinhvienVang, boolean giaovienKy) {
        this.maSV = maSV;
        this.maTrang = maTrang;
        this.ngayLL = ngayLL;
        this.buoi = buoi;
        this.phong = phong;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
        this.tomTat = tomTat;
        this.sinhvienVang = sinhvienVang;
        this.giaovienKy = giaovienKy;
    }

    public DetailTrang() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaTrang() {
        return maTrang;
    }

    public void setMaTrang(String maTrang) {
        this.maTrang = maTrang;
    }

    public String getNgayLL() {
        return ngayLL;
    }

    public void setNgayLL(String ngayLL) {
        this.ngayLL = ngayLL;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getLyThuyet() {
        return lyThuyet;
    }

    public void setLyThuyet(int lyThuyet) {
        this.lyThuyet = lyThuyet;
    }

    public int getThucHanh() {
        return thucHanh;
    }

    public void setThucHanh(int thucHanh) {
        this.thucHanh = thucHanh;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getSinhvienVang() {
        return sinhvienVang;
    }

    public void setSinhvienVang(String sinhvienVang) {
        this.sinhvienVang = sinhvienVang;
    }

    public boolean isGiaovienKy() {
        return giaovienKy;
    }

    public void setGiaovienKy(boolean giaovienKy) {
        this.giaovienKy = giaovienKy;
    }

}
