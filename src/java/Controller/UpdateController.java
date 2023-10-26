/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.SanPhamDAO;
import dto.SanPham;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MinhD
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String maNCC = request.getParameter("txtMaNCCs");
        boolean trangThai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        try {

            SanPham sanPham = new SanPham(masp, tensp, moTa, soLuong, donGia, hinhAnh, trangThai, madm, maNCC);
            boolean check = sanPhamDAO.updateProduct(sanPham);
        } catch (SQLException ex) {
            log("UpdateController SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("UpdateController_ClassNotFound: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("ManagerProduct");
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
