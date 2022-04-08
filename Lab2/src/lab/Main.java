package lab;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.addPersonToRegister("Maciej", "Dacewicz", Getter.getDate("01-01-1930"), new Address("USA", "New York", "Broadway", 1, 1));
        library.addPersonToRegister("Joe", "Doe", Getter.getDate("01-01-1930"), new Address("France", "Paris", "Bagietkowa", 22, 29));
        library.addPersonToRegister("Marie", "Curie", Getter.getDate("7-11-2001"), new Address("Poland", "Warsaw", "Passy", 21, 2));
        //library.addPersonToRegister();
        //System.out.println(library.personRegister.get(0).personToString());
        library.addBookToRegister("Robinson Crusoe", Genre.Adventure, Lang.English, 0, Getter.getDate("01-04-2022"));
        library.addBookToRegister("Bīchi de no natsu", Genre.Detective, Lang.Japanese, 0, Getter.getDate("01-09-2021"));
        library.addBookToRegister("Piu piu", Genre.Fantasy, Lang.Polish, 0, Getter.getDate("01-02-2022"));
        //library.addBookToRegister(0);
        //System.out.println(library.bookRegister.get(0).bookToString());
        library.addBorrowToRegister(1, 0);
        library.addBorrowToRegister(2, 1);
        library.addBorrowToRegister(1, 0);
        library.expandBorrowDateLimit(1, 0);
        library.returnBookToLibrary(2, 1);
    }
}
