public class Alcohol extends Liquid{
    private int percent;

    public Alcohol(String name, int baseReagent, int dissolubility, int percent) {
        super(name, baseReagent, dissolubility);
        setPercent(percent);
    }

    @Override
    int getReagent() {
        return super.getReagent() * getPercent();
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = Utils.isPercent(percent, getName());
    }

    @Override
    public String toString() {
        return "Subtype: Alcohol" + "\n"
                + super.toString()
                + "Percent: " + percent + "%\n";
    }
}
