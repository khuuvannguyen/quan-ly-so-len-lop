/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.Donvi;
import com.vannguyen.Model.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen
 */
public class DonviDao {

    static Connection connection = JDBC.getConnection();

    public List<Donvi> getDonVi() {
        List<Donvi> list = new ArrayList<Donvi>();
        String sql = "select * from donvi";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Donvi donvi = new Donvi();
                donvi.setMaDonvi(resultSet.getString("MADV"));
                donvi.setTenDonvi(resultSet.getNString("TENDV"));
                list.add(donvi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonviDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean DuplicateMaDonvi(String maDonvi){
        String sql = "select * from donvi where madv = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maDonvi);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonviDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insertDonVi(Donvi donvi) {
        String sql = "insert into donvi values (?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, donvi.getMaDonvi());
            preparedStatement.setNString(2, donvi.getTenDonvi());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DonviDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void updateDonVi(Donvi donvi) {
//        String sql = "update donvi set tendonvi = ? where madonvi = ?";
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setNString(1, donvi.getTenDonvi());
//            preparedStatement.setString(2, donvi.getMaDonvi());
//            preparedStatement.executeUpdate();
//            connection.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(DonviDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteDonVi(String maDonvi) {
//        String sql = "delete from donvi where madonvi = ?";
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, maDonvi);
//            preparedStatement.executeUpdate();
//            connection.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(DonviDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
