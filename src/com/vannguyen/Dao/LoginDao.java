/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Dao;

import com.vannguyen.Model.JDBC;
import com.vannguyen.Model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen
 */
public class LoginDao {

    static Connection connection = JDBC.getConnection();

    public static String checkLogin(String account, String password) {
        String result = "";
        String sql = "select role from login where account=? and password=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, account);
            pst.setString(2, password);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("role");
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static void addLogin(String account, String password, String role) {
        String sql = "insert into login values (?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
