// Antonio Fabrizio
// Assignment 8
// Warm Up with Objects
// In this lab we implement a class and test it with an array


package cars;

public class Car {
    private String make;
    private String model;
    private int year;
    private double mpg;
    private double milesDriven;
    private double fuelCapacity;
    private double fuelRemaining;

    // Constructor
    public Car(String make, String model, int year, double mpg, double milesDriven, double fuelCapacity, double fuelRemaining) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mpg = mpg;
        this.milesDriven = milesDriven;
        this.fuelCapacity = fuelCapacity;
        this.fuelRemaining = fuelRemaining;
    }

    // Method to add fuel to the tank
    public void fillTank(double g) {
        fuelRemaining = Math.min(fuelCapacity, fuelRemaining + g);
    }

    // Method to simulate driving
    public void drive(double m) {
        double fuelNeeded = m / mpg;
        if (fuelNeeded <= fuelRemaining) {
            fuelRemaining -= fuelNeeded;
            milesDriven += m;
        } else {
            System.out.println("Not enough fuel to complete the trip.");
        }
    }

    // Method to get the fuel remaining in the tank
    public double getFuelRemaining() {
        return fuelRemaining;
    }

    // Method to return a String representation of the car
    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year +
                ", MPG: " + mpg + ", Miles Driven: " + milesDriven +
                ", Fuel Capacity: " + fuelCapacity + ", Fuel Remaining: " + fuelRemaining;
    }
}
