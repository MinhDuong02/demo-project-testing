
package Controller;

import dto.SanPham;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Utils;


@WebServlet(name = "DeleteItemController", urlPatterns = {"/DeleteItemController"})
public class DeleteItemController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String maSP = request.getParameter("txtMaSP");
        utils.Utils utils = new Utils();
        HttpSession session = request.getSession();
        String mess = "";
        try {
            List<SanPham> list = (List<SanPham>) session.getAttribute("CART");
            if (utils.deleteProduct(list, maSP)) {
                mess = "Delete Success";
            } else {
                mess = "Fail to Delete";
            }

            float total = utils.totalPrice(list);
            session.setAttribute("TOTAL", total);
            session.setAttribute("CART", list);
            session.setAttribute("MESS", mess);
        } catch (Exception e) {
            log("Error At DeleteCartController:" + e.toString());
        } finally {
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
