/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Model;

/**
 *
 * @author Nguyen
 */
public class Login {
    private String account;
    private String password;
    private String role;

    public Login(String account, String password, String role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public Login() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
