
package models;

public class Product {
    private int id;
    private String name;
    private String description; 
    private String unit;
    private int price;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, String description, String unit, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.price = price;
    }

    public Product(String name, String description, String unit, int price) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", unit=" + unit + ", price=" + price + '}';
    }
    
    
}
