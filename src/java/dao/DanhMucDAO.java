
package dao;

import dto.DanhMuc;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class DanhMucDAO implements Serializable {

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

    public boolean addNew(DanhMuc danhMuc) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, danhMuc.getMadm());
                stm.setString(2, danhMuc.getTendm());
                stm.setBoolean(3, danhMuc.isTrangThai());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return result;
    }

    public List<DanhMuc> listDanhMucs() throws ClassNotFoundException, SQLException {
        List<DanhMuc> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [madm],[tendm],[trangthai] "
                        + "FROM [dbSE161605].[dbo].[tblDanhMuc]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new DanhMuc(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3)
                    ));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public DanhMuc getById(String madm) throws NullPointerException, SQLException, ClassNotFoundException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + madm + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new DanhMuc(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBoolean(3)
                    );
                };
            }
        } finally {
            closeDB();
        }
        return null;
    }

}
