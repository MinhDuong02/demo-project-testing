
package Controller;

import dao.ChiTIetHDDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import dto.ChiTietHoaDon;
import dto.HoaDon;
import dto.SanPham;
import dto.TaiKhoan;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Utils;


@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "LoadProductController";
        Utils utils = new Utils();
        HttpSession session = request.getSession();
        SanPhamDAO sanPham = new SanPhamDAO();
        HoaDonDAO hoaDon = new HoaDonDAO();
        ChiTIetHDDAO chiTiet = new ChiTIetHDDAO();

        try {
            List<SanPham> list = (List<SanPham>) session.getAttribute("CART");
            TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("TAI_KHOAN");
            String maHoaDon = utils.getAutoNumber(5);
            HoaDon newHoaDon = new HoaDon(
                    maHoaDon,
                    "",
                    true,
                    taikhoan.getTentk());
            if (hoaDon.saveHoaDon(newHoaDon)) {
                for (int i = 0; i < list.size(); i++) {
                    ChiTietHoaDon newChiTiet = new ChiTietHoaDon(
                            maHoaDon,
                            list.get(i).getMasp(),
                            list.get(i).getSoLuong(),
                            list.get(i).getDonGia(),
                            0,
                            list.get(i).getSoLuong() * list.get(i).getDonGia()
                    );
                    if (chiTiet.saveChiTietHoaDon(newChiTiet)) {
                        int soLuong = list.get(i).getSoLuong();
                        int oldSoLuong = sanPham.checkQuantity(list.get(i).getMasp());
                        int newSoLuong = oldSoLuong - soLuong;
                        sanPham.updateQuantity(list.get(i).getMasp(), newSoLuong);
                    }
                }

                url = "LoadProductController";
                session.setAttribute("CART", null);
            } else {
                url = "Cart.jsp";
            }
        } catch (SQLException ex) {
            log("CheckOutController SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("CheckOutController ClassNotFound: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
