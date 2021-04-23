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
public class Monhoc {

    private String maMon;
    private String tenMon;
    private int hocKy;
    private int lyThuyet;
    private int thucHanh;

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public Monhoc(String maMon, String tenMon, int hocKy, int lyThuyet, int thucHanh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hocKy = hocKy;
        this.lyThuyet = lyThuyet;
        this.thucHanh = thucHanh;
    }

    public Monhoc() {
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
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

}
