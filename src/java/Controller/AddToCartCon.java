/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dto.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Utils;

/**
 *
 * @author MinhD
 */
@WebServlet(name = "AddToCartCon", urlPatterns = {"/AddToCartCon"})
public class AddToCartCon extends HttpServlet {

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
        HttpSession session = request.getSession();
        Utils utils = new Utils();

        String masp = request.getParameter("maSP");
        String tenSP = request.getParameter("tenSP");
        String hinhAnh = request.getParameter("HinhAnh");
        float donGia = Float.parseFloat(request.getParameter("donGia"));
        int soLuong = 1;
        List<SanPham> list;
        String mess;
        try {
            if (session.getAttribute("CART") == null) {
                list = new ArrayList<>();
            } else {
                list = (List<SanPham>) session.getAttribute("CART");
            }

            if (utils.checkExistInList(list, masp)) {
                int oldQuantity = utils.getQuantity(list, masp);
                soLuong += oldQuantity;
                utils.updateQuantity(list, masp, soLuong);
                mess = "Add success";
            } else {
                list.add(new SanPham(masp, tenSP, hinhAnh, soLuong, donGia));
                mess = "Add success";
            }
            float total = utils.totalPrice(list);
            session.setAttribute("TOTAL", total);
            session.setAttribute("CART", list);
            session.setAttribute("MESS", mess);
        } catch (Exception e) {
            log("AddToCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("LoadProductController").forward(request, response);
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
