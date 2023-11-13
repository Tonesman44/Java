// Antonio Fabrizio
// Assignment 8
// Warm Up with Objects
// In this lab we implement a class and test it with an array

package fractions;

public class FractionMain {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        System.out.println("Fraction 1: " + fraction1);
        System.out.println("Fraction 2: " + fraction2);

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Sum: " + sum);

        boolean areEqual = fraction1.equals(fraction2);
        System.out.println("Are the fractions equal? " + areEqual);

        fraction1.setNum(2);
        fraction1.setDenom(4);

        System.out.println("Modified Fraction 1: " + fraction1);
    }
}
