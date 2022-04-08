package lab;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Book {
    long ID;
    String name;
    Genre genre;
    Lang language;
    long authorId;
    long borrowerId;
    Date publishDate;
    int borrowCount;
    boolean isAvailable;

    public Book(long ID, String name, Genre genre, Lang language, long authorId, Date publishDate) {
        this.ID = ID;
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.authorId = authorId;
        this.publishDate = publishDate;
        this.borrowCount = 0;
        this.isAvailable = true;
    }

    void BorrowBook(){
        borrowCount++;
        isAvailable = false;
    }
    void PlaceBack(){
        isAvailable = true;
    }

    public String isAvailable(){
        if(isAvailable){
            return "Yes";
        }else{
            return "No";
        }
    }

    String getDatePublishDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(this.publishDate);
    }

    public String getShortData(){
        return "name: " + this.name + ", genre: " + this.genre + ", lang: " + this.language + ", publish date: " + this.publishDate;
    }

    public String bookToString() {
        return "Book id: " + ID + '\n' +
                "name: " + name + '\n' +
                "genre: " + genre + '\n' +
                "language: " + language + '\n' +
                "publish date: " + getDatePublishDate() + '\n' +
                "borrow: " + borrowCount + " times" + '\n' +
                "is available: " + isAvailable() + '\n';
    }
}
