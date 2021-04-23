/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.TrangDao;
import com.vannguyen.Model.Trang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class TrangServices {

    private TrangDao trangDao;

    public TrangServices() {
        trangDao = new TrangDao();
    }

    
    public String GetMaMH(String tenMH){
        return trangDao.GetMaMH(tenMH);
    }
    
    public List<Trang> getTrang(String maSo) {
        return trangDao.getTrang(maSo);
    }

    public void addTrang(Trang trang) {
        trangDao.insertTrang(trang);
    }

    public ArrayList<String> LoadComboBox() {
        return trangDao.LoadDataToComboBox();
    }

    public boolean CheckMaSo(String maSo, String namHoc) {
        return trangDao.CheckMaso(maSo, namHoc);
    }

    public String GetMaSo(String maSo, String namHoc) {
        return trangDao.GetMaSo(maSo, namHoc);
    }

    public boolean CheckMaLop(String maLop){
        return trangDao.CheckLop(maLop);
    }

}
