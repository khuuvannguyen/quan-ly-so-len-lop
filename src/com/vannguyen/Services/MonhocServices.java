/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.MonhocDao;
import com.vannguyen.Model.Monhoc;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class MonhocServices {

    private MonhocDao monhocDao;

    public MonhocServices() {
        monhocDao = new MonhocDao();
    }
    
    public boolean checkMH(String maMH){
        return monhocDao.checkMH(maMH);
    }

    public boolean CheckMonTrang(String maTrang, String maMH){
        return monhocDao.CheckMonTrang(maTrang, maMH);
    }
    
    public List<Monhoc> getMonhoc() {
        return monhocDao.getMonHoc();
    }

    public void addMonhoc(Monhoc monhoc) {
        monhocDao.insertMonHoc(monhoc);
    }

    public void deleteMonhoc(String maMon) {
        monhocDao.deleteMonHoc(maMon);
    }
    
    public boolean DuplicationMonHoc(String maMH){
        return monhocDao.DuplacateMonHoc(maMH);
    }
}
