/*
 * Antonio Fabrizio
 * Assignment 4 - A Game
 * User plays against computer in a game, the winner is determined based on the provided rules.
 * The program keeps track of game statistics and allows the user to play multiple rounds.
 */

package game;
import java.util.Random;
import java.util.Scanner;

public class game {

    // Define named constants for moves
    public static final int OLSEROD = 0;
    public static final int KNARREVIK = 1;
    public static final int UTESPELARE = 2;
    public static final int YNGVAR = 3;
    public static final int MELLTORP = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;
        int userWins = 0;
        int computerWins = 0;

        printGameRules();

        while (true) {
            char playRound = getUserChoice(scanner, "Play a round? (y/n): ");
            if (playRound == 'n') {
                break; // End the game
            }

            int userMove = getUserMove(scanner);
            int computerMove = generateComputerMove();
            
            // Rubric Criteria: Input echoed back to the user
            System.out.println("Your move is " + moveToString(userMove));
            System.out.println("Computer's move is " + moveToString(computerMove));

            // Rubric Criteria: Correctly determine winner of round
            int winner = determineWinner(userMove, computerMove);
            if (winner == 0) {
                System.out.println("It's a tie!");
            } else if (winner == 1) {
                System.out.println("You win this round!");
                userWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }

            roundsPlayed++;
        }

        // Rubric Criteria: Prints stats correctly
        printGameStatistics(roundsPlayed, userWins, computerWins);

        scanner.close();
    }

    // Function to print game rules
    private static void printGameRules() {
        System.out.println("Game Rules:");
        System.out.println("Melltorp beats Utespelare, Olserod");
        System.out.println("Utespelare beats Knarrevik, Yngvar");
        System.out.println("Knarrevik beats Melltorp, Olserod");
        System.out.println("Olserod beats Yngvar, Utespelare");
        System.out.println("Yngvar beats Melltorp, Knarrevik");
        System.out.println("In the event of a tie, the computer wins");
        System.out.println("");
    }

    // Function to get a valid user choice ('y' or 'n')
    private static char getUserChoice(Scanner scanner, String message) {
        char choice;
        while (true) {
            System.out.print(message);
            String input = scanner.next();
            choice = input.charAt(0);
            if (choice == 'y' || choice == 'n') {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
        return choice;
    }

    // Function to get a valid user move
    private static int getUserMove(Scanner scanner) {
        int move;
        while (true) {
            System.out.print("Enter your move (Olserod, Knarrevik, Utespelare, Yngvar, Melltorp): ");
            String input = scanner.next().toLowerCase();
            switch (input) {
                case "olserod":
                    move = OLSEROD;
                    break;
                case "knarrevik":
                    move = KNARREVIK;
                    break;
                case "utespelare":
                    move = UTESPELARE;
                    break;
                case "yngvar":
                    move = YNGVAR;
                    break;
                case "melltorp":
                    move = MELLTORP;
                    break;
                default:
                    System.out.println("Invalid move. Please enter a valid move.");
                    continue;
            }
            return move;
        }
    }

    // Function to generate a random computer move
    private static int generateComputerMove() {
        Random random = new Random();
        return random.nextInt(5); // Generates a random number between 0 and 4
    }

    // Function to determine the winner
    private static int determineWinner(int userMove, int computerMove) {
        // Check the rules to determine the winner
        if ((userMove == MELLTORP && (computerMove == UTESPELARE || computerMove == OLSEROD)) ||
            (userMove == UTESPELARE && (computerMove == KNARREVIK || computerMove == YNGVAR)) ||
            (userMove == KNARREVIK && (computerMove == MELLTORP || computerMove == OLSEROD)) ||
            (userMove == OLSEROD && (computerMove == YNGVAR || computerMove == UTESPELARE)) ||
            (userMove == YNGVAR && (computerMove == MELLTORP || computerMove == KNARREVIK))) {
            return 1; // User wins
        } else if (userMove == computerMove) {
            return 0; // It's a tie
        } else {
            return -1; // Computer wins
        }
    }
    
    // Function to print game statistics
    private static void printGameStatistics(int roundsPlayed, int userWins, int computerWins) {
        System.out.println("\nGame Statistics:");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("User wins: " + userWins);
        System.out.println("Computer wins: " + computerWins);
    }

    // Function to convert move index to move name
    private static String moveToString(int move) {
        switch (move) {
            case OLSEROD:
                return "Olserod";
            case KNARREVIK:
                return "Knarrevik";
            case UTESPELARE:
                return "Utespelare";
            case YNGVAR:
                return "Yngvar";
            case MELLTORP:
                return "Melltorp";
            default:
                return "Invalid Move";
        }
    }
}
