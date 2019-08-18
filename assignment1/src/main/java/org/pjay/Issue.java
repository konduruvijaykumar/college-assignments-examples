package org.pjay;

/**
 * @author vijayk
 */
public class Issue extends Book implements Branch {

    public void displaySubName() {
        System.out.println("Subject Name is :: " + subName);
    }
}
