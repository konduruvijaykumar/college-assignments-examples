package org.pjay;

/**
 * @author vijayk
 */
public class LibraryTest {
    public static void main(String[] args) {
        System.out.println(" == Library Reference Variable == ");
        Library library = new Issue();
        library.setBookNo(2345678);
        // library cannot call subclass methods.
        // ((Issue) library).setAuthorAndTitle("Vijay", "Java for starters");
        library.displayBookNo();
        // library cannot call subclass methods.
        // ((Issue) library).displayAuthorAndTitle();
        // ((Issue) library).displaySubName();

        System.out.println(" == Book Reference Variable == ");
        Book book = new Issue();
        book.setBookNo(456789);
        book.setAuthorAndTitle("Vijay", "Spring DI for starters");
        book.displayBookNo();
        book.displayAuthorAndTitle();
        // Book cannot call subclass methods.
        // ((Issue) book).displaySubName();

        System.out.println(" == Branch Reference Variable == ");
        Branch branch = new Issue();
        // Branch cannot call methods.
        // ((Issue) branch).setBookNo(389643);
        // ((Issue) branch).setAuthorAndTitle("Vijay", "Spring MVC for starters");
        // ((Issue) branch).displayBookNo();
        // ((Issue) branch).displayAuthorAndTitle();
        branch.displaySubName();

        System.out.println(" == Issue Reference Variable == ");
        Issue issue = new Issue();
        issue.setBookNo(00700);
        issue.setAuthorAndTitle("Vijay", "Spring Boot for starters");
        issue.displayBookNo();
        issue.displayAuthorAndTitle();
        issue.displaySubName();
    }
}
