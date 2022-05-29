public class Root extends Plants{
    public Root(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    int getReagent() {
        return super.getReagent() / 2;
    }

    @Override
    public String toString() {
        return "Subtype: Flower" + "\n"
                + super.toString();
    }
}
