package controllers;

import config.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import models.ProductDAO;
import models.User;
import models.UserDAO;

@WebServlet(name = "SaleController", urlPatterns = {"/sale"})
public class SaleController extends HttpServlet {

    Connection conn = null;
    int userId;

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

        String view = request.getParameter("view");
        String action = request.getParameter("action");

        switch (view) {
            case "sales":
                request.setAttribute("title", "Sistema ventas | ventas");
                request.setAttribute("active_sale", "active");
                this.action(action, request, response);
                break;
            default:
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
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

    /**
     * Acciones a realizar desde la pagina empleados
     *
     * @param action
     */
    private void action(String action, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (action) {
            case "search_client":
                int clientDocument = Integer.parseInt(request.getParameter("client_document"));
                UserDAO userClient = new UserDAO(null);
                User searchClient = null;
                searchClient = userClient.searchClientByDocument(clientDocument);
                request.setAttribute("client", searchClient);
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
            case "search_product":
                int productId = Integer.parseInt(request.getParameter("product_code"));
                Product product = new Product(productId);
                ProductDAO getProductId = new ProductDAO(null);
                getProductId.getProductById(product);
                request.setAttribute("product", product);
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
        }

    }

}
