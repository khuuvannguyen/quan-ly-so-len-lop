/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Model;

/**
 *
 * @author Nguyen
 */
public class SoLL {

    private String maSo;
    private String maGiaovien;
    private String maDonvi;
    private String namHoc;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getMaGiaovien() {
        return maGiaovien;
    }

    public void setMaGiaovien(String maGiaovien) {
        this.maGiaovien = maGiaovien;
    }

    public String getMaDonvi() {
        return maDonvi;
    }

    public void setMaDonvi(String maDonvi) {
        this.maDonvi = maDonvi;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public SoLL() {
    }

    public SoLL(String maSo, String maGiaovien, String maDonvi, String namHoc) {
        this.maSo = maSo;
        this.maGiaovien = maGiaovien;
        this.maDonvi = maDonvi;
        this.namHoc = namHoc;
    }
}
