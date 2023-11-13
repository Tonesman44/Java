// Antonio Fabrizio
// Assignment 8
// Warm Up with Objects
// In this lab we implement a class and test it with an array

package fractions;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int n, int d) {
        if (d == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.numerator = n;
        this.denominator = d;
        reduce();
    }

    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public void setNum(int n) {
        numerator = n;
        reduce();
    }

    public void setDenom(int d) {
        if (d == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        denominator = d;
        reduce();
    }

    public Fraction add(Fraction a) {
        int newNumerator = (numerator * a.getDenom()) + (a.getNum() * denominator);
        int newDenominator = denominator * a.getDenom();
        return new Fraction(newNumerator, newDenominator);
    }

    public boolean equals(Fraction a) {
        return (numerator * a.getDenom()) == (denominator * a.getNum());
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private void reduce() {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
