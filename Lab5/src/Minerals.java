public class Minerals extends Ingredient{
    private final int power;

    public Minerals(String name, int baseReagent, int power) {
        super(name, baseReagent);
        this.power = power;
    }

    @Override
    int getReagent() {
        return super.getReagent() + power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Type: Mineral" + "\n"
                + super.toString()
                + "Power: " + power + "\n";
    }

}
