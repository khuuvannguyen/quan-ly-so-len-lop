/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.NamHoc;
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
public class NewDao {

    static Connection connection = JDBC.getConnection();

    //Đã có sinh viên ký sổ
    public static boolean checkKyten(String maTrang, String ngayLL, String buoi) {
        String sql = "select * from detailtrang where matrang = ? and ngayLL = ? and buoi = ?";
        String maSV = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            preparedStatement.setString(2, ngayLL);
            preparedStatement.setNString(3, buoi);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                try {
                    if (!resultSet.getString("MASV").equals(maSV)) {
                        return false;
                    }
                } catch (NullPointerException e) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //Lấy tên đơn vị của giáo viên
    public static String getTenDV(String maGV) {
        String sql = "select * from donvi "
                + "inner join giaovien "
                + "on giaovien.madv = donvi.madv "
                + "where giaovien.magv = ?";
        String tenDV = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tenDV = resultSet.getNString("TENDV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenDV;
    }

    //lấy tên của giáo viên
    public static String getTenGV(String maGV) {
        String sql = "select * from giaovien where magv = ?";
        String tenGV = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tenGV = resultSet.getNString("TENGV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenGV;
    }

    //tính tổng số tiết lý thuyết có trong detailtrang
    public static int sumLythuyet(String maTrang) {
        String sql = "select * from detailtrang where matrang = ?";
        int sum = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sum += resultSet.getInt("LYTHUYET");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    //tính tổng số tiết thực hành có tỏng detailtrang
    public static int sumThuchanh(String maTrang) {
        String sql = "select * from detailtrang where matrang = ?";
        int sum = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sum += resultSet.getInt("THUCHANH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    //lấy ra số tiết lý thuyết của môn
    public static int getLythuyet(String maMH) {
        String sql = "select * from monhoc where mamh = ?";
        int lythuyet = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                lythuyet = resultSet.getInt("LYTHUYET");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lythuyet;
    }

    //lấy ra số tiết thực hành của môn
    public static int getThuchanh(String maMH) {
        String sql = "select * from monhoc where mamh = ?";
        int thuchanh = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                thuchanh = resultSet.getInt("THUCHANH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thuchanh;
    }

    //Check lớp của sinh viên
    public static boolean checkLopSV(String maTrang, String maSV) {
        String sql = "select trang.malop from trang, sinhvien, detailtrang "
                + "where sinhvien.malop = trang.malop "
                + "and detailtrang.matrang = trang.matrang "
                + "and detailtrang.matrang = ? "
                + "and sinhvien.masv = ? "
                + "group by trang.malop";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            preparedStatement.setString(2, maSV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //sinh viên ký tên
    public static void kyTen(String maTrang, String maSV, String ngayLL, String buoi) {
        String sql = "update detailtrang set masv = ? where matrang = ? and ngayLL = ? and buoi = ?";
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
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ngày + buổi đã tồn tại
    public static boolean duplicateNgayBuoi(String maTrang, String ngayLL, String buoi) {
        String sql = "select * from detailtrang where ngayLL = ? and buoi = ? and matrang = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ngayLL);
            preparedStatement.setNString(2, buoi);
            preparedStatement.setString(3, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //Lấy mã môn học từ tên môn
    public static String getMaMH(String tenMH) {
        String sql = "select * from monhoc where tenmh = ?";
        String maMH = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, tenMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maMH = resultSet.getString("MAMH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maMH;
    }

    //lấy mã trang ở sinh viên ký tên
    public static String getMaTrang(String maGV, String namHoc, String maSV, String maMH) {
        String sql = "select trang.matrang from trang, lop, giaovien, so, sinhvien "
                + "where giaovien.magv = so.magv "
                + "and lop.malop = trang.malop "
                + "and so.maso = trang.maso "
                + "and sinhvien.malop = lop.malop "
                + "and giaovien.magv = ? "
                + "and lop.malop = sinhvien.malop "
                + "and so.nam = ? "
                + "and sinhvien.masv = ? "
                + "and trang.mamh = ?";
        String maTrang = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            preparedStatement.setString(2, namHoc);
            preparedStatement.setString(3, maSV);
            preparedStatement.setString(4, maMH);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maTrang = resultSet.getString("MATRANG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maTrang;
    }

    //load tên môn học vào combo Box
    public static ArrayList<String> loadMonhocToCombo() {
        String sql = "select * from monhoc";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("TENMH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //load mã giáo viên vào combo Box
    public static ArrayList<String> loadMaGVtoCombo() {
        String sql = "select * from giaovien";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("MAGV"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Đổi năm học dài thành mã để tạo mã sổ
    public static String changeNamHoc(String namHoc) {
        String nam = namHoc.substring(2, 4) + namHoc.substring(7);
        return nam;
    }

    //Đổi mã giáo viên dài thành mã để tạo mã sổ
    public static String changeMaGV(String maGV) {
        String gv = maGV.substring(2);
        return gv;
    }

    //Đưa mã lớp vào combo Box
    public static ArrayList<String> loadMalopToCombo() {
        String sql = "select * from lop";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("MALOP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Đưa năm học vào combo Box
    public static ArrayList<String> loadNamhocToCombo() {
        String sql = "select * from namhoc";
        ArrayList<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("NAM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Thêm năm học mới
    public static void addNamHoc(NamHoc namHoc) {
        String sql = "insert into namhoc values (?)";
        PreparedStatement preparedStatement;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, namHoc.getNamHoc());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Năm học bị trùng
    public static boolean duplicateNamHoc(String namHoc) {
        String sql = "select * from namhoc where nam = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, namHoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean duplicateTrang(String maTrang) {
        String sql = "select * from trang where matrang = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTrang);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Lọc các môn học trong 1 học kỳ
    public static ArrayList<String> getMonHocbyHocKy(int hocKy) {
        String sql = "select * from monhoc where hocky = ?";
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hocKy);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("TENMH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Lấy mã đơn vị của giáo viên
    public static String getDonviOfGiaovien(String maGV) {
        String sql = "select * from giaovien where magv = ?";
        String maDV = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maGV);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                maDV = resultSet.getString("MADV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maDV;
    }

}
