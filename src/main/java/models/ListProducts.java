/*
 *Listado de productos seleccionados para el cliente
 */
package models;


public class ListProducts {
    private int productCode;
    private String productName;
    private int productPrice;
    private int productAmount;
    private double total;

    public ListProducts() {
    }


    public ListProducts(int productCode, String productName, int productPrice, int productAmount, double total) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.total = total;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ListProducts{" + "productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice + ", productAmount=" + productAmount + ", total=" + total + '}';
    }
    
  
}
