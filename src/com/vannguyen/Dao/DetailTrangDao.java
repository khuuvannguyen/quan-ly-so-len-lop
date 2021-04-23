/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.DetailTrang;
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
public class DetailTrangDao {

    static Connection connection = JDBC.getConnection();

    //Dành cho sinh viên
    public void sinhvienKyTen(String maTrang, String maSV, String ngayLL, String buoi){
        String sql = "update detailtrang set masv = ? where matrang = ? and ngayll = ? and buoi = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, maSV);
            preparedStatement.setString(2, maTrang);
            preparedStatement.setString(3, ngayLL);
            preparedStatement.setNString(4, buoi);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DetailTrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Dành cho giáo viên
    public void insertDetailTrang(DetailTrang detailTrang) {
        String sql = "insert into detailtrang values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, detailTrang.getMaSV());
            preparedStatement.setString(2, detailTrang.getMaTrang());
            preparedStatement.setString(3, detailTrang.getNgayLL());
            preparedStatement.setNString(4, detailTrang.getBuoi());
            preparedStatement.setString(5, detailTrang.getPhong());
            preparedStatement.setInt(6, detailTrang.getLyThuyet());
            preparedStatement.setInt(7, detailTrang.getThucHanh());
            preparedStatement.setNString(8, detailTrang.getTomTat());
            preparedStatement.setNString(9, detailTrang.getSinhvienVang());
            preparedStatement.setBoolean(10, detailTrang.isGiaovienKy());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DetailTrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Dành cho sinh viên khi ký sổ => kiểm tra lớp của sinh viên có trùng với lớp trong sổ
    public static boolean CheckSinhvienLop(String maSinhvien, String maLop) {
        String sql = "select sinhvien.malop from sinhvien, lop, trang where "
                + "sinhvien.masv = ? "
                + "and lop.malop = ? "
                + "and sinhvien.malop = lop.malop "
                + "and lop.malop = trang.malop";
        String check = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSinhvien);
            preparedStatement.setString(2, maLop);
            ResultSet resultSet = preparedStatement.executeQuery();
            check = resultSet.getString("MALOP");
            if (check.equals(maLop)) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailTrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<DetailTrang> getDetail(String maTrang) {
        String sql = "select * from detailtrang where matrang = ?";
        List<DetailTrang> list = new ArrayList<DetailTrang>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DetailTrang trang = new DetailTrang();
                trang.setNgayLL(resultSet.getString("NGAYLL"));
                trang.setBuoi(resultSet.getNString("BUOI"));
                trang.setPhong(resultSet.getString("PHONG"));
                trang.setLyThuyet(resultSet.getInt("LYTHUYET"));
                trang.setThucHanh(resultSet.getInt("THUCHANH"));
                trang.setTomTat(resultSet.getNString("TOMTAT"));
                trang.setSinhvienVang(resultSet.getNString("SINHVIENVANG"));
                trang.setGiaovienKy(resultSet.getBoolean("GIAOVIENKY"));
                trang.setMaSV(resultSet.getString("MASV"));
                list.add(trang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailTrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Dành cho sinh viên + giáo viên
    public String getTenGV(String maSo) {
        String sql = "select tengv from giaovien "
                + "inner join so "
                + "on so.magv = giaovien.magv "
                + "where maso = ?";
        String tenGV = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSo);
            ResultSet resultSet = preparedStatement.executeQuery();
            tenGV = resultSet.getNString("TENGV");
        } catch (SQLException ex) {
            Logger.getLogger(DetailTrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenGV;
    }

    public String getTenMon(String maMH) {
        String sql = "select tenmh from monhoc where mamh = ?";
        String tenMH = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            tenMH = resultSet.getNString("TENMH");
        } catch (SQLException ex) {
            Logger.getLogger(TrangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenMH;
    }
}
