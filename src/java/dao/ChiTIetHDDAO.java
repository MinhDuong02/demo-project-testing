
package dao;

import dto.ChiTietHoaDon;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class ChiTIetHDDAO implements Serializable {

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

    public boolean saveChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[tblChiTietHoaDon]([mahd],[masp],[soluong],[dongia],[khuyenmai],[giatri])"
                        + " VALUES ( ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, chiTietHoaDon.getMahd());
                stm.setString(2, chiTietHoaDon.getMasp());
                stm.setInt(3, chiTietHoaDon.getSoLuong());
                stm.setFloat(4, chiTietHoaDon.getDonGia());
                stm.setFloat(5, chiTietHoaDon.getKhuyenMai());
                stm.setFloat(6, chiTietHoaDon.getGiaTri());

                result = stm.executeUpdate() > 0;

            }
        } finally {
            closeDB();
        }
        return result;
    }

    public List<ChiTietHoaDon> listChiTietHoaDon(String mahd) throws ClassNotFoundException, SQLException {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [mahd],[masp],[soluong],[dongia],[khuyenmai],[giatri]\n"
                        + "FROM [dbo].[tblChiTietHoaDon]\n"
                        + "WHERE [mahd] like '" + mahd + "'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new ChiTietHoaDon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getFloat(4),
                            rs.getFloat(5),
                            rs.getFloat(6)
                    ));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }
}
