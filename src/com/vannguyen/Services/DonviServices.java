/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.DonviDao;
import com.vannguyen.Model.Donvi;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class DonviServices {

    private DonviDao donviDao;

    public DonviServices() {
        donviDao = new DonviDao();
    }

    public List<Donvi> getDonvi() {
        return donviDao.getDonVi();
    }

    public void addDonvi(Donvi donvi) {
        donviDao.insertDonVi(donvi);
    }
    public boolean DuplicateMaDonvi(String maDonvi){
        return donviDao.DuplicateMaDonvi(maDonvi);
    }
}
