public class Crystal extends Minerals{
    private final int magicPower;

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);
        this.magicPower = magicPower;
    }

    @Override
    int getReagent() {
        return super.getReagent() + magicPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    @Override
    public String toString() {
        return "Subtype: Crystal" + "\n"
                + super.toString()
                + "Magic power: " + magicPower + "\n";
    }
}
