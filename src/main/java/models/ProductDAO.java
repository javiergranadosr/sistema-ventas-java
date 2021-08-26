package models;

import config.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    Connection connection;
    String QUERY_SELECT = "SELECT * FROM productos;";
    String QUERY_PRODUCT_BY_ID = "SELECT * FROM productos WHERE id = ?";
    String QUERY_CREATE = "INSERT INTO productos (nombre, descripcion, unidad, precio) VALUES (?,?,?,?)";
    String QUERY_UPDATE = "UPDATE productos SET nombre = ?, descripcion = ?, unidad = ?, precio = ?  WHERE id = ?";
    String QUERY_DELETE = "DELETE FROM productos WHERE id = ?";

    public ProductDAO(Connection conn) {
        this.connection = conn;
    }

    /**
     * Obtener listado de productos
     *
     * @return
     */
    public List<Product> fetchAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        List<Product> products = new ArrayList<>();

        try {
            // Obtenemos conexion a la base de datos
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar
            stmt = conn.prepareStatement(QUERY_SELECT);
            // Ejecutamos la consulta
            rs = stmt.executeQuery();

            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("nombre"));
                product.setDescription(rs.getString("descripcion"));
                product.setUnit(rs.getString("unidad"));
                product.setPrice(rs.getInt("precio"));
                products.add(product);
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
        return products;
    }

    /**
     * Crear un nuevo producto
     *
     * @param user
     * @return
     */
    public int create(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_CREATE);
            // Setiamos valores 
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getUnit());
            stmt.setInt(4, product.getPrice());
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
     * Buscar producto por id
     *
     * @param user
     * @return
     */
    public Product getProductById(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Inicializar conexion a la BD
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar en la BD
            stmt = conn.prepareStatement(QUERY_PRODUCT_BY_ID);
            // Ingresar parametros a la consulta preparada a realizar
            stmt.setInt(1, product.getId());
            // Ejecutamos la consulta
            rs = stmt.executeQuery();
            // Nos posicionamos al registro que hemos consultado, por default ubica la primero buscado
            rs.next();
            do {
                // Setiar valores
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("nombre"));
                product.setDescription(rs.getString("descripcion"));
                product.setUnit(rs.getString("unidad"));
                product.setPrice(rs.getInt("precio"));
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
        return product;
    }

    /**
     * Editar producto
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public int update(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_UPDATE);
            // Setiamos valores 
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getUnit());
            stmt.setInt(4, product.getPrice());
            stmt.setInt(5, product.getId());
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
     * Eliminar producto
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public int delete(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Inicializar conexion a la BD
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar en la BD
            stmt = conn.prepareStatement(QUERY_DELETE);
            // Setiar valores
            stmt.setInt(1, product.getId());
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
