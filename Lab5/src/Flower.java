public class Flower extends Plants{
    public Flower(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    int getReagent() {
        return super.getReagent() * 2;
    }

    @Override
    public String toString() {
        return "Subtype: Flower" + "\n"
                + super.toString();
    }
}
