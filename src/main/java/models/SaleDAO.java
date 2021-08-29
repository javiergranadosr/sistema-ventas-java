package models;

import config.DBConnection;
import java.sql.*;
import java.text.SimpleDateFormat;

public class SaleDAO {

    Connection connection;
    String QUERY_GET_INVOICE = "SELECT MAX(numero_factura) AS numero_factura FROM ventas;";
    String QUERY_GET_LAST_SALE = "SELECT MAX(id) AS id FROM ventas;";
    String QUERY_SAVE_SALE = "INSERT INTO ventas (id_cliente, id_empleado, numero_factura, fecha_venta, total, estado) VALUES (?,?,?,?,?,?)";

    public SaleDAO(Connection conn) {
        this.connection = conn;
    }

    /**
     * Obtenemos el ultimo numero de factura generado,
     *
     * @return
     */
    public String getInvoiceNumber() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String invoiceNumber = null;
        try {
            // Obtenemos conexion a la base de datos
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar
            stmt = conn.prepareStatement(QUERY_GET_INVOICE);
            // Ejecutamos la consulta
            rs = stmt.executeQuery();

            while (rs.next()) {
                invoiceNumber = rs.getString("numero_factura");
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
        return invoiceNumber;
    }


     /**
     * Obtenemos el ultimo numero de factura generado,
     *
     * @return
     */
    public int getLastSale() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            // Obtenemos conexion a la base de datos
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparamos la consulta a realizar
            stmt = conn.prepareStatement(QUERY_GET_LAST_SALE);
            // Ejecutamos la consulta
            rs = stmt.executeQuery();

            while (rs.next()) {
              id= rs.getInt("id");
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
        return id;
    }

    
    /**
     * Guardar venta
     *
     * @param sale
     * @return
     * @throws SQLException
     */
    public int saveSale(Sale sale) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String dateSale = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_SAVE_SALE);
            // Setiamos valores 
            stmt.setInt(1, sale.getClientId());
            stmt.setInt(2, sale.getEmployeId());
            stmt.setString(3, sale.getInvoiceNumber());

            // Obtenemos fecha de la venta
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateSale = dateFormat.format(sale.getDateSale());

            stmt.setString(4, dateSale);
            stmt.setDouble(5, sale.getTotal());
            stmt.setString(6, sale.getState());

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
}
