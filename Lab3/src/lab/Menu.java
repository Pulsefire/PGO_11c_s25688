package lab;

public class Menu {
    Shop shop;
    boolean flag;

    Menu(){
        shop = Utils.Read();
        flag = true;
    }

    public void Close(){
        Utils.Save(shop);
    }


    public void OptionPrint(){
        Logger.App(shop.welcomeMessage());
        Logger.App(
                """
                    
                    [1] Manage person
                    [2] Manage products
                    [3] Manage carts
                    [4] Manage storage
                    [5] Leave
                """
        );
        switch (Getter.getIntegerFromRange("[1-5]", 1, 5)){
            case 1->{
                Logger.App(
                        """
                            
                            [1] Add person
                            [2] Print list of person
                            [3] Print more data of chosen person
                            [4] Back
                        """
                );
                switch (Getter.getIntegerFromRange("[1-4]", 1, 4)){
                    case 1->{
                        shop.addPerson();
                    }
                    case 2->{
                        shop.printPeopleData();
                    }
                    case 3->{
                        Logger.App(shop.people.get(Getter.getIntegerFromRange("Person id", 0, shop.people.size() - 1)).toString());
                    }
                    case 4->{
                        return;
                    }
                }
            }
            case 2->{
                Logger.App(
                        """
                           
                           [1] Add product
                           [2] Add any numbers of product to chosen storage
                           [3] Print list of product
                           [4] Back
                        """
                );
                switch (Getter.getIntegerFromRange("[1-4]", 1, 4)){
                    case 1->{
                        shop.addProduct();
                    }
                    case 2->{
                        shop.raiseProductQuantityInStorage(Getter.getPositiveInteger("Quantity"));
                    }
                    case 3->{
                        shop.printProductData();
                    }
                    case 4->{
                        return;
                    }
                }
            }
            case 3->{
                Logger.App(
                        """
                           
                           [1] Add product to person cart
                           [2] Edit quantity product in person cart
                           [3] Print list of person product in cart
                           [4] Sell person cart
                           [5] Back
                       """
                );
                switch (Getter.getIntegerFromRange("[1-5]", 1, 5)){
                    case 1->{
                        shop.addProductToCard();
                    }
                    case 2->{
                        shop.editProductQuantityInCart();
                    }
                    case 3->{
                        shop.printShoppingOfUserCartsData(Getter.getIntegerFromRange("Person id", 0, shop.people.size() - 1));
                    }
                    case 4->{
                        shop.SellPersonCart();
                    }
                    case 5->{
                        return;
                    }
                }
            }
            case 4->{
                Logger.App(
                        """
                           
                           [1] Add storage
                           [2] List of storage
                           [3] Back
                       """
                );
                switch (Getter.getIntegerFromRange("[1-3]", 1, 3)){
                    case 1->{
                        shop.addStorage();
                    }
                    case 2->{
                        shop.printStorageData();
                    }
                    case 3->{
                        return;
                    }
                }
            }
            case 5->{
                Close();
                flag = false;
            }
        }
    }
}
