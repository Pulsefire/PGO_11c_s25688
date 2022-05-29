public class Plants extends Ingredient{
    private final int toxity;

    public Plants(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        this.toxity = toxity;
    }

    @Override
    int getReagent() {
        return super.getReagent() * toxity;
    }

    public int getToxity() {
        return toxity;
    }

    @Override
    public String toString() {
        return "Type: Plant" + "\n"
                + super.toString()
                + "Toxity: " + toxity + "\n";
    }
}
