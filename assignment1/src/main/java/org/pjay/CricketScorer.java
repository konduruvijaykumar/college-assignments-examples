package org.pjay;

import java.util.Scanner;

/**
 * @author vijayk
 */
public class CricketScorer {

    private int score;

    public void four() {
        score += 4;
    }

    public void six() {
        score += 6;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        CricketScorer cricketScorer = new CricketScorer();
        System.out.println("Your score is :: " + cricketScorer.getScore());
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Please enter F/f for four, S/s for six, T/t for total score and E/e or anything for exiting");
        boolean continueLoop = true;
        String entry;
        while (continueLoop) {
            System.out.println("Please enter F/f for four, S/s for six, T/t for total score and E/e or anything for exiting");
            entry = scanner.next();
            if ("S".equalsIgnoreCase(entry)) {
                cricketScorer.six();
            } else if ("F".equalsIgnoreCase(entry)) {
                cricketScorer.four();
            } else if ("T".equalsIgnoreCase(entry)) {
                System.out.println("Your score is :: " + cricketScorer.getScore());
            } else {
                continueLoop = false;
                System.out.println("Exiting the application");
            }
        }
        System.out.println("Your final score is :: " + cricketScorer.getScore());
    }
}
