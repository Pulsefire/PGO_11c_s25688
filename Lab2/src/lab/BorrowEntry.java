package lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowEntry {

    private final long ID;
    private final long idPerson;
    private final long idBook;
    private boolean returnStatus;
    private final Date borrowDate;
    private Date borrowDateLimit;
    private Date returnDate;

    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    public BorrowEntry(long ID, long idPerson, long idBook) {
        this.ID = ID;
        this.idPerson = idPerson;
        this.idBook = idBook;
        this.borrowDate = new Date();
        this.borrowDateLimit = new Date(borrowDate.getTime() + MILLIS_IN_A_DAY * 30);
        this.returnStatus = false;
        this.returnDate = null;
    }

    public void expandBorrowDateLimit() {
        this.borrowDateLimit = new Date(borrowDateLimit.getTime() + MILLIS_IN_A_DAY * 30);
    }

    public long getID(){ return ID;}

    public long getIdPerson() {
        return idPerson;
    }

    public long getIdBook() {
        return idBook;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getBorrowDateLimit() {
        return borrowDateLimit;
    }

    public String getStringBorrowDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(this.borrowDate);
    }

    public boolean getReturnStatus(){
        return !returnStatus;
    }

    public void returnBook(){
        this.returnStatus = true;
        returnDate = new Date();
    }

    public String getStringBorrowDateLimit() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(this.borrowDateLimit);
    }


}
