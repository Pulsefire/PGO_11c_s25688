package lab;

import java.io.*;

public class Utils {

    public static void Save(Shop shop){
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        restoreDirectory();
        try {
            fileOut = new FileOutputStream("data/Shop.bin");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(shop);
            out.close();
            fileOut.close();
            Logger.Info("Shop info save");
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Error("File not found");
        }
    }

    public static Shop restoreShop(){
        Shop shop = new Shop();

        shop.addStorage(new Storage((short) shop.storages.size(), (short)0, "Shop"));
        shop.addStorage(new Storage((short) shop.storages.size(), (short)2, "Storage nr 1"));
        shop.addProduct(new Product(shop.products.size(), "Sweets", ProductType.Consumable, 1.34));
        shop.addProduct(new Product(shop.products.size(), "TV", ProductType.Electronic, 2000));
        shop.addProduct(new Product(shop.products.size(), "Bungee jump", ProductType.Entertainment, 200));
        shop.addPerson(new Person(shop.people.size(), "Mathew", "Doe", 10000, 2000, shop.shoppingCarts.size()));
        shop.addPerson(new Person(shop.people.size(), "Samira", "Foe", 10000, 2000, shop.shoppingCarts.size()));
        shop.addProductToCard(0, 0, 2);
        shop.addProductToCard(1, 2, 3);

        Save(shop);
        Logger.Info("Restoring data");
        return shop;
    }

    public static boolean restoreDirectory(){
        try {
            File dir = new File("data");
            File file = new File("data/Shop.dat");
            if(dir.mkdir()) {
                Logger.Info("dir data was created");
            }
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.Error("Something with text file goes wrong");
            return false;
        }
    }

    public static Shop Read(){
        Shop shop = null;
        if(restoreDirectory()){
            return restoreShop();
        }
        try {
            FileInputStream fileInp = new FileInputStream("data/Shop.bin");
            ObjectInputStream in = new ObjectInputStream(fileInp);
            shop = (Shop) in.readObject();
            //Test line

            Logger.Info("Read data from file end with success");
            fileInp.close();
            in.close();
            return shop;
        } catch (ClassNotFoundException | IOException e) {
            Logger.Error("File not found");
            e.printStackTrace();
            return restoreShop();
        }
    }

}
