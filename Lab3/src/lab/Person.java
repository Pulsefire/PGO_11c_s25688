package lab;

import java.io.Serializable;
import java.util.ArrayList;

public class Person  implements Serializable {
    long ID;
    private String name, surname;
    private double moneyInCash, moneyOnCard;
    private ArrayList<Long> storyOfShop;
    private long activeScID;

    public Person(long ID, String name, String surname, double moneyInCash, double moneyOnCard, int activeScID) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.moneyInCash = moneyInCash;
        this.moneyOnCard = moneyOnCard;
        storyOfShop = new ArrayList<>();
        this.activeScID = activeScID;
    }

    public String shortData() {
        return "Name: " + name + " " + surname;
    }

    public void BuyByCard(double how, long newCart){
        moneyOnCard -= how;
        storyOfShop.add(activeScID);
        activeScID = newCart;
    }

    public void BuyByMoney(double how, long newCart){
        moneyInCash -= how;
        storyOfShop.add(activeScID);
        activeScID = newCart;
    }

    @Override
    public String toString() {
        return "Customer - " + ID + "\n"
                + "Name: " + name + " " + surname + "\n"
                + "Money in cash: " + moneyInCash + " USD\n"
                + "Money on card: " + moneyOnCard + " USD\n\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getMoneyInCash() {
        return moneyInCash;
    }

    public void setMoneyInCash(double moneyInCash) {
        this.moneyInCash = moneyInCash;
    }

    public double getMoneyOnCard() {
        return moneyOnCard;
    }

    public void setMoneyOnCard(double moneyOnCard) {
        this.moneyOnCard = moneyOnCard;
    }
}
