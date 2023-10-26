
package dto;

import java.io.Serializable;


public class SanPham implements Serializable {

    private String masp;
    private String tensp;
    private String moTa;
    private int soLuong;
    private float donGia;
    private String hinhAnh;
    private boolean trangThai;
    private String madm;
    private String mancc;

    public SanPham() {
    }

    public SanPham(String masp, String tensp, String moTa, int soLuong, float donGia, String hinhAnh, boolean trangThai, String madm, String mancc) {
        this.masp = masp;
        this.tensp = tensp;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
        this.madm = madm;
        this.mancc = mancc;
    }

    public SanPham(String masp, String tensp, String hinhAnh, int soLuong, float donGia) {
        this.masp = masp;
        this.tensp = tensp;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public SanPham(String masp, String tensp, int soLuong, float donGia) {
        this.masp = masp;
        this.tensp = tensp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

}
