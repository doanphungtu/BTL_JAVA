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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class SV_Nop_Bai_Controllers {

    connection n = new connection();

    public void get_thong_tin(JTable tb_nop_bai, JTextField txt_ten_de_tai) {
        try {
            String sql = "select * from tiendo where madetai=?";
            PreparedStatement ps = n.conn.prepareStatement(sql);
            ps.setString(1, Main_Models.Phieu_Dang_Ky_Models.getMa_de_tai());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Main_Models.Tien_Do_Models.setMatiendo(rs.getString("matiendo"));
                Main_Models.Tien_Do_Models.setTuan(rs.getString("tuan"));
                Main_Models.Tien_Do_Models.setNoidung(rs.getString("noidung"));
                Main_Models.Tien_Do_Models.setMadetai(rs.getString("madetai"));
                Main_Models.Tien_Do_Models.setTinhtrang(rs.getInt("tinhtrang"));
                Main_Models.Tien_Do_Models.setDiem(rs.getDouble("diem"));
                Main_Models.Tien_Do_Models.setHannop(rs.getDate("hannop").toString());
                String diem = "";
                String tinhtrang = "";
                if (Main_Models.Tien_Do_Models.getDiem() == -1) {
                    diem = "Chua co";
                } else {
                    diem = String.valueOf(Main_Models.Tien_Do_Models.getDiem());
                }
                
                if (Main_Models.Tien_Do_Models.getTinhtrang() == 0) {
                    tinhtrang = "Chua nop";
                } else if(Main_Models.Tien_Do_Models.getTinhtrang() == 1) {
                    tinhtrang = "Da nop";
                }else{
                    tinhtrang = "Nop muon";
                }
                
                String[] a = {
                    Main_Models.Tien_Do_Models.getTuan(), 
                    Main_Models.Tien_Do_Models.getNoidung(), 
                    String.valueOf(Main_Models.Tien_Do_Models.getHannop()), 
                    tinhtrang, 
                    diem
                };
                
                DefaultTableModel model = (DefaultTableModel) tb_nop_bai.getModel();
                model.addRow(a);
            }
            sql = "select * from detai where madetai=?";
            ps = n.conn.prepareStatement(sql);
            ps.setString(1, Main_Models.Phieu_Dang_Ky_Models.getMa_de_tai());
            rs = ps.executeQuery();
            rs.next();
            txt_ten_de_tai.setText(rs.getString("tendetai"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
