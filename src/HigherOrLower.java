import java.util.Scanner;
import java.util.Random;
public class HigherOrLower {
//CREATING NEW SCANNER , RANDOM AND NUMBER FROM 0 TO 100
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    int number = random.nextInt(101 - 0) + 0;
    int tries = 1;
    int guess;
//WELCOME STATEMENT AND ASKING THE USER TO GUESS
    public void printGameIntro() {
        System.out.println("Welcome to Higher or Lower\nI'm thinking of a number between 0 and 100 (inclusive)\nPlease input your first guess:");
    }
//THE GUESSING CONDITION AND FINAL STATEMENT AFTER GUESSING THE NUMBER AND THANK YOU STATEMENT
    public boolean processInput() {
        for (int i=0;i<tries;i++) {
            guess = scan.nextInt();
            if (number > guess) {
                System.out.println("Sorry, my number is HIGHER than that! Guess again:");
                tries++;
            } else if (number < guess) {
                System.out.println("Sorry, my number is HIGHER than that! Guess again:");
                tries++;
            } else if (number == guess) {
                System.out.println("Correct! My number was: "+number);
                System.out.println("You got it right in "+tries+" guesses!");
                System.out.println("Thank you for playing, goodbye!");
            }
        }
        scan.close();
        return true;

    }
    
}