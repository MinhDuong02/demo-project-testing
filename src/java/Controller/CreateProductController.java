
package Controller;

import dao.SanPhamDAO;
import dto.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String masp = request.getParameter("txtMaSP");
        String tensp = request.getParameter("txtTenSP");
        String moTa = request.getParameter("txtMoTa");
        int soLuong = Integer.parseInt(request.getParameter("txtSoLuong"));
        float donGia = Float.parseFloat(request.getParameter("txtDonGia"));
        String hinhAnh = request.getParameter("txtHinhAnh");
        String madm = request.getParameter("txtMadm");
        String maNCC = request.getParameter("txtMaNCC");
        boolean trangThai = true;
        SanPhamDAO sanPham = new SanPhamDAO();
        String url = "ManageController";

        try {
            SanPham newSanPham = new SanPham(masp, tensp, moTa, soLuong, donGia, hinhAnh, trangThai, madm, maNCC);
            if (sanPham.addNew(newSanPham)) {
                url = "LoadProductController";
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateProductController_SQL: " + ex.getMessage());
            if (msg.contains("duplicate")) {
                String error = masp + " is existed.";
                request.setAttribute("CREATE_ERRS", error);
            }
        } catch (ClassNotFoundException ex) {
            log("CreateProductController_ClassNotFound: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
