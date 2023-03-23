import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int[] score = {0, 0}; // user score, computer score

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter 'rock', 'paper', or 'scissors', or 'quit' to exit.");

        while (true) {
            System.out.print("Your choice: ");
            String userChoice = scanner.next();

            if (userChoice.equalsIgnoreCase("quit")) {
                break;
            }

            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer choice: " + computerChoice);

            int result = getResult(userChoice, computerChoice);
            if (result == 1) {
                System.out.println("You win!");
                score[0]++;
            } else if (result == -1) {
                System.out.println("Computer wins!");
                score[1]++;
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Score: User " + score[0] + " - " + score[1] + " Computer");
            System.out.println();
        }

        System.out.println("Final score: User " + score[0] + " - " + score[1] + " Computer");
        if (score[0] > score[1]) {
            System.out.println("Congratulations, you win!");
        } else if (score[1] > score[0]) {
            System.out.println("Sorry, the computer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static int getResult(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase("rock")) {
            if (computerChoice.equalsIgnoreCase("scissors")) {
                return 1; // user wins
            } else if (computerChoice.equalsIgnoreCase("paper")) {
                return -1; // computer wins
            }
        } else if (userChoice.equalsIgnoreCase("paper")) {
            if (computerChoice.equalsIgnoreCase("rock")) {
                return 1; // user wins
            } else if (computerChoice.equalsIgnoreCase("scissors")) {
                return -1; // computer wins
            }
        } else if (userChoice.equalsIgnoreCase("scissors")) {
            if (computerChoice.equalsIgnoreCase("paper")) {
                return 1; // user wins
            } else if (computerChoice.equalsIgnoreCase("rock")) {
                return -1; // computer wins
            }
        }
        return 0; // tie
    }
}
