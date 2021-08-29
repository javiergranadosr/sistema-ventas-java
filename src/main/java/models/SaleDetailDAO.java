package models;

import config.DBConnection;
import java.sql.*;

public class SaleDetailDAO {

    Connection connection;
    String QUERY_SAVE_SALE_DETAIL = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_venta) VALUES (?,?,?,?)";

    public SaleDetailDAO(Connection conn) {
        this.connection = conn;
    }

    /**
     * Guardar detalle venta
     * @param sale
     * @return
     * @throws SQLException 
     */
    public int saveDetailSave(SaleDetail saleDetail) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;
        try {
            // Obtener conexion
            conn = this.connection != null ? this.connection : DBConnection.getConnection();
            // Preparar consulta 
            stmt = conn.prepareStatement(QUERY_SAVE_SALE_DETAIL);
            // Setiamos valores 
            stmt.setInt(1, saleDetail.getSaleId());
            stmt.setInt(2, saleDetail.getProductId());
            stmt.setInt(3, saleDetail.getAmount());
            stmt.setDouble(4, saleDetail.getSalePrice());
          
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
