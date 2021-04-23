/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import static com.vannguyen.Dao.SinhvienDao.connection;
import com.vannguyen.Model.Giaovien;
import com.vannguyen.Model.JDBC;
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
public class GiaovienDao {

    static Connection connection = JDBC.getConnection();

    public List<Giaovien> getGiaoVien() {
        List<Giaovien> list = new ArrayList<Giaovien>();
        String sql = "select * from giaovien";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Giaovien giaovien = new Giaovien();
                giaovien.setMaGiaovien(resultSet.getString("MAGV"));
                giaovien.setHoTen(resultSet.getNString("TENGV"));
                giaovien.setGioiTinh(resultSet.getNString("GIOITINH"));
                giaovien.setNamSinh(resultSet.getString("NAMSINH"));
                giaovien.setMaDonvi(resultSet.getString("MADV"));
                list.add(giaovien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<String> LoadDataToComboBox(){
        String sql = "select * from donvi";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(resultSet.getNString("tendv"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String TakeMaDonVi(String tenDonVi){
        String sql = "select madv from donvi where tendv = N'" + tenDonVi + "'";
        String maDV = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                maDV += resultSet.getString("MADV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maDV;
    }
    
    public boolean CheckGVDonvi(String maGV, String maDV){
        String sql = "select * from giaovien where magv = ? and madv = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            preparedStatement.setString(2, maDV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean DuplicateGiaoVien(String maGiaovien){
        String sql = "select * from giaovien where magv = '" + maGiaovien + "'";
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
    
    public boolean ExistsGiaovien(String maGV){
        String sql = "select * from giaovien where magv = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insertGiaoVien(Giaovien giaovien) {
        String sql = "insert into giaovien values (?, ?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, giaovien.getMaGiaovien());
            preparedStatement.setNString(3, giaovien.getHoTen());
            preparedStatement.setNString(4, giaovien.getGioiTinh());
            preparedStatement.setString(5, giaovien.getNamSinh());
            preparedStatement.setString(2, giaovien.getMaDonvi());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void updateGiaoVien(Giaovien giaovien) {
//        String sql = "update giaovien set hoten = ?, gioitinh = ?, namsinh = ?, madonvi = ? where magiaovien = ?";
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setNString(1, giaovien.getHoTen());
//            preparedStatement.setNString(2, giaovien.getGioiTinh());
//            preparedStatement.setDate(3, giaovien.getNamSinh());
//            preparedStatement.setString(4, giaovien.getMaDonvi());
//            preparedStatement.setString(5, giaovien.getMaGiaovien());
//            preparedStatement.executeUpdate();
//            connection.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void deleteGiaoVien(Giaovien giaovien) {
//        String sql = "delete from giaovien where magiaovien = ?";
//        try {
//            connection.setAutoCommit(false);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, giaovien.getMaGiaovien());
//            preparedStatement.executeUpdate();
//            connection.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(GiaovienDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
