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
public class Giaovien {

    private String maGiaovien;
    private String hoTen;
    private String gioiTinh;
    private String namSinh;
    private String maDonvi;

    public Giaovien(String maGiaovien, String hoTen, String gioiTinh, String namSinh, String maDonvi) {
        this.maGiaovien = maGiaovien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.maDonvi = maDonvi;
    }

    public Giaovien() {
    }

    public String getMaGiaovien() {
        return maGiaovien;
    }

    public void setMaGiaovien(String maGiaovien) {
        this.maGiaovien = maGiaovien;
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

    public String getMaDonvi() {
        return maDonvi;
    }

    public void setMaDonvi(String maDonvi) {
        this.maDonvi = maDonvi;
    }

}
