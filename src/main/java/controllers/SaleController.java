package controllers;

import config.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ListProducts;
import models.Product;
import models.ProductDAO;
import models.Sale;
import models.SaleDAO;
import models.SaleDetail;
import models.SaleDetailDAO;
import models.User;
import models.UserDAO;

@WebServlet(name = "SaleController", urlPatterns = {"/sale"})
public class SaleController extends HttpServlet {

    Connection conn = null;
    int userId;
    User searchClient;
    List<ListProducts> listProducts = new ArrayList<>();
    double totalCheck = 0;
    String invoiceNumber = null;
    int countInvoice = 0;

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
                request.setAttribute("client", searchClient);
                request.setAttribute("products", listProducts);
                request.setAttribute("totalCheck", totalCheck);
                request.setAttribute("invoiceNumber", invoiceNumber);
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
            case "add_product":
                double total = 0;
                totalCheck = 0;
                int productCode = Integer.parseInt(request.getParameter("product_code"));
                String productName = request.getParameter("product_name");
                int productPrice = Integer.parseInt(request.getParameter("product_price"));
                int productAmount = Integer.parseInt(request.getParameter("product_amount"));

                ListProducts products = new ListProducts();

                products.setProductCode(productCode);
                products.setProductName(productName);
                products.setProductPrice(productPrice);
                products.setProductAmount(productAmount);
                total = productPrice * productAmount;
                products.setTotal(total);

                listProducts.add(products);

                for (ListProducts p : listProducts) {
                    totalCheck += p.getTotal();
                }

                request.setAttribute("products", listProducts);
                request.setAttribute("client", searchClient);
                request.setAttribute("totalCheck", totalCheck);
                request.setAttribute("invoiceNumber", invoiceNumber);

                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;

            case "generate_sale": {
                try {
                    conn = DBConnection.getConnection();

                    // Modificar autocomit a false para el manejo de la transaccion
                    if (conn.getAutoCommit()) {
                        conn.setAutoCommit(false);
                    }

                    SaleDAO saleDao = new SaleDAO(conn);
                    SaleDetailDAO saleDetailDAO = new SaleDetailDAO(conn);
                    Date date = new Date();

                    Sale sale = new Sale();
                    sale.setClientId(searchClient.getId());
                    sale.setEmployeId(41);
                    sale.setInvoiceNumber(invoiceNumber);
                    sale.setDateSale(date);
                    sale.setTotal(totalCheck);
                    sale.setState("VENDIDO");
                    saleDao.saveSale(sale);

                    conn.commit();

                    int saleID = new SaleDAO(null).getLastSale();
                    for (ListProducts p : listProducts) {
                        SaleDetail saleDetail = new SaleDetail(saleID, p.getProductCode(), p.getProductAmount(), p.getProductPrice());
                        saleDetailDAO.saveDetailSave(saleDetail);
                    }
                    conn.commit();

                    request.getRequestDispatcher("views/sales.jsp").forward(request, response);

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

            default:
                invoiceNumber = new SaleDAO(null).getInvoiceNumber();
                countInvoice = 0;
                if (invoiceNumber == null) {
                    invoiceNumber = "1";
                } else {
                    countInvoice = Integer.parseInt(invoiceNumber);
                }

                request.setAttribute("invoiceNumber", invoiceNumber);
                request.setAttribute("products", listProducts);
                request.setAttribute("client", searchClient);
                request.setAttribute("totalCheck", totalCheck);
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
                break;
        }

    }

}
