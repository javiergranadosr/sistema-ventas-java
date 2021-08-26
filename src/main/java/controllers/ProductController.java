package controllers;

import config.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Product;
import models.ProductDAO;

@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    Connection conn = null;
    int productId;

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
            case "products":
                request.setAttribute("title", "Sistema ventas | Productos");
                request.setAttribute("active_product", "active");
                this.action(action, request, response);
                break;
            default:
                request.getRequestDispatcher("views/products.jsp").forward(request, response);
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
     * Acciones a realizar desde la pagina productos
     *
     * @param action
     */
    private void action(String action, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (action) {
            case "read":
                List<Product> products = new ProductDAO(null).fetchAll();
                // Creamos objetos session, para el listado de los datos
                HttpSession session = request.getSession();
                session.setAttribute("products", products);
                // Acciones a realizar en la vista
                request.getRequestDispatcher("views/products.jsp").forward(request, response);
                break;
            case "add":
                // Abrimos conexion externa, para manejar la transaccion en db
                try {
                conn = DBConnection.getConnection();
                // Modificar autocomit a false para el manejo de la transaccion
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }

                String productName = request.getParameter("product_name");
                String productDescription = request.getParameter("product_description");
                String productUnit = request.getParameter("product_unit");
                int productPrice = Integer.parseInt(request.getParameter("product_price"));

                ProductDAO create = new ProductDAO(conn);
                Product productCreate = new Product(productName, productDescription, productUnit, productPrice);
                create.create(productCreate);
                conn.commit();
                request.getRequestDispatcher("product?view=products&action=read").forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            }
            break;
            case "update":
                // Abrimos conexion externa, para manejar la transaccion en db
                try {
                conn = DBConnection.getConnection();
                // Modificar autocomit a false para el manejo de la transaccion
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }

                String productName = request.getParameter("product_name");
                String productDescription = request.getParameter("product_description");
                String productUnit = request.getParameter("product_unit");
                int productPrice = Integer.parseInt(request.getParameter("product_price"));

                ProductDAO update = new ProductDAO(conn);
                Product productUpdate = new Product(productId, productName, productDescription, productUnit, productPrice);
                    System.out.println(productUpdate);
                update.update(productUpdate);
                conn.commit();
                request.getRequestDispatcher("product?view=products&action=read").forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            }
            break;
            case "load":
                productId = Integer.parseInt(request.getParameter("id"));
                Product product = new Product(productId);
                ProductDAO getProductId = new ProductDAO(null);
                getProductId.getProductById(product);
                request.setAttribute("product", product);
                request.getRequestDispatcher("product?view=products&action=read").forward(request, response);
                break;
            case "delete":
                // Abrimos conexion externa, para manejar la transaccion en db
                try {
                conn = DBConnection.getConnection();
                // Modificar autocomit a false para el manejo de la transaccion
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }

                productId = Integer.parseInt(request.getParameter("id"));
                Product productDelete = new Product(productId);
                ProductDAO delete = new ProductDAO(null);
                delete.delete(productDelete);
                conn.commit();
                request.getRequestDispatcher("product?view=products&action=read").forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            }
            break;
        }

    }

}
