/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.DetailTrangDao;
import com.vannguyen.Model.DetailTrang;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class DetailTrangServices {

    private DetailTrangDao trangDao;

    public DetailTrangServices() {
        trangDao = new DetailTrangDao();
    }

    public void sinhvienKyTen(String maTrang, String maSV, String ngayLL, String buoi){
        trangDao.sinhvienKyTen(maTrang, maSV, ngayLL, buoi);
    }
    
    public List<DetailTrang> getDetail(String maTrang) {
        return trangDao.getDetail(maTrang);
    }

    public void addDetailTrang(DetailTrang trang) {
        trangDao.insertDetailTrang(trang);
    }

    public String getTenGV(String maGV) {
        return trangDao.getTenGV(maGV);
    }

    public String getTenMH(String maMH) {
        return trangDao.getTenMon(maMH);
    }
}
