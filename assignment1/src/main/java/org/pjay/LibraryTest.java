package org.pjay;

/**
 * @author vijayk
 */
public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Issue();
        library.setBookNo(2345678);
        // library cannot call subclass methods.
        // ((Issue) library).setAuthorAndTitle("Vijay", "Java for starters");
        library.displayBookNo();
        // library cannot call subclass methods.
        // ((Issue) library).displayAuthorAndTitle();
        // ((Issue) library).displaySubName();

        Book book = new Issue();
        book.setBookNo(456789);
        book.setAuthorAndTitle("Vijay", "Spring DI for starters");
        book.displayBookNo();
        book.displayAuthorAndTitle();
        // Book cannot call subclass methods.
        // ((Issue) book).displaySubName();
    }
}
