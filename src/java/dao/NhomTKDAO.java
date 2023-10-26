
package dao;

import dto.NhomTaiKhoan;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class NhomTKDAO implements Serializable {

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

    public List<NhomTaiKhoan> listNhomTaiKhoans() throws ClassNotFoundException, SQLException {
        List<NhomTaiKhoan> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new NhomTaiKhoan(
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
}
