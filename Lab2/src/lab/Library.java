package lab;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Library {
    ArrayList<Book> bookRegister;
    ArrayList<Person> personRegister;
    ArrayList<BorrowEntry> borrowRegister;

    public Library(){
        this.bookRegister = new ArrayList<>();
        this.personRegister = new ArrayList<>();
        this.borrowRegister = new ArrayList<>();
    }

    //Person
    //Add in console
    void addPersonToRegister(){
        LocalDate today = LocalDate.now();
        System.out.println("Creating entry about new person");
        String name = Getter.getString("Name");
        String surname = Getter.getString("Surname");
        Date dateOfBrith = Getter.getDate("Brith date: ", today.getYear() - 150, today.getYear() - 5);
        Address address = Getter.getAddress("Resident address: ");
        Person person = new Person(this.personRegister.size(), name, surname, dateOfBrith, address);
        this.personRegister.add(person);
        System.out.println("Success, person add to library");
    }

    //Add in code
    void addPersonToRegister(String name, String surname, Date dateOfBrith, Address address){
        Person person = new Person(this.personRegister.size(), name, surname, dateOfBrith, address);
        this.personRegister.add(person);
        //System.out.println("Success, person add to library");
    }

    //Book
    //Add in console
    void addBookToRegister(long idPerson){
        LocalDate today = LocalDate.now();
        System.out.println("Creating entry about new book");
        System.out.println("Publisher: [id]: " + idPerson + "[name]: " + personRegister.get((int)idPerson).getName() + " " + personRegister.get((int)idPerson).getSurname());
        System.out.println("Enter book data");
        long ID = this.bookRegister.size();
        String name = Getter.getString("Name");
        Genre genre = Getter.getGenre();
        Lang language = Getter.getLang();
        Date publishDate = Getter.getDate("Release date", 1500, today.getYear());

        this.bookRegister.add(personRegister.get((int)idPerson).PublishBook(ID, name, genre, language, idPerson, publishDate));
        System.out.println("Success, book add to library");
    }

    //Add in code
    void addBookToRegister(String name, Genre genre, Lang language, long authorId, Date publishDate){
        this.bookRegister.add(personRegister.get((int)authorId).PublishBook(this.bookRegister.size(), name, genre, language, authorId, publishDate));
        //System.out.println("Success, book add to library");
    }


    //Book register
    //Add in console
    public String whenBorrowLimitExpire(long idBook){
        for(int i = this.borrowRegister.size() - 1; i >= 0; i--){
            if(this.borrowRegister.get(i).getIdBook() == idBook){
                if(this.borrowRegister.get(i).getReturnStatus()){
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    return format.format(this.borrowRegister.get(i).getBorrowDateLimit());
                }
                return "Error";
            }
        }
        return "Error";
    }

    public long whoBorrowBook(long idBook){
        for(int i = this.borrowRegister.size() - 1; i >= 0; i--){
            if(this.borrowRegister.get(i).getIdBook() == idBook){
                if(this.borrowRegister.get(i).getReturnStatus()){
                    return this.borrowRegister.get(i).getIdPerson();
                }
                return -1;
            }
        }
        return -1;
    }

    public long entryOfLastBorrow(long idBook){
        for(int i = this.borrowRegister.size() - 1; i >= 0; i--){
            if(this.borrowRegister.get(i).getIdBook() == idBook){
                if(this.borrowRegister.get(i).getReturnStatus()){
                    return i;
                }
                return -1;
            }
        }
        return -1;
    }

    void addBorrowToRegister(long borrowerId, long bookId){
        if(!this.bookRegister.get((int) bookId).isAvailable){
            System.out.println("Book is not available jet, wait until: " + whenBorrowLimitExpire(bookId));
            System.out.println("The borrower is: " + this.personRegister.get((int)whoBorrowBook(bookId)).getShortData());
            return;
        }
        System.out.println("Creating entry about new book borrow");
        System.out.println("Borrower: id: " + borrowerId + " name: " + personRegister.get((int)borrowerId).getName() + " " + personRegister.get((int)borrowerId).getSurname());
        System.out.print("Book: ");
        System.out.println(this.bookRegister.get((int)bookId).getShortData());
        this.bookRegister.get((int)bookId).BorrowBook();
        this.borrowRegister.add(new BorrowEntry(this.borrowRegister.size(), borrowerId, bookId));
        System.out.println("Success, borrow entry add!");
    }

    void returnBookToLibrary(long personId, long bookId){
        if(this.bookRegister.get((int)bookId).isAvailable){
            System.out.println("You cannot return this book because this book is available !");
            return;
        }
        if(this.whoBorrowBook(bookId) != personId){
            System.out.println("You cannot return this book because you did not borrow it!");
            return;
        }
        if(this.bookRegister.get((int) bookId).isAvailable){
            System.out.println("You cannot return this book because he is already returned!");
            return;
        }
        this.borrowRegister.get((int)entryOfLastBorrow(bookId)).returnBook();
        this.bookRegister.get((int)bookId).PlaceBack();
        System.out.println("Success, book returned to library!");
    }

    void expandBorrowDateLimit(long personId, long bookId){
        if(this.bookRegister.get((int)bookId).isAvailable){
            System.out.println("You cannot return this book because this book is available !");
            return;
        }
        System.out.println(this.whoBorrowBook(bookId));
        if(this.whoBorrowBook(bookId) != personId){
            System.out.println("You cannot expand time limit of this book because you did not borrow it!");
            return;
        }
        if(this.bookRegister.get((int) bookId).isAvailable){
            System.out.println("You cannot expand time limit because he this book is already returned!");
            return;
        }
        this.borrowRegister.get((int)entryOfLastBorrow(bookId)).expandBorrowDateLimit();
        System.out.println("Success, book borrow time limit expand!");
    }

    void printPersonRegister(){
        this.personRegister.forEach(person -> System.out.println(person.personToString()));
    }

    void printBookRegister(){
        this.bookRegister.forEach(book -> System.out.println(book.bookToString()));
    }
}
