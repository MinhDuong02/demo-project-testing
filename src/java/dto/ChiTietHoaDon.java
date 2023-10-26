
package dto;

import java.io.Serializable;


public class ChiTietHoaDon implements Serializable {

    private String mahd;
    private String masp;
    private int soLuong;
    private float donGia;
    private float khuyenMai;
    private float giaTri;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String mahd, String masp, int soLuong, float donGia, float khuyenMai, float giaTri) {
        this.mahd = mahd;
        this.masp = masp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.khuyenMai = khuyenMai;
        this.giaTri = giaTri;
    }

    public ChiTietHoaDon(String mahd, String masp, int soLuong, float donGia) {
        this.mahd = mahd;
        this.masp = masp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }

}
