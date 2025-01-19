import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Game!");

        while (playAgain) {
            System.out.println("\nStarting a new round!");
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Guess a number between 1 and 100: ");

                try {
                    int userGuess = Integer.parseInt(scanner.nextLine());
                    
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please guess a number within the range (1-100).");
                        continue;
                    }

                    attempts++;

                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your total score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing the Number Game! Your final score is: " + totalScore);
        scanner.close();
    }
}
