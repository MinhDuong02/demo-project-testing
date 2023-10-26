package dao;

import dto.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class SanPhamDAO {

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

    public List<SanPham> getProductByName(String keyword) throws SQLException, ClassNotFoundException {
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]"
                        + "WHERE [tensp] LIKE '%" + keyword + "%'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new SanPham(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getBoolean(7),
                            rs.getString(8),
                            rs.getString(9)));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public void delete(String masp) throws ClassNotFoundException, SQLException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "Delete "
                        + "From [dbSE161605].[dbo].[tblSanPham] "
                        + "Where masp = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, masp);
                stm.executeUpdate();
            }
        } finally {
            closeDB();
        }
    }

    public boolean updateProduct(SanPham sanPham) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "UPDATE [dbo].[Products]"
                        + "SET [productName] = ?, [price] = ?, [quantity] = ?, [createDate] = ?, [expirationDate] = ?, "
                        + "[image] = ?, [status] = ?, [shortDescription] = ?, [categoryID] = ? "
                        + "WHERE  [masp] =  ?";
                stm = con.prepareStatement(sql);

                stm.setString(1, sanPham.getMasp());
                stm.setString(2, sanPham.getTensp());
                stm.setString(3, sanPham.getMoTa());
                stm.setInt(4, sanPham.getSoLuong());
                stm.setFloat(5, sanPham.getDonGia());
                stm.setString(6, sanPham.getHinhAnh());
                stm.setBoolean(7, sanPham.isTrangThai());
                stm.setString(8, sanPham.getMadm());
                stm.setString(9, sanPham.getMancc());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public List<SanPham> listProduct() throws SQLException, ClassNotFoundException {
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new SanPham(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getBoolean(7),
                            rs.getString(8),
                            rs.getString(9)));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public List<SanPham> listProductbyNCC(String maNCC) throws SQLException, ClassNotFoundException {
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]"
                        + " WHERE [mancc] ='" + maNCC + "'";;
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new SanPham(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getBoolean(7),
                            rs.getString(8),
                            rs.getString(9)));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public List<SanPham> listProductbyDanhMuc(String maDM) throws SQLException, ClassNotFoundException {
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]"
                        + " WHERE [madm] ='" + maDM + "'";;
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new SanPham(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getBoolean(7),
                            rs.getString(8),
                            rs.getString(9)));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public SanPham getProductbyMaSp(String masp) throws SQLException, ClassNotFoundException {
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]"
                        + " WHERE [masp] LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + masp + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    return new SanPham(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getBoolean(7),
                            rs.getString(8),
                            rs.getString(9));
                }
            }
        } finally {
            closeDB();
        }
        return null;
    }

    public boolean addNew(SanPham sanPham) throws SQLException, ClassNotFoundException {
        boolean result = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = " INSERT INTO [dbo].[tblSanPham]([masp],[tensp],[mota],[soluong],[dongia],[hinhanh],[trangthai],[madm],[mancc])\n"
                        + " VALUES (?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, sanPham.getMasp());
                stm.setString(2, sanPham.getTensp());
                stm.setString(3, sanPham.getMoTa());
                stm.setInt(4, sanPham.getSoLuong());
                stm.setFloat(5, sanPham.getDonGia());
                stm.setString(6, sanPham.getHinhAnh());
                stm.setBoolean(7, sanPham.isTrangThai());
                stm.setString(8, sanPham.getMadm());
                stm.setString(9, sanPham.getMancc());
                result = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return result;
    }

    public int checkQuantity(String masp) throws SQLException, ClassNotFoundException {
        int result = 0;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "SELECT [soluong]"
                        + " FROM [dbSE161605].[dbo].[tblSanPham]"
                        + " WHERE [masp] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, masp);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("soLuong");
                }
            }
        } finally {
            closeDB();
        }
        return result;
    }

    public boolean updateQuantity(String masp, int newSoLuong) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.makeConnect();
            if (con != null) {
                String sql = "update [dbSE161605].[dbo].[tblSanPham] set [soluong] = ? where [masp] = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, newSoLuong);
                stm.setString(2, masp);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return check;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SanPhamDAO sao = new SanPhamDAO();
        List<SanPham> lis = sao.listProduct();
        System.out.println(lis.size());
    }

}
