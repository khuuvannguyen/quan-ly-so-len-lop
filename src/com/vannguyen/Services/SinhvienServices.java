/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.SinhvienDao;
import com.vannguyen.Model.Sinhvien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class SinhvienServices {
    private SinhvienDao sinhvienDao;

    public SinhvienServices() {
        sinhvienDao = new SinhvienDao();
    }
    public List<Sinhvien> getSinhvien(){
        return sinhvienDao.getSinhVien();
    }
    public void addSinhvien(Sinhvien sinhvien){
        sinhvienDao.insertSinhVien(sinhvien);
    }
    public ArrayList<String> LoadComboBox(){
        return sinhvienDao.LoadDataToComboBox();
    }
    public String TakeMaLop(String tenLop){
        return sinhvienDao.TakeMaLop(tenLop);
    }
    public void deleteSinhvien(String masinhvien){
        sinhvienDao.deleteSinhVien(masinhvien);
    }
    
    public boolean DuplicateSinhvien(String maSinhvien){
        return sinhvienDao.DuplicateSinhVien(maSinhvien);
    }
}
