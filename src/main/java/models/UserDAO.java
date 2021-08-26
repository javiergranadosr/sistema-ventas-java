package models;

import config.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    Connection connection;
    String QUERY_SELECT = "SELECT * FROM usuarios WHERE rol = ?";
    String QUERY_GET_BY_ID = "SELECT * FROM usuarios WHERE id = ?";
    String QUERY_LOGIN = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
    String QUERY_CREATE = "INSERT INTO usuarios (documento, nombre, apellidos, correo, password,rol,estado) VALUES (?,?,?,?,?,?,?)";
    String QUERY_UPDATE = "UPDATE usuarios SET documento = ?, nombre = ?, apellidos = ?, correo = ?, password = ?, rol = ?, estado = ? WHERE id = ?";
    String QUERY_DELETE = "DELETE FROM usuarios WHERE id = ?";

    public UserDAO(Connection conn) {
        this.connection = conn;
    }

    /**
     * Obtener listado de usuarios, empleados del sistema
     *
     * @return
     */
    public List<User> fetchAll(String role) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            // Obtenemos conexion a la base de datos
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar
            stmt = conn.prepareStatement(QUERY_SELECT);
            stmt.setString(1, role);

            // Ejecutamos la consulta
            rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setDocument(rs.getInt("documento"));
                user.setName(rs.getString("nombre"));
                user.setEmail(rs.getString("correo"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
                user.setStatus(rs.getString("estado"));

                users.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Cerramos objeto ResultSet
            DBConnection.close(rs);
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        return users;
    }

    /**
     * Login del sistema, obtenemos correo y password del usuario
     *
     * @param user
     * @return
     */
    public User login(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Inicializar conexion a la BD
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar en la BD
            stmt = conn.prepareStatement(QUERY_LOGIN);
            // Ingresar parametros a la consulta preparada a realizar
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            // Ejecutamos la consulta
            rs = stmt.executeQuery();
            // Nos posicionamos al registro que hemos consultado, por default ubica la primero buscado
            rs.next();
            do {
                // Setiar valores
                user.setId(rs.getInt("id"));
                user.setDocument(rs.getInt("documento"));
                user.setName(rs.getString("nombre"));
                user.setSurname(rs.getString("apellidos"));
                user.setEmail(rs.getString("correo"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
                user.setStatus(rs.getString("estado"));
            } while (rs.next());

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Cerramos objeto ResultSet
            DBConnection.close(rs);
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        return user;
    }

    /**
     * Crear un nuevo usuario
     *
     * @param user
     * @return
     */
    public int create(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_CREATE);
            // Setiamos valores 
            stmt.setInt(1, user.getDocument());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRol());
            stmt.setString(7, user.getStatus());
            // Ejecutamos consulta preparada
            registers = stmt.executeUpdate();
        } finally {
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        return registers;
    }

    /**
     * Buscar usuario por id
     *
     * @param user
     * @return
     */
    public User getUserById(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Inicializar conexion a la BD
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar en la BD
            stmt = conn.prepareStatement(QUERY_GET_BY_ID);
            // Ingresar parametros a la consulta preparada a realizar
            stmt.setInt(1, user.getId());
            // Ejecutamos la consulta
            rs = stmt.executeQuery();
            // Nos posicionamos al registro que hemos consultado, por default ubica la primero buscado
            rs.next();
            do {
                // Setiar valores
                user.setId(rs.getInt("id"));
                user.setDocument(rs.getInt("documento"));
                user.setName(rs.getString("nombre"));
                user.setSurname(rs.getString("apellidos"));
                user.setEmail(rs.getString("correo"));
                user.setPassword(rs.getString("password"));
                user.setRol(rs.getString("rol"));
                user.setStatus(rs.getString("estado"));
            } while (rs.next());

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            // Cerramos objeto ResultSet
            DBConnection.close(rs);
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        return user;
    }

    /**
     * Editar usuario
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public int update(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_UPDATE);
            // Setiamos valores 
            stmt.setInt(1, user.getDocument());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRol());
            stmt.setString(7, user.getStatus());
            stmt.setInt(8, user.getId());
            // Ejecutamos consulta preparada
            registers = stmt.executeUpdate();
        } finally {
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        return registers;
    }

    /**
     * Eliminar usuario
     * @param user
     * @return
     * @throws SQLException 
     */
    public int delete(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Inicializar conexion a la BD
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar en la BD
            stmt = conn.prepareStatement(QUERY_DELETE);
            // Setiar valores
            stmt.setInt(1, user.getId());
            // Ejecutamos consulta preparada
            registers = stmt.executeUpdate();
        } finally {
            // Cerramos objeto PreparedStatement
            DBConnection.close(stmt);
            // Cerramos objeto Connection
            if (this.connection == null) {
                DBConnection.close(conn);
            }
        }
        // Retornamos el numero de registros modificados, eliminados
        return registers;
    }

}
