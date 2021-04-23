/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.SoLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen
 */
public class SoLLDao {

    static Connection connection = JDBC.getConnection();

    public boolean checkLopTrang(String maLop, String maTrang){
        String sql = "select * from trang "
                + "inner join lop "
                + "on lop.malop = trang.malop "
                + "where lop.malop = ? "
                + "and trang.matrang = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maLop);
            preparedStatement.setString(2, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(SoLLDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkMaTrang(String maTrang) {
        String sql = "select * from trang "
                + "where trang.matrang = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SoLL> getSoLL() {
        List<SoLL> list = new ArrayList<SoLL>();
        String sql = "select * from so";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SoLL soLL = new SoLL();
                soLL.setMaSo(resultSet.getString("MASO"));
                soLL.setMaDonvi(resultSet.getString("MADV"));
                soLL.setMaGiaovien(resultSet.getString("MAGV"));
                soLL.setNamHoc(resultSet.getString("NAM"));
                list.add(soLL);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoLLDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertSoLL(SoLL soLL) {
        String sql = "insert into so values (?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, soLL.getMaSo());
            preparedStatement.setString(2, soLL.getMaGiaovien());
            preparedStatement.setString(3, soLL.getMaDonvi());
            preparedStatement.setString(4, soLL.getNamHoc());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SoLLDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean DuplicateSoLL(String maSoLL) {
        String sql = "select * from so where maso = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSoLL);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoLLDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<String> LoadDataToComboBox() {
        String sql = "select * from donvi";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getNString("TENDV"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String TakeMaDV(String tenDV) {
        String sql = "select madv from donvi where tendv = N'" + tenDV + "'";
        String maDV = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                maDV += resultSet.getString("MADV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maDV;
    }

    public boolean ExistsSoLL(String maSo) {
        String sql = "select * from so where maso = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoLLDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
