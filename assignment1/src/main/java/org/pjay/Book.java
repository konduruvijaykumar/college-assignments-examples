package org.pjay;

/**
 * @author vijayk
 */
public class Book extends Library {

    private String author;
    private String title;

    // void getInfo(String author, String title) {
    void setAuthorAndTitle(String author, String title) {
        // No idea on this functionality method, i only saw the pdf of questions as assignment.
        // Nothing was mentioned on this. Students from class should have idea of it.
        // Note: we will make it setter method, so that we can update data
        this.author = author;
        this.title = title;
    }

    void displayAuthorAndTitle() {
        System.out.println("author is :: " + author + " and title is :: " + title);
    }

}
