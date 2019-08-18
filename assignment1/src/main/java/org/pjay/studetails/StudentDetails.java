package org.pjay.studetails;

/**
 * @author vijayk
 */
public class StudentDetails extends StudentData {
    char gender;

    public void showData() {
        System.out.println(" == Student data == ");
        System.out.println("gender :: " + gender);
        System.out.println("height :: " + height);
        System.out.println("weight :: " + weight);
        System.out.println("name :: " + name);
        System.out.println("age :: " + age);
    }

    public StudentDetails(char gender) {
        super(6.0f, 72);
        this.gender = gender;
    }
}
