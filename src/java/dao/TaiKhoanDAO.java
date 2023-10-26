
package dao;

import dto.TaiKhoan;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class TaiKhoanDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeDB() throws NullPointerException, SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<TaiKhoan> listTaiKhoans() throws ClassNotFoundException, SQLException {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new TaiKhoan(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3),
                            rs.getString(4),
                            rs.getString(5)
                    ));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public TaiKhoan login(String tenTk, String matKhau) throws NullPointerException, SQLException, ClassNotFoundException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [tentk],[matkhau],[trangthai],[email],[nhomtk]\n"
                        + "  FROM [dbo].[tblTaiKhoan]"
                        + "  WHERE tentk = ? AND matkhau = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, tenTk);
                stm.setString(2, matKhau);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new TaiKhoan(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3),
                            rs.getString(4),
                            rs.getString(5)
                    );
                }
            }
        } finally {
            closeDB();
        }
        return null;
    }

    public boolean register(TaiKhoan taiKhoan) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, taiKhoan.getTentk());
                stm.setString(2, taiKhoan.getMatKhau());
                stm.setBoolean(3, taiKhoan.isTrangThai());
                stm.setString(4, taiKhoan.getEmail());
                stm.setString(5, taiKhoan.getNhomtk());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return result;
    }

    public static void main(String[] args) throws NullPointerException, SQLException, ClassNotFoundException {
        TaiKhoanDAO dao = new TaiKhoanDAO();
        TaiKhoan taiKhoan = dao.login("Admin123", "Admin123");
        System.out.println(taiKhoan.getTentk());
    }
}
