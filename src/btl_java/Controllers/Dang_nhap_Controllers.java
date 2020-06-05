/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_java.Controllers;

import btl_java.Models.De_Tai;
import btl_java.Models.Main_Models;
import btl_java.Models.Nhom;
import btl_java.Models.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class Dang_nhap_Controllers {

    connection n = new connection();

    public void get_de_tai() {
        Main_Models.De_Tai_Models.clear();
        try {
            String sql = "Select * from detai";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                De_Tai a = new De_Tai();
                a.setMa_de_tai(rs.getString("madetai"));
                a.setTen_de_tai(rs.getString("tendetai"));
                a.setMa_gv(rs.getString("magv"));
                a.setMa_nhom(rs.getString("manhom"));
                a.setCheck(rs.getInt("check_detai"));
                Main_Models.De_Tai_Models.add(a);
            }
        } catch (Exception e) {
        }
    }
    public void get_nhom() {
        Main_Models.Nhom_Models.clear();
        try {
            String sql = "Select * from nhom";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Nhom a = new Nhom();
                a.setMa_nhom(rs.getString("manhom"));
                a.setTen_nhom(rs.getString("tennhom"));
                Main_Models.Nhom_Models.add(a);
            }
        } catch (Exception e) {
        }
    }
}
