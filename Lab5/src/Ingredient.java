public class Ingredient {
    private final String name;
    private final int baseReagent;

    int getReagent(){
        return baseReagent;
    }

    public Ingredient(String name, int baseReagent) {
        this.name = name;
        this.baseReagent = baseReagent;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Base reagent: " + baseReagent + "\n";
    }
}
