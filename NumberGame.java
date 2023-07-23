import java.util.Scanner;
import java.util.Random;

public class NumberGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();    //Random class is a class of java.util package for generating random numbers
        int min = 1;                     //Min & Max denotes the range of valid inputs by the user
        int max = 100;
        int maxAttempts = 5;             //Denotes max number of attempts a player have
        int score = 0;                   //Final score of the player

        System.out.println("***** Welcome to the NUMBER GAME! *****");

        do {                             // do-while loop that executes till the user enters "NO"
            int randomNumber = random.nextInt(max - min + 1) + min;   // Generates the random number which the player will guess
            int attempts = 0;            // Stores the number of attempts player already had
            int userGuess;               // Stores the guess of the player

            System.out.println("\nThink of a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();    // User Input of the guess of the number
                attempts++;                       // Calculating the number of attempts made

                if (userGuess == randomNumber) {    // If userguess is same as randomnumber then respective message will be displayed
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempt(s).");
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {   // If you reached maximum attempts then game will be terminated
                System.out.println("Sorry, you have run out of attempts. The number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));  // If player entered "YES" then game will begin again

        System.out.println("Thanks for playing! Your final score is " + score + " round(s) won.");  // Final score is printed
        scanner.close();
    }
}

