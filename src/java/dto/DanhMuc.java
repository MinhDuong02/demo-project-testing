/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author phien
 */
public class DanhMuc implements Serializable{

    private String madm;
    private String tendm;
    private boolean trangThai;

    public DanhMuc() {
    }

    public DanhMuc(String madm, String tendm, boolean trangThai) {
        this.madm = madm;
        this.tendm = tendm;
        this.trangThai = trangThai;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
