public class Liquid extends Ingredient{
    private int dissolubility;

    public Liquid(String name, int baseReagent, int dissolubility) {
        super(name, baseReagent);
        setDissolubility(dissolubility);
    }

    @Override
    int getReagent() {
        return super.getReagent() * dissolubility;
    }

    public void setDissolubility(int dissolubility) {
        this.dissolubility = Utils.isPercent(dissolubility, getName());
    }

    public int getDissolubility() {
        return dissolubility;
    }

    @Override
    public String toString() {
        return "Type: Liquid" + "\n"
                + super.toString()
                + "Dissolubility: " + dissolubility + "\n";
    }
}
