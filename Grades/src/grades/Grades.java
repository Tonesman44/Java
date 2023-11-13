// Antonio Fabrizio
// September 25th 2023
// Lab 3 -  Grades
// User will provide their performance during the semester, and the program will output weighted semester average


package grades;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Program description
        System.out.println("This program calculates a student's course grade based on provided weights.");

        // Prompt for weights
        double homeworkWeight = getUserInput(scanner, "Homework weight? ");
        double exam1Weight = getUserInput(scanner, "Exam 1 weight? ");

        // Deduce the weight of exam 2
        double exam2Weight = 100 - homeworkWeight - exam1Weight;

        // Homework input
        System.out.println("\nHomework:");
        int numAssignments = (int) getUserInput(scanner, "Number of assignments? ");
        double avgHomeworkGrade = getUserInput(scanner, "Average Homework grade? ");
        int lateDaysUsed = (int) getUserInput(scanner, "Number of late days used? ");
        int labsAttended = (int) getUserInput(scanner, "Labs attended? ");

        // Calculate weighted homework score
        double weightedHomeworkScore = calculateWeightedHomeworkScore(homeworkWeight, numAssignments, avgHomeworkGrade, lateDaysUsed, labsAttended);

        // Exam 1 input
        System.out.println("\nExam 1:");
        double exam1Score = getUserInput(scanner, "Score? ");
        double exam1Curve = getUserInput(scanner, "Curve? ");
        double weightedExam1Score = calculateWeightedExamScore(exam1Weight, exam1Score, exam1Curve);

        // Exam 2 input
        System.out.println("\nExam 2:");
        double exam2Score = getUserInput(scanner, "Score? ");
        double exam2Curve = getUserInput(scanner, "Curve? ");
        double weightedExam2Score = calculateWeightedExamScore(exam2Weight, exam2Score, exam2Curve);

        // Calculate course grade
        double courseGrade = weightedHomeworkScore + weightedExam1Score + weightedExam2Score;

        // Display the final course grade
        System.out.println("\nCourse grade = " + courseGrade);

        // Close the scanner
        scanner.close();
    }

    private static double getUserInput(Scanner scanner, String prompt) {
        double userInput;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                userInput = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        return userInput;
    }

    private static double calculateWeightedHomeworkScore(double homeworkWeight, int numAssignments, double avgHomeworkGrade, int lateDaysUsed, int labsAttended) {
    	double maxHomeworkPoints = (numAssignments * 10.0) + (numAssignments * 4.0);        double homeworkScore = avgHomeworkGrade * numAssignments + labsAttended * 4.0;
        if (lateDaysUsed > numAssignments / 2) {
            homeworkScore *= 0.9; // Reduce score by 10% if too many late days
        } else {
            homeworkScore += 5.0; // Add 5 extra credit points if no late days used
        }
        if (homeworkScore > maxHomeworkPoints) {
            homeworkScore = maxHomeworkPoints; // Cap at maximum available points
        }
        return (homeworkWeight * homeworkScore) / maxHomeworkPoints;
    }

    private static double calculateWeightedExamScore(double examWeight, double examScore, double examCurve) {
        double adjustedScore = examScore + examCurve;
        if (adjustedScore > 100.0) {
            adjustedScore = 100.0; // Cap at 100 points
        }
        return (examWeight * adjustedScore) / 100.0;
    }
}
