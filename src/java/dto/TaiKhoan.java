
package dto;


public class TaiKhoan {

    private String tentk;
    private String matKhau;
    private boolean trangThai;
    private String email;
    private String nhomtk;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentk, String matKhau, boolean trangThai, String email, String nhomtk) {
        this.tentk = tentk;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.email = email;
        this.nhomtk = nhomtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(String nhomtk) {
        this.nhomtk = nhomtk;
    }
    
    

}
