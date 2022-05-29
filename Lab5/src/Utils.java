public class Utils {

    public static int isPercent(int value, String type){
        if(value >= 0 && value <= 100){
            return value;
        }else {
            System.out.println("Warning: Value od " + type + " should be in range from 0 to 100");
            System.out.println("Info: " + type + " set to 0");
            return 0;
        }
    }
}
