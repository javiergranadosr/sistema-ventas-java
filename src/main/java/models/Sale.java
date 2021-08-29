package models;

import java.util.Date;

public class Sale {
    private int id;
    private int clientId;
    private int employeId;
    private String invoiceNumber;
    private Date dateSale;
    private double total;
    private String state;

    public Sale() {
    }

    public Sale(int id) {
        this.id = id;
    }

    public Sale(int clientId, int employeId, String invoiceNumber, Date dateSale, double total, String state) {
        this.clientId = clientId;
        this.employeId = employeId;
        this.invoiceNumber = invoiceNumber;
        this.dateSale = dateSale;
        this.total = total;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", clientId=" + clientId + ", employeId=" + employeId + ", invoiceNumber=" + invoiceNumber + ", dateSale=" + dateSale + ", total=" + total + ", state=" + state + '}';
    }

   
    
   
    
    
}
