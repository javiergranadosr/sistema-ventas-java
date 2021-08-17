/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import models.UserDAO;

/**
 *
 * @author javiergranadosr
 */
@WebServlet(name = "MainController", urlPatterns = {"/page"})
public class MainController extends HttpServlet {

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
                request.getRequestDispatcher("views/products.jsp").forward(request, response);
                break;
            case "employes":
                request.setAttribute("title", "Sistema ventas | empleados");
                request.setAttribute("active_employe", "active");
                this.action(action,request, response);
                break;
            case "clients":
                request.getRequestDispatcher("views/clients.jsp").forward(request, response);
                break;
            case "sales":
                request.getRequestDispatcher("views/sales.jsp").forward(request, response);
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
     * Acciones a realizar desde la paginas empleados
     *
     * @param action
     */
    private void action(String action, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        switch (action) {
            case "read":
                List<User> employes = new UserDAO(null).fetchAll();
                System.out.println(employes.toString());
                // Creamos objetos session, para el listado de los datos
                HttpSession session = request.getSession();
                session.setAttribute("employes", employes);
                 // Acciones a realizar en la vista
                request.getRequestDispatcher("views/employes.jsp").forward(request, response);
                break;
            case "add":
                break;
            case "update":
                break;
            case "load":
                break;
            case "delete":
                break;
        }

    }

}
