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
public class Nhom {
    String ma_nhom;
    String ten_nhom;

    @Override
    public String toString() {
        return this.ten_nhom;
    }

    public void setMa_nhom(String ma_nhom) {
        this.ma_nhom = ma_nhom;
    }

    public void setTen_nhom(String ten_nhom) {
        this.ten_nhom = ten_nhom;
    }

    public String getMa_nhom() {
        return ma_nhom;
    }

    public String getTen_nhom() {
        return ten_nhom;
    }
}
