
package dao;

import dto.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class NhaCCDAO {

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

    public boolean addNew(NhaCungCap nhaCungCap) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, nhaCungCap.getMancc());
                stm.setString(2, nhaCungCap.getTenncc());
                stm.setBoolean(3, nhaCungCap.isTrangThai());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return result;
    }

    public List<NhaCungCap> listNhaCC() throws ClassNotFoundException, SQLException {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [mancc],[tenncc],[diachi],[trangthai] "
                        + "FROM [dbo].[tblNhaCungCap]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new NhaCungCap(
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

    public NhaCungCap getById(String mancc) throws NullPointerException, SQLException, ClassNotFoundException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + mancc + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    return new NhaCungCap(
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
