import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;
        char playAgain;

        System.out.println("Welcome to Number Guessing Game!");

        do {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + rounds + ":");
            System.out.println("You have " + maxAttempts + " attempts to guess the number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
        scanner.close();
    }
}
