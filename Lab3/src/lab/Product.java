package lab;

import java.io.Serializable;

public class Product implements Serializable {
    private long ID;
    private String name;
    private ProductType productType;
    private double price;
    private long quantity;
    private boolean isAvailable;

    public Product(long ID, String name, ProductType productType, double price) {
        this.ID = ID;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = 0;
        this.isAvailable = false;
    }

    public void Sell(long inCart){
        quantity -= inCart;
    }

    public long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "\nProduct - " + ID + '\n' +
                "name: " + name + '\n' +
                "product type: " + productType + '\n' +
                "price: " + price + " USD\n" +
                "quantity: " + quantity + '\n' +
                "is available: " + isAvailable + '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void riseQuantity(long quantity) {
        this.quantity = this.quantity + quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
