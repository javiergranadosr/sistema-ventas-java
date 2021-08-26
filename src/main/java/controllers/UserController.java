/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UserController", urlPatterns = {"/login", "/logout"})
public class UserController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // Obtener accion solicitada
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                this.login(request, response);
                break;
            case "logout":
                this.logout(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
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
     * Metodo de login del sistema
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Limpiamos sesiones del usuario en la aplicacion
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Crear objeto usuario
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        // Buscar usuario en BD
        UserDAO userDao = new UserDAO(null);
        userDao.login(user);
        // Si hay usuario buscado, mandamos al usuario a la pagina principal del sistema,
        // en caso contrario mandamos a la vista login
        if (user.getName() != null) {
            // Agregamos usuario al JSP, en el alcance de session, creamos nueva sesion
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("title", "Sistema ventas | inicio");
            request.setAttribute("active_home", "active");
            request.getRequestDispatcher("home?view=home").forward(request, response);
        } else {
            // Repuesta a travez de la peticion del cliente al iniciar sesion en el sistema
            request.setAttribute("message", "El correo electrónico o contraseña son incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /**
     * Cerrar sesion en el sistema
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession() != null) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

}
