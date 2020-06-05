/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_java.Models;

/**
 *
 * @author ADMIN
 */
public class User {
    private String user_name;
    private String password;
    private int permission;

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public int getPermission() {
        return permission;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
