
package Controller;

import dao.SanPhamDAO;
import dto.SanPham;
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


@WebServlet(name = "EditCartController", urlPatterns = {"/EditCartController"})
public class EditCartController extends HttpServlet {

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
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        String mess = "";
        SanPhamDAO sanPham = new SanPhamDAO();
        Utils utils = new Utils();
        String url = "Cart.jsp";
        try {
            if (action.equals("Update")) {
                String maSP = request.getParameter("txtMaSP");
                int newQuantity = Integer.parseInt(request.getParameter("txtSoLuong"));
                List<SanPham> list = (List<SanPham>) session.getAttribute("CART");
                int oldQuantity = sanPham.checkQuantity(maSP);
                if (newQuantity > oldQuantity) {
                    mess = "The quantity not enough";
                } else {

                    if (utils.updateProduct(list, maSP, newQuantity)) {
                        mess = "Update success";
                    } else {
                        mess = "Update fail";
                    }
                }
                float total = utils.totalPriceProduct(list);
                session.setAttribute("TOTAL", total);
                request.setAttribute("UPDATE_MSG", mess);

            } else if (action.equals("Delete")) {
                url = "DeleteItemController";
            }
        } catch (SQLException ex) {
            log("Error At UpdateCartController SQL:" + ex.toString());
        } catch (ClassNotFoundException ex) {
            log("Error At UpdateCartController NOT FOUND:" + ex.toString());
        } catch (NumberFormatException e) {
            log("Error At UpdateCartController:" + e.toString());
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
