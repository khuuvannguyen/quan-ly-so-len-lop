/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.Trang;
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
public class TrangDao {

    static Connection connection = JDBC.getConnection();
    

    public String GetMaMH(String tenMH) {
        String sql = "select * from monhoc where tenMH = N'" + tenMH + "'";
        String maMH = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                maMH = resultSet.getString("MAMH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maMH;
    }
    
    public boolean CheckMaso(String maGV, String namHoc){
        String sql = "select * from so "
                + "inner join giaovien "
                + "on so.magv = giaovien.magv "
                + "where giaovien.magv = ? "
                + "and so.nam = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            preparedStatement.setString(2, namHoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String GetMaSo(String maGV, String namHoc){
        String maSo = "";
        String sql = "select * from so "
                + "inner join giaovien "
                + "on so.magv = giaovien.magv "
                + "where giaovien.magv = ? "
                + "and so.nam = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            preparedStatement.setString(2, namHoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                maSo = resultSet.getString("MASO");
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maSo;
    }
    
    public List<Trang> getTrang(String maSo) {
        List<Trang> list = new ArrayList<Trang>();
        String sql = "select * from trang where maso = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Trang trang = new Trang();
                trang.setMaSo(resultSet.getString("MASO"));
                trang.setMaMon(resultSet.getString("MAMH"));
                trang.setMaLop(resultSet.getString("MALOP"));
                trang.setHocKy(resultSet.getInt("HOCKY"));
                trang.setMaTrang(resultSet.getString("MATRANG"));
                list.add(trang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean CheckLop(String maLop) {
        String sql = "select * from trang "
                + "inner join lop "
                + "on lop.malop = trang.malop "
                + "where lop.malop = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maLop);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<String> LoadDataToComboBox() {
        String sql = "select * from monhoc";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getNString("TENMH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhvienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertTrang(Trang trang) {
        String sql = "insert into trang values (?, ?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trang.getMaTrang());
            preparedStatement.setString(2, trang.getMaSo());
            preparedStatement.setString(3, trang.getMaMon());
            preparedStatement.setString(4, trang.getMaLop());
            preparedStatement.setInt(5, trang.getHocKy());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
