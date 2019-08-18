package org.pjay;

/**
 * @author vijayk
 */
public class Library {

    private int bookNo;

    // void getBookNo(int bookNo) {
    void setBookNo(int bookNo) {
        // No idea on this functionality method, i only saw the pdf of questions as assignment.
        // Nothing was mentioned on this. Students from class should have idea of it.
        // Note: we will make it setter method, so that we can update data
        this.bookNo = bookNo;
    }

    void displayBookNo() {
        System.out.println("bookNo :: " + bookNo);
    }

}
