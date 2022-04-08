package lab;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private final long ID;
    private String name;
    private String surname;
    private final Date dateOfBrith;
    private Address address;

    public Person(long ID, String name, String surname, Date dateOfBrith, Address address) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.dateOfBrith = dateOfBrith;
        this.address = address;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Book PublishBook(long ID, String name, Genre genre, Lang language, long authorId, Date publishDate) {
        return new Book(ID, name, genre, language, authorId, publishDate);
    }

    String getDateOfBrith() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(this.dateOfBrith);
    }

    String getShortData(){
        return "name: " + this.name + " " + this.surname;
    }

    String personToString() {
        return "Name: " + name + " " + surname + "\n" +
                "Date of Brith: " + getDateOfBrith() +
                address.addressToString();

    }


}
