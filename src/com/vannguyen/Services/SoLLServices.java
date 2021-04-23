/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Services;

import com.vannguyen.Dao.SoLLDao;
import com.vannguyen.Model.SoLL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen
 */
public class SoLLServices {

    private SoLLDao dao;

    public SoLLServices() {
        dao = new SoLLDao();
    }
    
   public boolean checkLopTrang(String maLop, String maTrang){
       return dao.checkLopTrang(maLop, maTrang);
   }
    
    public boolean checkMaTrang(String maTrang){
        return dao.checkMaTrang(maTrang);
    }

    public List<SoLL> getSoLL() {
        return dao.getSoLL();
    }

    public void addSoLL(SoLL l) {
        dao.insertSoLL(l);
    }
    public boolean DuplicateSoLL(String maSo){
        return dao.DuplicateSoLL(maSo);
    }
    
    public ArrayList<String> LoadComboBox(){
        return dao.LoadDataToComboBox();
    }
    
    public boolean ExistsSoLL(String maSo){
        return dao.ExistsSoLL(maSo);
    }
    
    public String TakeMaDV(String tenDV){
        return dao.TakeMaDV(tenDV);
    }
}
