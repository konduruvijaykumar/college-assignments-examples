package org.pjay;

import java.util.Scanner;

/**
 * @author vijayk
 */
// https://www.sanfoundry.com/java-program-find-gcd-two-numbers/
// https://codereview.stackexchange.com/questions/26697/getting-the-smallest-possible-integer-ratio-between-two-numbers
public class RationalNumbers {

    int numerator, denominator, gcd = 1;

    public RationalNumbers() {
        numerator = 0;
        denominator = 1;
        simplify();
    }

    public RationalNumbers(int i1, int i2) {
        numerator = i1;
        denominator = i2;
        if (denominator == 0) {
            System.out.println("denominator value cannot be zero, hence defaulting it's value to one");
            denominator = 1;
        }
        simplify();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RationalNumbers numeralTest;
        int i1 = 0, i2 = 1;

        // Ask user to select constructor of choice and values required
        System.out.println("Please enter D/d to use default constructor, else enter A/a to use argument constructor :: ");
        String constructorChoice;
        constructorChoice = scanner.next();
        if ("D".equalsIgnoreCase(constructorChoice)) {
            numeralTest = new RationalNumbers();
        } else if ("A".equalsIgnoreCase(constructorChoice)) {
            System.out.println("Please enter numerator :: ");
            String numeratorValue = scanner.next();
            System.out.println("Please enter denominator :: ");
            String denominatorValue = scanner.next();
            try {
                i1 = Integer.parseInt(numeratorValue);
            } catch (NumberFormatException e){
                System.out.println("numerator value is not a valid number, hence using default value zero");
            }
            try {
                i2 = Integer.parseInt(denominatorValue);
            } catch (NumberFormatException e){
                System.out.println("denominator value is not a valid number, hence using default value one");
            }
            numeralTest = new RationalNumbers(i1, i2);
        } else {
            System.out.println("The constructor selection is not valid, hence defaulting to default constructor");
            numeralTest = new RationalNumbers();
        }

        System.out.println("Simplified ratio is :: " + numeralTest.toString());
        System.out.println("getGCD for given numbers is :: " + getGCD(i1, i2));
        System.out.println("getValue is :: " + numeralTest.getValue());
        // scanner.close();
    }

    private void simplify() {
        gcd = RationalNumbers.getGCD(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    private static int getGCD(int i1, int i2) {
        int gcdValue = 1;
        if (i1 == i2) {
            return i1;
        }
        int min = (i1 > i2) ? i2 : i1;//Math.min(i1,i2);
        for (int i = 2; i <= min; i++) {
            if (i1 % i == 0 && i2 % i == 0) {
                gcdValue = i;
            }
        }
        return gcdValue;
    }

    public double getValue() {
        // return (double) numerator/denominator;
        // return numerator/(double) denominator;
        return (double) numerator / (double) denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
