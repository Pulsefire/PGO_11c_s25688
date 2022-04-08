package lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Getter {

    //private static final Scanner scan = new Scanner(System.in);

    public static String getString(String message) {
        String buf;
        boolean flag = false;
        do {
            if (flag) {
                System.out.println("Error: Enter at last one letter!");
            }
            System.out.print("[" + message + "]: ");
//            if(scan.hasNextLine()) scan.nextLine();
            Scanner scan = new Scanner(System.in);
            buf = scan.nextLine();
            flag = true;
        } while (!(buf.length() > 0));
        return buf;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int maxDay(int m, int y) {
        if (m == 2) {
            return (isLeapYear(y) ? 29 : 28);
        } else if (m >= 1 && m <= 7) {
            return (m % 2 == 0 ? 30 : 31);
        } else {
            return (m % 2 == 0 ? 31 : 30);
        }
    }

    public static Date getDate(String message, int from, int to) {

        Date buf = new Date();
        System.out.println(message);
        int y = getNaturalNumber("Year", from, to);
        int m = getNaturalNumber("Month", 1, 12);
        int d = getNaturalNumber("Day", 1, maxDay(m, y));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            buf = formatter.parse(y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d));
        } catch (ParseException e) {
            System.out.println("Error: This is no date");
            e.printStackTrace();
        }
        return buf;
    }

    public static Date getDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            return formatter.parse(date);
        }catch (ParseException e){
            return new Date();
        }
    }

    public static int getNaturalNumber(String message, int from, int to) {
        int buf;
        boolean flag = false;
        do {
            if (flag) {
                System.out.println("Error: Enter number in range (" + from + " - " + to + ")!");
            }
            System.out.print("[" + message + "]: ");
            Scanner scan = new Scanner(System.in);
            buf = scan.nextInt();
            flag = true;
        } while (!(buf >= from && buf <= to));
        return buf;
    }

    public static Address getAddress(String message) {
        System.out.println(message);
        String country = getString("Country");
        String city = getString("City");
        String street = getString("Street");
        int house = getNaturalNumber("House number", 1, 9999);
        int flat = getNaturalNumber("Flat number", 1, 99999);
        return new Address(country, city, street, house, flat);
    }

    public static Lang getLang() {
        System.out.println("Choose lang: ");
        System.out.println(
                "[0]: English\n[1]: Polish\n[2]: Japanese\n[3]: Ukrainian\n"

        );
        return Lang.fromInt(getNaturalNumber("", 0, 3));
    }

    public static Genre getGenre() {
        System.out.println("Choose genre: ");
        System.out.println(
                "[0]: Adventure\n[1]: Classic\n[2]: Comics\n[3]: Detective\n[4]: Fantasy\n[5]: Fiction"
        );
        return Genre.fromInt(getNaturalNumber("", 0, 5));
    }
}
