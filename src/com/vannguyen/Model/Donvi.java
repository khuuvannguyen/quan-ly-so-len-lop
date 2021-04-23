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
public class Donvi {
    private String maDonvi;
    private String tenDonvi;

    public Donvi(String maDonvi, String tenDonvi) {
        this.maDonvi = maDonvi;
        this.tenDonvi = tenDonvi;
    }

    public Donvi() {
    }

    public String getMaDonvi() {
        return maDonvi;
    }

    public void setMaDonvi(String maDonvi) {
        this.maDonvi = maDonvi;
    }

    public String getTenDonvi() {
        return tenDonvi;
    }

    public void setTenDonvi(String tenDonvi) {
        this.tenDonvi = tenDonvi;
    }
    
}
