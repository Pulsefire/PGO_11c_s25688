public class Main {
    public static void main(String[] args) {
        Eliksir healPotion = new Eliksir("Ambivia", new Alcohol("Zbyszkowica", 25, 99, 40));
        healPotion.addIngredient(new Flower("Calendula", 100, 0));
        healPotion.addIngredient(new Flower("Pansy", 44, 0));
        healPotion.addIngredient(new Crystal("Magic Crystal", 1000, 100, 1000));
        healPotion.Create();
        healPotion.addIngredient(new Crystal("Magic Crystal", 1000, 100, 1000));
        healPotion.power();
        healPotion.printListOfIngredient();


        Eliksir magicBomb = new Eliksir("Earth explosion", new Water("Muddy water", 10, 10, false));
        magicBomb.addIngredient(new Flower("Calendula", 100, 0));
        magicBomb.addIngredient(new Ore("Sharp stones", 25, 100, false));
        magicBomb.addIngredient(new Crystal("Fire emblem", 100, 100, 1000));
        magicBomb.removeIngredient(new Flower("Calendula", 100, 0));
        magicBomb.power();
        magicBomb.Create();
        magicBomb.removeIngredient(new Ore("Sharp stones", 25, 100, false));
        magicBomb.printListOfIngredient();
    }
}