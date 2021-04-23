/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.Lop;
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
public class LopDao {

    static Connection connection = JDBC.getConnection();
    
    public boolean CheckLop(String maLop, String maTrang){
        String sql = "select * from trang where matrang = ? and malop = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maLop);
            preparedStatement.setString(2, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Lop> getLop() {
        List<Lop> list = new ArrayList<Lop>();
        String sql = "select * from lop";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lop lop = new Lop();
                lop.setMaLop(resultSet.getString("MALOP"));
                lop.setTenLop(resultSet.getNString("TENLOP"));
                list.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean DuplicateLop(String maLop) {
        String sql = "select * from lop where malop = '" + maLop + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insertLop(Lop lop) {
        String sql = "insert into lop values (?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lop.getMaLop());
            preparedStatement.setNString(2, lop.getTenLop());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLop(Lop lop) {
        String sql = "update lop set tenlop = ? where malop = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, lop.getTenLop());
            preparedStatement.setString(2, lop.getMaLop());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLop(String maLop) {
        String sql = "delete from lop where malop = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maLop);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(LopDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
