package lab;

public class Logger {
    public static void Error(String message){
        System.out.println("Error: " + message);
    }

    public static void Info(String message){
        System.out.println("Info: " + message);
    }

    public static void Warning(String message){
        System.out.println("Warning: " + message);
    }

    public static void App(String message){
        System.out.println("App: " + message);
    }

    public static void User(String message){
        System.out.print("User: " + message);
    }
}
