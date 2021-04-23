/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.GiaovienDao;
import com.vannguyen.Model.Giaovien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class GiaovienServices {

    private GiaovienDao gd;

    public GiaovienServices() {
        gd = new GiaovienDao();
    }

    public boolean ExistsGiaovien(String maGV){
        return gd.ExistsGiaovien(maGV);
    }
    public List<Giaovien> getGiaovien() {
        return gd.getGiaoVien();
    }

    public void addGiaovien(Giaovien g) {
        gd.insertGiaoVien(g);
    }

    public ArrayList<String> LoadComboBox() {
        return gd.LoadDataToComboBox();
    }
    
    public boolean CheckGVDonvi(String maGV, String maDV){
        return gd.CheckGVDonvi(maGV, maDV);
    }

    public boolean DuplicateGiaovien(String maGiaovien) {
        return gd.DuplicateGiaoVien(maGiaovien);
    }

    public String TakeMaDV(String tenDonvi) {
        return gd.TakeMaDonVi(tenDonvi);
    }

}
