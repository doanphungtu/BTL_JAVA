/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_java.Controllers;

import btl_java.Models.Main_Models;
import btl_java.Models.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class SV_Dang_Ky_De_Tai_Contronllers {

    connection n = new connection();

    public void get_nhom(JComboBox cb_nhom) {
        try {
            for (int i = 0; i < Main_Models.Nhom_Models.size(); i++) {
                cb_nhom.addItem(Main_Models.Nhom_Models.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String get_ma_nhom(JComboBox cb_nhom) {
        for (int i = 0; i < Main_Models.Nhom_Models.size(); i++) {
            if (Main_Models.Nhom_Models.get(i).getTen_nhom().equals(cb_nhom.getSelectedItem().toString())) {
                return Main_Models.Nhom_Models.get(i).getMa_nhom().toString();
            }
        }
        return "";
    }

    public void get_de_tai(JComboBox cb_detai, JComboBox cb_nhom) {
        cb_detai.removeAllItems();
        for (int i = 0; i < Main_Models.De_Tai_Models.size(); i++) {
            if (get_ma_nhom(cb_nhom).equals(Main_Models.De_Tai_Models.get(i).getMa_nhom().toString())) {
                cb_detai.addItem(Main_Models.De_Tai_Models.get(i));
            }
        }
    }

    public void get_name_sv(JTextField txt_name_sv) {
        try {
            String sql = "select hoten from sinhvien where masv=?";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ps.setString(1, Main_Models.User_Models.getUser_name());
            ResultSet rs = ps.executeQuery();
            rs.next();
            txt_name_sv.setText(rs.getString("hoten"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void get_name_gv(JTextField txt_name_gv, JComboBox cb_detai) {
        try {
            String sql = "select * from detai where tendetai=?";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ps.setString(1, cb_detai.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();

            Main_Models.Phieu_Dang_Ky_Models.setMa_de_tai(rs.getString("madetai"));
            Main_Models.Phieu_Dang_Ky_Models.setMa_gv(rs.getString("magv"));
            Main_Models.Phieu_Dang_Ky_Models.setMa_sv(Main_Models.User_Models.getUser_name());

            sql = "select hoten from giaovien where magv=?";
            ps = n.conn.prepareStatement(sql);
            ps.setString(1, Main_Models.Phieu_Dang_Ky_Models.getMa_gv());
            rs = ps.executeQuery();
            rs.next();
            txt_name_gv.setText(rs.getString("hoten"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void btn_dang_ky() {
        try {
            String sql = "select count(*) from phieudangki";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String mp = "";
            if (rs.getInt(1) + 1 < 10) {
                mp = "p0" + (rs.getInt(1) + 1);
            } else {
                mp = "p" + (rs.getInt(1) + 1);
            }
            Main_Models.Phieu_Dang_Ky_Models.setMa_phieu(mp);
            sql = "insert into phieudangki(maphieu,masv,magv,madetai) values(?,?,?,?)";
            ps = n.conn.prepareStatement(sql);
            ps.setString(1, Main_Models.Phieu_Dang_Ky_Models.getMa_phieu());
            ps.setString(2, Main_Models.Phieu_Dang_Ky_Models.getMa_sv());
            ps.setString(3, Main_Models.Phieu_Dang_Ky_Models.getMa_gv());
            ps.setString(4, Main_Models.Phieu_Dang_Ky_Models.getMa_de_tai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
