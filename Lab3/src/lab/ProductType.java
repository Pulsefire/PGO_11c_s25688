package lab;

public enum ProductType {
    Consumable(0),
    Entertainment(1),
    Electronic(2);

    final int type;

    ProductType(int i) {
        type = i;
    }

    public static ProductType getFromInt(int val){
        switch (val) {
            case 0 -> {
                return Consumable;
            }
            case 1 -> {
                return Entertainment;
            }
            case 2 -> {
                return Electronic;
            }
            default -> {
                return null;
            }
        }
    }
}
