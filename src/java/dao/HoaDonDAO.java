
package dao;

import dto.HoaDon;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class HoaDonDAO implements Serializable {

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

    public boolean saveHoaDon(HoaDon hoaDon) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[tblHoaDon]([mahd],[ngaydh],[trangthaixuly],[makh])"
                        + " VALUES(?, getdate(), ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, hoaDon.getMahd());
                stm.setBoolean(2, hoaDon.isTrangThai());
                stm.setString(3, hoaDon.getMakh());

                result = stm.executeUpdate() > 0;

            }
        } finally {
            closeDB();
        }
        return result;
    }

    public List<HoaDon> listHoaDon() throws ClassNotFoundException, SQLException {
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT[mahd],[ngaydh],[trangthaixuly],[makh] "
                        + "FROM [dbSE161605].[dbo].[tblHoaDon]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new HoaDon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3),
                            rs.getString(4)
                    ));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public List<HoaDon> listHoaDonByMaKH(String makh) throws ClassNotFoundException, SQLException {
        List<HoaDon> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT[mahd],[ngaydh],[trangthaixuly],[makh] "
                        + "FROM [dbSE161605].[dbo].[tblHoaDon] "
                        + "WHERE [makh] like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, makh);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new HoaDon(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3),
                            rs.getString(4)
                    ));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }
}
