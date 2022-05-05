package lab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Getter {
    private static Scanner scan = new Scanner(System.in);

    public static String getString(String message) {
        String buf;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("Enter at last one letter!");
            }
            Logger.User("[" + message + "]: ");
            buf = scan.nextLine();
            //scan.nextLine();
            flag = true;
        } while (!(buf.length() > 0));
        return buf;
    }

    public static double getPositiveDouble(String message) {
        double buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be positive");
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextDouble();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be double value");
            }
            flag = true;
        } while (!(buf >= 0));
        return buf;
    }

    public static int getIntegerFromRange(String message, int from, int to) {
        int buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be from " + from + " to" + to);
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be integer value");
            }
            flag = true;
        } while (!(buf >= from && buf <= to));
        return buf;
    }

    public static long getLongFromRange(String message, long from, long to) {
        long buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be from " + from + " to" + to);
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextLong();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be integer value");
            }
            flag = true;
        } while (!(buf >= from && buf <= to));
        return buf;
    }

    public static int getPositiveInteger(String message) {
        int buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be positive");
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextInt();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be integer value");
            }
            flag = true;
        } while (!(buf >= 0));
        return buf;
    }

    public static short getPositiveShort(String message) {
        short buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be positive");
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextShort();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be integer value");
            }
            flag = true;
        } while (!(buf >= 0));
        return buf;
    }

    public static Long getPositiveLong(String message) {
        long buf = 0;
        boolean flag = false;
        do {
            if (flag) {
                Logger.Warning("This value must be positive");
            }
            Logger.User("[" + message + "]: ");
            try{
                buf = scan.nextLong();
                scan.nextLine();
            }catch (InputMismatchException IMmE){
                IMmE.printStackTrace();
                Logger.Warning("This must be integer value");
            }
            flag = true;
        } while (!(buf >= 0));
        return buf;
    }

    public static ProductType getProductType() {
        Logger.User("Choose product type: ");
        for(int i = 0; i < ProductType.values().length; i++){
            Logger.User("[" + i + "]: " + ProductType.getFromInt(i) + "\n");
        }
        return ProductType.getFromInt(getIntegerFromRange("Option", 0, ProductType.values().length));
    }
}
