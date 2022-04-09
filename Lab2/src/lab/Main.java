package lab;

public class Main {
    static Library library;
    public static void libraryOpen(){
        library = new Library();

        // Adding person to library
        library.addPersonToRegister("Maciej", "Dacewicz", Getter.getDate("01-01-1930"), new Address("USA", "New York", "Broadway", 1, 1));
        library.addPersonToRegister("Joe", "Doe", Getter.getDate("01-01-1930"), new Address("France", "Paris", "Bagietkowa", 22, 29));
        library.addPersonToRegister("Marie", "Curie", Getter.getDate("7-11-2001"), new Address("Poland", "Warsaw", "Passy", 21, 2));

        // Adding book to library
        library.addBookToRegister("Robinson Crusoe", Genre.Adventure, Lang.English, 0, Getter.getDate("01-04-2022"));
        library.addBookToRegister("Bīchi de no natsu", Genre.Detective, Lang.Japanese, 0, Getter.getDate("01-09-2021"));
        library.addBookToRegister("Piu piu", Genre.Fantasy, Lang.Polish, 0, Getter.getDate("01-02-2022"));
        library.addBookToRegister("Milosc milosc w zakopanem", Genre.Fantasy, Lang.Polish, 1, Getter.getDate("01-02-2012"));

        // Adding some borrow to library register
        library.addBorrowToRegister(1, 0);
        library.addBorrowToRegister(2, 1);
        library.addBorrowToRegister(1, 0);

        clearScreen();
        System.out.println("Welcome");
        System.out.println("Library system v1.0001");

    }

    public static void loopMessage(){
        System.out.println("Chose option");
        System.out.println("1. New book borrow");
        System.out.println("2. Return book");
        System.out.println("3. Extend book borrow time limit");
        System.out.println("4. List of library book");
        System.out.println("5. List of library user");
        System.out.println("6. Add new book");
        System.out.println("7. Add new user");
    }

    public static void clearScreen() {
        for(int clear = 0; clear < 20; clear++){
            System.out.println("\b") ;
        }
    }


    public static void main(String[] args) {
        libraryOpen();

        //noinspection InfiniteLoopStatement
        while (true){
            loopMessage();
            int option = Getter.getNaturalNumber("(Type number [1-7])", 1, 7);
            clearScreen();
            long person;
            long book;
            switch (option) {
                case 1 -> {
                    person = Getter.getNaturalNumber("Type person ID (member card): )", 0, library.personRegister.size() - 1);
                    book = Getter.getNaturalNumber("Type book ID (from second page): )", 0, library.personRegister.size() - 1);
                    library.addBorrowToRegister(person, book);
                }
                case 2 -> {
                    person = Getter.getNaturalNumber("Type person ID (member card): )", 0, library.personRegister.size() - 1);
                    book = Getter.getNaturalNumber("Type book ID (from second page): )", 0, library.personRegister.size() - 1);
                    library.returnBookToLibrary(person, book);
                }
                case 3 -> {
                    person = Getter.getNaturalNumber("Type person ID (member card): )", 0, library.personRegister.size() - 1);
                    book = Getter.getNaturalNumber("Type book ID (from second page): )", 0, library.personRegister.size() - 1);
                    library.expandBorrowDateLimit(person, book);
                }
                case 4-> library.printBookRegister();
                case 5-> library.printPersonRegister();
                case 6 -> {
                    person = Getter.getNaturalNumber("Type person ID (member card): )", 0, library.personRegister.size() - 1);
                    library.addBookToRegister(person);
                    System.out.println(library.bookRegister.get(library.bookRegister.size()-1).bookToString());
                }
                case 7 -> {
                    library.addPersonToRegister();
                    System.out.println(library.personRegister.get(0).personToString());
                }
                default -> System.out.println("Mistype??? Try again! :)");
            }
        }
    }
}
