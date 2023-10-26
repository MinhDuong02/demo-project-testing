
package dto;

import java.io.Serializable;
import java.util.Date;


public class HoaDon implements Serializable {

    private String mahd;
    private String ngayhd;
    private boolean trangThai;
    private String makh;

    public HoaDon() {
    }

    public HoaDon(String mahd, String ngayhd, boolean trangThai, String makh) {
        this.mahd = mahd;
        this.ngayhd = ngayhd;
        this.trangThai = trangThai;
        this.makh = makh;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgayhd() {
        return ngayhd;
    }

    public void setNgayhdDate(String ngayhd) {
        this.ngayhd = ngayhd;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

}
