
package Controller;

import dao.DanhMucDAO;
import dao.NhaCCDAO;
import dao.SanPhamDAO;
import dto.DanhMuc;
import dto.NhaCungCap;
import dto.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ManageController", urlPatterns = {"/ManageController"})
public class ManageController extends HttpServlet {

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
        SanPhamDAO spDAO = new SanPhamDAO();
        NhaCCDAO nccDAO = new NhaCCDAO();
        DanhMucDAO dmDAO = new DanhMucDAO();

        List<SanPham> listSanPhams;
        List<NhaCungCap> listNhaCungCaps;
        List<DanhMuc> listDanhMucs;
        try {
            listSanPhams = spDAO.listProduct();
            request.setAttribute("LIST_SANPHAM", listSanPhams);

            listNhaCungCaps = nccDAO.listNhaCC();
            request.setAttribute("LIST_NHACUNGCAP", listNhaCungCaps);

            listDanhMucs = dmDAO.listDanhMucs();
            request.setAttribute("LIST_DANHMUC", listDanhMucs);
        } catch (SQLException ex) {
            log("ManageController_SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("ManageController_ClassNotFound: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
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
