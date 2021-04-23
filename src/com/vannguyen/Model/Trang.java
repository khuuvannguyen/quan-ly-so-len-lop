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
public class Trang {

    private String maTrang;
    private String maLop;
    private String maMon;
    private String maSo;
    private int hocKy;

    public Trang(String maTrang, String maSo, String maMon, String maLop, int hocKy) {
        this.maLop = maLop;
        this.maMon = maMon;
        this.maSo = maSo;
        this.hocKy = hocKy;
        this.maTrang = maTrang;
    }

    public Trang() {
    }

    public String getMaTrang(){
        return maTrang;
    }
    
    public void setMaTrang(String maTrang){
        this.maTrang = maTrang;
    }
    
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

}
