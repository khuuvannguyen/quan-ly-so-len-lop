/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.LopDao;
import com.vannguyen.Model.Lop;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class LopServices {

    private LopDao lopDao;

    public LopServices() {
        lopDao = new LopDao();
    }

    public List<Lop> getLop() {
        return lopDao.getLop();
    }

    public void addLop(Lop lop) {
        lopDao.insertLop(lop);
    }

    public void deleteLop(String maLop) {
        lopDao.deleteLop(maLop);
    }

    public boolean DuplicateLop(String maLop) {
        return lopDao.DuplicateLop(maLop);
    }

}
