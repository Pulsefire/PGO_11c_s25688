package lab;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
    private final long ID;
    private double totalPrice;
    private int totalDeliveryTime;
    private final long personID;
    private final ArrayList<Product> products;
    private final ArrayList<Long> productsQuantity;

    public ShoppingCart(long ID, long personID) {
        this.ID = ID;
        this.personID = personID;
        totalDeliveryTime = 0;
        totalPrice = 0;
        products = new ArrayList<>();
        productsQuantity = new ArrayList<>();
    }

    void Sell(){
        for(int i = 0; i < products.size(); i++){
            products.get(i).Sell(productsQuantity.get(i));
        }
    }

    void addProduct(Product product, long quantity, int totalDeliveryTime){
        products.add(product);
        productsQuantity.add(quantity);

        // Calculate summary value of cart
        totalPrice += product.getPrice() * quantity;
        this.totalDeliveryTime = (Math.max(this.totalDeliveryTime, totalDeliveryTime));
    }

    void editQuantity(long productID, long quantity, int totalDeliveryTime){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getID() == productID){
                this.totalPrice += products.get(i).getPrice() * (quantity - productsQuantity.get(i));
                productsQuantity.set(i, quantity);
                this.totalDeliveryTime = (Math.max(this.totalDeliveryTime, totalDeliveryTime));
                return;
            }
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public long getID() {
        return ID;
    }

    public long getPersonID() {
        return personID;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Long> getProductsQuantity() {
        return productsQuantity;
    }
}
