/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.Sinhvien;
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
public class SinhvienDao {

    static Connection connection = JDBC.getConnection();

    public List<Sinhvien> getSinhVien() {
        List<Sinhvien> list = new ArrayList<Sinhvien>();
        String sql = "select * from SINHVIEN";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sinhvien sinhvien = new Sinhvien();
                sinhvien.setMaSinhvien(resultSet.getString("MASV"));
                sinhvien.setHoTen(resultSet.getNString("TENSV"));
                sinhvien.setGioiTinh(resultSet.getNString("GIOITINH"));
                sinhvien.setNamSinh(resultSet.getString("NAMSINH"));
                sinhvien.setMaLop(resultSet.getString("MALOP"));
                list.add(sinhvien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<String> LoadDataToComboBox(){
        String sql = "select * from lop";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getNString("TENLOP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String TakeMaLop(String tenLop){
        String sql = "select malop from lop where tenlop = N'" + tenLop + "'";
        String maLop = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                maLop += resultSet.getString("MALOP");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maLop;
    }
    
    public boolean DuplicateSinhVien(String maSinhVien){
        String sql = "select * from SINHVIEN where MASV = '" + maSinhVien + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insertSinhVien(Sinhvien sinhvien) {
        String sql = "insert into sinhvien values (?, ?, ?, ? ,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sinhvien.getMaSinhvien());
            preparedStatement.setString(3, sinhvien.getHoTen());
            preparedStatement.setString(4, sinhvien.getGioiTinh());
            preparedStatement.setString(5, sinhvien.getNamSinh());
            preparedStatement.setString(2, sinhvien.getMaLop());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSinhVien(Sinhvien sinhvien) {
        String sql = "update sinhvien set TENSV = ?, gioitinh = ?, namsinh = ?, malop = ? where masv = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, sinhvien.getHoTen());
            preparedStatement.setNString(2, sinhvien.getGioiTinh());
            preparedStatement.setString(3, sinhvien.getNamSinh());
            preparedStatement.setString(4, sinhvien.getMaLop());
            preparedStatement.setString(5, sinhvien.getMaSinhvien());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteSinhVien(String masinhvien) {
        String sql = "delete from sinhvien where masv = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, masinhvien);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
