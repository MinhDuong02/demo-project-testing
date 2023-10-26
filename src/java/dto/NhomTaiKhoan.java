
package dto;

import java.io.Serializable;


public class NhomTaiKhoan implements Serializable{
    private String nhomtk;
    private String moTa;
    private boolean trangThai;

    public NhomTaiKhoan() {
    }

    public NhomTaiKhoan(String nhomtk, String moTa, boolean trangThai) {
        this.nhomtk = nhomtk;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(String nhomtk) {
        this.nhomtk = nhomtk;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }  
}


