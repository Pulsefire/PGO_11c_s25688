package lab;

import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {
    private final short ID;
    private final short deliveryTime;
    private final String name;
    public ArrayList<Long> productsQuantity;

    public Storage(short ID, short deliveryTime, String name) {
        this.ID = ID;
        this.deliveryTime = deliveryTime;
        this.name = name;
        productsQuantity = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Storage [id]: " + ID + '\n'
                +"name: " + name + '\n'
                 + "deliveryTime: " + deliveryTime + " days";
    }

    public void addProductToStorage(long quantity){
        productsQuantity.add(quantity);
    }

    public void raiseQuantityInStorage(long productID, long quantity){
        if(productID > productsQuantity.size())
            productsQuantity.set((int) productID, quantity);
    }

    public short getID() {
        return ID;
    }

    public short getDeliveryTime() {
        return deliveryTime;
    }

    public String getName() {
        return name;
    }

    public boolean isProductInStock(long productID){
        if(productID > productsQuantity.size()) return false;
        return productsQuantity.get((int) productID) > 0;
    }

    public long getProductQuantity(long productID) {
        if(productID > productsQuantity.size()) return 0;
        return productsQuantity.get((int) productID);
    }
}
