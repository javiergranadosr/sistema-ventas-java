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
import models.User;
import models.UserDAO;

@WebServlet(name = "EmployeController", urlPatterns = {"/employe"})
public class EmployeController extends HttpServlet {

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
            case "employes":
                request.setAttribute("title", "Sistema ventas | empleados");
                request.setAttribute("active_employe", "active");
                this.action(action, request, response);
                break;   
            default:
                request.getRequestDispatcher("views/employes.jsp").forward(request, response);
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
            case "read":
                List<User> employes = new UserDAO(null).fetchAll("Empleado");
                // Creamos objetos session, para el listado de los datos
                HttpSession session = request.getSession();
                session.setAttribute("employes", employes);
                // Acciones a realizar en la vista
                request.getRequestDispatcher("views/employes.jsp").forward(request, response);
                break;
            case "add":
                // Abrimos conexion externa, para manejar la transaccion en db
                try {
                conn = DBConnection.getConnection();
                // Modificar autocomit a false para el manejo de la transaccion
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }

                int employeDocument = Integer.parseInt(request.getParameter("employe_document"));
                String employeName = request.getParameter("employe_name");
                String employeSurname = request.getParameter("employe_surname");
                String employeEmail = request.getParameter("employe_email");
                String employePassword = request.getParameter("employe_password");
                String employeState = request.getParameter("employe_state");

                UserDAO create = new UserDAO(conn);
                User userCreate = new User(employeDocument, employeName, employeSurname, employeEmail, employePassword, "Empleado", employeState);
                create.create(userCreate);
                conn.commit();
                request.getRequestDispatcher("employe?view=employes&action=read").forward(request, response);
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

                int employeDocument = Integer.parseInt(request.getParameter("employe_document"));
                String employeName = request.getParameter("employe_name");
                String employeSurname = request.getParameter("employe_surname");
                String employeEmail = request.getParameter("employe_email");
                String employePassword = request.getParameter("employe_password");
                String employeState = request.getParameter("employe_state");

                UserDAO update = new UserDAO(conn);
                User userUpdate = new User(userId, employeDocument, employeName, employeSurname, employeEmail, employePassword, "Empleado", employeState);
                update.update(userUpdate);
                conn.commit();
                request.getRequestDispatcher("employe?view=employes&action=read").forward(request, response);
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
                userId = Integer.parseInt(request.getParameter("id"));
                User user = new User(userId);
                UserDAO getUser = new UserDAO(null);
                getUser.getUserById(user);
                request.setAttribute("dataUser", user);
                request.getRequestDispatcher("employe?view=employes&action=read").forward(request, response);
                break;
            case "delete":
                // Abrimos conexion externa, para manejar la transaccion en db
                try {
                conn = DBConnection.getConnection();
                // Modificar autocomit a false para el manejo de la transaccion
                if (conn.getAutoCommit()) {
                    conn.setAutoCommit(false);
                }

                userId = Integer.parseInt(request.getParameter("id"));
                User userDelete = new User(userId);
                UserDAO delete = new UserDAO(conn);
                delete.delete(userDelete);
                conn.commit();
                request.getRequestDispatcher("employe?view=employes&action=read").forward(request, response);
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
