
package dto;

import java.io.Serializable;


public class NhaCungCap implements Serializable{

    private String mancc;
    private String tenncc;
    private boolean trangThai;
 
    public NhaCungCap() {
 
    }

    public NhaCungCap(String mancc, String tenncc, boolean trangThai) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.trangThai = trangThai;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
