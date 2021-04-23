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
public class Sinhvien {

    private String maSinhvien;
    private String hoTen;
    private String gioiTinh;
    private String namSinh;
    private String maLop;

    public Sinhvien(String maSinhvien, String hoTen, String gioiTinh, String namSinh, String maLop) {
        this.maSinhvien = maSinhvien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.maLop = maLop;
    }

    public Sinhvien() {
    }

    public String getMaSinhvien() {
        return maSinhvien;
    }

    public void setMaSinhvien(String maSinhvien) {
        this.maSinhvien = maSinhvien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

}
