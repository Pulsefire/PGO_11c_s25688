package lab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Shop implements Serializable {
    ArrayList<Product> products;
    ArrayList<Person> people;
    ArrayList<Storage> storages;
    ArrayList<ShoppingCart> shoppingCarts;


    Shop(){
        products = new ArrayList<>();
        people = new ArrayList<>();
        storages = new ArrayList<>();
        shoppingCarts = new ArrayList<>();
    }

    public String welcomeMessage(){
        return "Welcome to EasyShop";
    }

    // ProductCart stuff ------------------------------------------------------------------------------------

    public void SellPersonCart(){
        printPeopleData();
        long personID = Getter.getPositiveLong("Person id");
        long cardID = findPersonActiveCard(personID);
        ArrayList<Product> er = new ArrayList<>();
        for(int i = 0; i < shoppingCarts.get((int) cardID).getProducts().size(); i++){
            if(getActualStorageListForCart(shoppingCarts.get((int) cardID).getProducts().get(i), shoppingCarts.get((int) cardID).getProductsQuantity().get(i)).get(0)[0] == -1){
                er.add(shoppingCarts.get((int) cardID).getProducts().get(i));
            }
        }
        if(er.size() > 0){
            Logger.Warning("For now we don't have that many products in stock, list of error item: ");
            for (Product p : er){
                Logger.Warning(p.toString());
            }
            return;
        }
        int result;
        switch (isEnoughMoney(personID)) {
            case 0 -> {
                Logger.Warning("Is not enough money to bay this stuff");
            }
            case 1 -> {
                Logger.App("You can pay only in cash, you confirm this action?");
                result = Getter.getIntegerFromRange("1 - yes, 0 - no", 0, 1);
                if (result == 1) {
                    shoppingCarts.get((int) cardID).Sell();
                    shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), personID));
                    people.get((int) personID).BuyByMoney(shoppingCarts.get((int) cardID).getTotalPrice(), shoppingCarts.size() - 1);
                    reStockProductInCart(cardID);
                    Logger.App("Transaction successful");
                } else {
                    Logger.App("Transaction canceled");
                }
            }
            case 2 -> {
                Logger.App("You can pay only using card, you confirm this action?");
                result = Getter.getIntegerFromRange("1 - yes, 0 - no", 0, 1);
                if (result == 1) {
                    shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), personID));
                    people.get((int) personID).BuyByCard(shoppingCarts.get((int) cardID).getTotalPrice(), shoppingCarts.size() - 1);
                    reStockProductInCart(cardID);
                    Logger.App("Transaction successful");
                } else {
                    Logger.App("Transaction canceled");
                }
            }
            case 3 -> {
                Logger.App("You can pay both with card or money, you confirm this action?");
                result = Getter.getIntegerFromRange("2 - card, 1 - money, 0 - no", 0, 2);
                if (result == 1) {
                    shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), personID));
                    people.get((int) personID).BuyByMoney(shoppingCarts.get((int) cardID).getTotalPrice(), shoppingCarts.size() - 1);
                    reStockProductInCart(cardID);
                    Logger.App("Transaction successful");
                } else if (result == 2) {
                    shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), personID));
                    people.get((int) personID).BuyByCard(shoppingCarts.get((int) cardID).getTotalPrice(), shoppingCarts.size() - 1);
                    reStockProductInCart(cardID);
                    Logger.App("Transaction successful");
                } else {
                    Logger.App("Transaction canceled");

                }
            }
        }

    }

    private void reStockProduct(ArrayList<Long []> from, long productID){
        for(Long [] f : from){
            storages.get(f[0].intValue()).productsQuantity.set((int)productID, storages.get(f[0].intValue()).productsQuantity.get((int)productID) - f[1]);
        }
    }

    private void reStockProductInCart(long cardID){
        for(int i = 0; i < shoppingCarts.get((int) cardID).getProducts().size(); i++){
            reStockProduct(getActualStorageListForCart(
                    shoppingCarts.get((int) cardID).getProducts().get(i), shoppingCarts.get((int) cardID).getProductsQuantity().get(i)),
                    shoppingCarts.get((int) cardID).getProducts().get(i).getID()
            );
        }
    }

    private int isEnoughMoney(long personID){
        long cardID = findPersonActiveCard(personID);
        double m1 = people.get((int) personID).getMoneyInCash();
        double m2 = people.get((int) personID).getMoneyOnCard();
        double fullPrice = shoppingCarts.get((int) cardID).getTotalPrice();
        short result = 0;
        if(m1 > fullPrice) result += 1;
        if(m2 > fullPrice) result += 2;
        return result;
    }

    public void addProductToCard(){
        printPeopleData();
        long personID = Getter.getPositiveLong("Person id");
        printProductData();
        long productID  = Getter.getPositiveLong("Product id") ;
        long quantity = Getter.getLongFromRange("Quantity (max: "+ products.get((int)productID).getQuantity() + ")",1, products.get((int)productID).getQuantity());
        long cardID = findPersonActiveCard(personID);
        int totalDeliveryTime = getSlowestStorageDeliveryTimeFromList(getActualStorageListForCart(products.get((int)productID), quantity));
        shoppingCarts.get((int)cardID).addProduct(products.get((int)productID), quantity, totalDeliveryTime);
    }

    public void addProductToCard(long personID, long productID, long quantity){
        long cardID = findPersonActiveCard(personID);
        int totalDeliveryTime = getSlowestStorageDeliveryTimeFromList(getActualStorageListForCart(products.get((int)productID), quantity));
        if(products.get((int)productID).getQuantity() >= quantity){
            shoppingCarts.get((int)cardID).addProduct(products.get((int)productID), quantity, totalDeliveryTime);
        }else{
            Logger.Warning("Not enough item in storages");
        }
    }

    public void editProductQuantityInCart(){
        printPeopleData();
        long personID = Getter.getPositiveLong("Person id");
        printShoppingOfUserCartsData(personID);
        long productID  = Getter.getPositiveLong("Product id") ;
        long quantity = Getter.getLongFromRange("Quantity (max: "+ products.get((int)productID).getQuantity() + ")",1, products.get((int)productID).getQuantity());
        long cardID = findPersonActiveCard(personID);
        int totalDeliveryTime = getSlowestStorageDeliveryTimeFromList(getActualStorageListForCart(products.get((int)productID), quantity));
        shoppingCarts.get((int)cardID).editQuantity((int)productID, quantity, totalDeliveryTime);
    }

    private int getSlowestStorageDeliveryTimeFromList(ArrayList<Long []> from){
        int max = 0;
        for(Long [] f : from){
            if(storages.get(f[0].intValue()).getDeliveryTime() > max){
                max = storages.get(f[0].intValue()).getDeliveryTime();
            }
        }
        return max;
    }

    private ArrayList<Long []> productStorage(long id){
        ArrayList<Long []> productStorages = new ArrayList<>();
        for(Storage storage: storages){
            if(storage.isProductInStock(id)){
                productStorages.add(new Long[]{(long)storage.getID(), storage.getProductQuantity(id)});
            }
        }
        return productStorages;
    }


    private ArrayList<Long []> getActualStorageListForCart(Product product, long need){
        long quantityLeft = product.getQuantity();
        ArrayList<Long []> productStorages = productStorage(product.getID());
        ArrayList<Long []> from = new ArrayList<>();
        for(Long [] pS : productStorages){
            if(pS[1] == need){
                from.add(new Long[]{pS[0], need});
                return from;
            }
        }
        for(Long [] pS : productStorages){
            if(quantityLeft > 0){
                long how = (pS[1] > quantityLeft ? quantityLeft : pS[1]);
                from.add(new Long[]{pS[0], how});
                quantityLeft -= how;
            }
        }

        if(quantityLeft > 0){
            from.clear();
            from.add(new Long[]{(long)-1, (long)-1});
        }
        return from;
    }

    private long findPersonActiveCard(long personID){
        for(ShoppingCart shoppingCart : shoppingCarts){
            if(shoppingCart.getPersonID() == personID){
                return shoppingCart.getID();
            }
        }
        return -1;
    }

    // Product stuff ----------------------------------------------------------------------------------------
    public void addProduct(Product product){
        products.add(product);
        setUpStorageForNewProduct();
    }



    public void addProduct(){
        products.add(
                new Product(
                        products.size(), Getter.getString("Name"),
                        Getter.getProductType(), Getter.getPositiveDouble("Price")
                )
        );
        setUpStorageForNewProduct();
    }

    private void setUpStorageForNewProduct() {
        for (Storage storage : storages) {
            long how = Getter.getPositiveLong("Quantity in storage " + storage.getName());
            products.get(products.size() - 1).riseQuantity(how);
            storage.addProductToStorage(how);
        }
        if(products.get(products.size() - 1).getQuantity() > 0){
            products.get(products.size() - 1).setAvailable(true);
        }
    }

    public void raiseProductQuantityInStorage(int quantity){
        printStorageData();
        int storageID = Getter.getIntegerFromRange("Storage id", 0, storages.size() - 1);
        printProductData();
        long productID = Getter.getIntegerFromRange("Product id", 0, products.size() - 1);
        long how = Getter.getPositiveLong("How much to add: ");
        if(products.get((int)productID).getQuantity() + how > 0){
            products.get((int)productID).setAvailable(true);
        }
        products.get((int)productID).riseQuantity(how);
        storages.get(storageID).raiseQuantityInStorage(productID, how);
    }

    // Person stuff ----------------------------------------------------------------------------------------

    public void addPerson(Person person){
        people.add(person);
        shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), (long) people.size() - 1));
    }

    public void addPerson(){
        Person person = new Person(
                people.size(), Getter.getString("Name"), Getter.getString("surname"),
                Getter.getPositiveDouble("Cash in money"), Getter.getPositiveDouble("Cash on card"), shoppingCarts.size()
        );
        shoppingCarts.add(new ShoppingCart(shoppingCarts.size(), (long) people.size() - 1));
    }


    // Storage stuff ---------------------------------------------------------------------------------------

    public void addStorage(){
        storages.add(new Storage((short) storages.size(), Getter.getPositiveShort("Delivery time"), Getter.getString("name")));
    }

    public void addStorage(Storage storage){
        storages.add(storage);
    }


    // Print statement stuff -------------------------------------------------------------------------------

    public void printStorageData(){
        if(people.size() <= 0){
            Logger.Warning("List of storage is empty");
        }
        for(Storage storage : storages){
            Logger.App(storage.toString());
        }
    }

    public void printPeopleData(){
        if(people.size() <= 0){
            Logger.Warning("List of people is empty");
        }
        for(Person person : people){
            Logger.App(person.shortData());
        }
    }

    public void printProductData(){
        if(people.size() <= 0){
            Logger.Warning("List of product is empty");
        }
        for(Product product : products){
            Logger.App(product.toString());
        }
    }

    public void printShoppingCartsData(){
        if(people.size() <= 0){
            Logger.Warning("List of shopping carts is empty");
        }
        for(ShoppingCart shoppingCart : shoppingCarts){
            Logger.App(shoppingCart.toString());
        }
    }

    public void printShoppingOfUserCartsData(long ID){
        if(people.size() <= 0){
            Logger.Warning("List of this shopping cart is empty");
        }
        for(ShoppingCart shoppingCart : shoppingCarts){
            if(shoppingCart.getPersonID() == ID){
                Logger.App(shoppingCart.toString());
                return;
            }
        }
    }

}
