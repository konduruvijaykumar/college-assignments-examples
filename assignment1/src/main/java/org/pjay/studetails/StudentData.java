package org.pjay.studetails;

import org.pjay.student.Student;

/**
 * @author vijayk
 */
public class StudentData extends Student {
    float height;
    float weight;

    public StudentData(float height, float weight) {
        super("Vjay", 29);
        this.height = height;
        this.weight = weight;
    }
}
