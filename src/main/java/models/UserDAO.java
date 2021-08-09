package models;

import config.DBConnection;
import java.sql.*;

public class UserDAO {

    Connection connection;
    String QUERY_LOGIN = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";

    public UserDAO(Connection conn) {
        this.connection = conn;
    }

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

}
