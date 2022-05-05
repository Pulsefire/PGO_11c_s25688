package lab;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        do {
            menu.OptionPrint();
        } while (menu.flag);
    }
}
