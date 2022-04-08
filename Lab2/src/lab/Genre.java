package lab;

public enum Genre {
    Adventure, Classic, Comics,
    Detective, Fantasy, Fiction;
    private int n;

    public static Genre fromInt(int n) {
        switch (n) {
            case 0: {
                return Adventure;
            }
            case 1: {
                return Classic;
            }
            case 2: {
                return Comics;
            }
            case 3: {
                return Detective;
            }
            case 4: {
                return Fantasy;
            }
            case 5: {
                return Fiction;
            }

            default: {
                return null;
            }
        }
    }
}
