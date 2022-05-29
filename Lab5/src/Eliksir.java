import java.util.ArrayList;
import java.util.List;

public class Eliksir {
    private final String name;
    private boolean isCreated;
    private int powerOfIngredient;
    private Liquid catalyst;
    private final List<Ingredient> ingredients;

    public Eliksir(String name, Liquid catalyst) {
        this.name = name;
        this.isCreated = false;
        this.catalyst = catalyst;
        this.ingredients = new ArrayList<>();
    }

    void power(){
        if(isCreated){
            System.out.println("Warning: Item is already created");
            return;
        }
        powerOfIngredient = 0;
        for(Ingredient ingredient : ingredients){
            powerOfIngredient += ingredient.getReagent();
        }
        powerOfIngredient /= catalyst.getReagent();
        System.out.println("Power of Elixir [" + name + "] is | " + powerOfIngredient + " |");
    }

    void addIngredient(Ingredient ingredient){
        if(isCreated){
            System.out.println("Warning: Item is already created, you can't add more item");
            return;
        }
        ingredients.add(ingredient);
    }

    void removeIngredient(Ingredient ingredient){
        if(isCreated){
            System.out.println("Warning: Item is already created, you can't remove item");
            return;
        }
        ingredients.remove(ingredient);
    }

    void Create(){
        if(isCreated){
            System.out.println("Warning: Item is already created");
            return;
        }
        isCreated = true;
        powerOfIngredient = 0;
        for(Ingredient ingredient : ingredients){
            powerOfIngredient += ingredient.getReagent();
        }
        powerOfIngredient /= catalyst.getReagent();
    }

    public String getName() {
        return name;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public Liquid getCatalyst() {
        return catalyst;
    }

    public void setCatalyst(Liquid catalyst) {
        this.catalyst = catalyst;
    }

    public void printListOfIngredient(){
        System.out.println("\n\nList of ingredient of " + name + "\n");
        System.out.println("Catalyst:\n");
        System.out.println(catalyst);

        System.out.println("Ingredients:\n");

        for(Ingredient ingredient : ingredients){
            System.out.println(ingredient);
        }

        System.out.println("\n");
    }
}
