/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.Monhoc;
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
public class MonhocDao {

    static Connection connection = JDBC.getConnection();

    public boolean checkMH(String maMH){
        String sql = "select * from monhoc where mamh = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean CheckMonTrang(String maTrang, String maMH){
        String sql = "select * from trang where matrang = ? and mamh = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            preparedStatement.setString(2, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Monhoc> getMonHoc() {
        List<Monhoc> list = new ArrayList<Monhoc>();
        String sql = "select * from monhoc";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Monhoc monhoc = new Monhoc();
                monhoc.setMaMon(resultSet.getString("MAMH"));
                monhoc.setTenMon(resultSet.getNString("TENMH"));
                monhoc.setHocKy((resultSet.getInt("HOCKY")));
                monhoc.setLyThuyet(resultSet.getInt("LYTHUYET"));
                monhoc.setThucHanh(resultSet.getInt("THUCHANH"));
                list.add(monhoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean DuplacateMonHoc(String maMH){
        String sql = "select * from monhoc where mamh = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insertMonHoc(Monhoc monhoc) {
        String sql = "insert into monhoc values (?, ?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, monhoc.getMaMon());
            preparedStatement.setNString(2, monhoc.getTenMon());
            preparedStatement.setInt(3, monhoc.getHocKy());
            preparedStatement.setInt(4, monhoc.getLyThuyet());
            preparedStatement.setInt(5, monhoc.getThucHanh());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMonHoc(Monhoc monhoc) {
        String sql = "update monhoc set tenmh = ?, lythuyet = ?, thuchanh = ? where mamh = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, monhoc.getTenMon());
            preparedStatement.setInt(2, monhoc.getLyThuyet());
            preparedStatement.setInt(3, monhoc.getThucHanh());
            preparedStatement.setString(4, monhoc.getMaMon());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMonHoc(String maMon) {
        String sql = "delete monhoc where mamh = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMon);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MonhocDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
