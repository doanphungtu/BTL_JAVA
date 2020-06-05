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
public class De_Tai {

    public De_Tai() {
    }

    private String ma_de_tai;
    private String ten_de_tai;
    private String ma_gv;
    private int check;
    private String ma_nhom;

    public void setMa_de_tai(String ma_de_tai) {
        this.ma_de_tai = ma_de_tai;
    }

    public void setTen_de_tai(String ten_de_tai) {
        this.ten_de_tai = ten_de_tai;
    }

    public void setMa_gv(String ma_gv) {
        this.ma_gv = ma_gv;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public void setMa_nhom(String ma_nhom) {
        this.ma_nhom = ma_nhom;
    }

    public String getMa_de_tai() {
        return ma_de_tai;
    }

    public String getTen_de_tai() {
        return ten_de_tai;
    }

    public String getMa_gv() {
        return ma_gv;
    }

    public int getCheck() {
        return check;
    }

    public String getMa_nhom() {
        return ma_nhom;
    }

    @Override
    public String toString() {
        return this.ten_de_tai;
    }
}
