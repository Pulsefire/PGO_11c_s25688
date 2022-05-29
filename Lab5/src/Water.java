public class Water extends Liquid{
    private final boolean distilated;

    public Water(String name, int baseReagent, int dissolubility, boolean distilated) {
        super(name, baseReagent, dissolubility);
        this.distilated = distilated;
    }

    @Override
    int getReagent() {
        return super.getReagent() / (distilated ? 1 : 2);
    }

    @Override
    public String toString() {
        return "Subtype: Water" + "\n"
                + super.toString()
                + "Distilated: " + (distilated ? "Yes" : "No") + "\n";
    }
}
