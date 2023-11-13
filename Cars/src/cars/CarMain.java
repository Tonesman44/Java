// Antonio Fabrizio
// Assignment 8
// Warm Up with Objects
// In this lab we implement a class and test it with an array

package cars;

public class CarMain {
    public static void main(String[] args) {
        // Create an array of Car objects
        Car[] cars = new Car[3];

        // Initialize Car objects
        cars[0] = new Car("Ford", "Pinto", 1972, 17.5, 132480, 12, 8);
        cars[1] = new Car("Toyota", "Camry", 2020, 30.0, 5000, 15, 10);
        cars[2] = new Car("Honda", "Civic", 2018, 25.0, 8000, 14, 12);

        // Test methods for each car
        for (Car car : cars) {
            car.drive(50);     // Drive 50 miles
            car.fillTank(5);   // Fill 5 gallons of gas
            System.out.println("Fuel Remaining: " + car.getFuelRemaining());
            System.out.println(car); // Prints the car's attributes
            System.out.println();
        }
    }
}
