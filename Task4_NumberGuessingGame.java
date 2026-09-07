import java.util.Random;
import java.util.Scanner;

public class Task4_NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int guess;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("===== Number Guessing Game =====");
        System.out.println("I'm thinking of a number between 1 and 100. Try to guess it!");

        while (!guessedCorrectly) {
            System.out.print("\nEnter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        System.out.println("\nThanks for playing!");
        sc.close();
    }
}
