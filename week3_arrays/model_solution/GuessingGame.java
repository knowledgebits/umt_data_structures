import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] secretNumbers = {3, 7, 2, 9, 4}; // The secret number array
        int guessLimit = secretNumbers.length; // Set guess limit based on array length
        int guessCount = 0;
        boolean isGuessed = false;
        
        // Randomly select the secret number from the array
        int secretNumber = secretNumbers[random.nextInt(secretNumbers.length)];
        
        // Loop until player guesses correctly or runs out of guesses
        while (!isGuessed && guessCount < guessLimit) {
            System.out.printf("Guess a number between 1 and 10 (you have %d guesses left): ", guessLimit - guessCount);
            int guess = scanner.nextInt();
            
            if (guess == secretNumber) {
                System.out.println("Congratulations, you guessed the number!");
                isGuessed = true;
            } else if (guess < secretNumber) {
                System.out.println("The number is higher!");
                guessCount++;
            } else {
                System.out.println("The number is lower!");
                guessCount++;
            }
        }
        
        // Game over - inform player of the secret number and result
        System.out.println("Game over!");
        System.out.printf("The secret number was %d\n", secretNumber);
        if (!isGuessed) {
            System.out.println("Sorry, you lost!");
        }
        
        scanner.close();
    }

}
