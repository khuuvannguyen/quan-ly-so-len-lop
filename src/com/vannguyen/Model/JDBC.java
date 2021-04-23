/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nguyen
 */
public class JDBC {

    public static Connection getConnection() {
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSLL;integratedSecurity=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.print("Kết nối thất bại");
            e.printStackTrace();
        }
        return null;
    }
}
