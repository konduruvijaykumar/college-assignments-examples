package org.pjay;

/**
 * @author vijayk
 */
public class Book extends Library {

    String author;
    String title;

    void getInfo(String author, String title) {

    }

    void displayAuthorAndTitle() {
        System.out.println("author is :: " + author + " and title is :: " + title);
    }

}
