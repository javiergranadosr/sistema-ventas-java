
package models;


public class SaleDetail {
    private int id;
    private int saleId;
    private int productId;
    private int amount;
    private double salePrice;

    public SaleDetail() {
    }

    public SaleDetail(int saleId, int productId, int amount, double salePrice) {
        this.saleId = saleId;
        this.productId = productId;
        this.amount = amount;
        this.salePrice = salePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "SaleDetail{" + "id=" + id + ", saleId=" + saleId + ", productId=" + productId + ", amount=" + amount + ", salePrice=" + salePrice + '}';
    }
    
    
    
}
