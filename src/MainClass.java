import java.util.*;
import java.io.*;
public class MainClass {
	private static GameSuperclass game;
	public static void main(String[] args){
//IMPORT SCANNER , RANDOM AND OTHER VARIABLES		
		Scanner scan  = new Scanner(System.in);
		int option;
		String checkOption;
		DiceRoller diceRoller;
	    Random random = new Random(); 
//WELCOME STATEMENT AND ASKING USER TO CHOOSE THE GAME		
	 System.out.println("Welcome to the Game Lounge! Please pick your game:");
	 System.out.println("1)Dice Roller");
	 System.out.println("2)Higher Or Lower");
	 System.out.println("3)Hangman");
//ASKING THE USER TO CHOOSE THE REQUIERD GAME 
	 checkOption = scan.next();
	 option = Integer.parseInt(checkOption);
//FOR DICE ROLLER
	 if (option==1) {
        diceRoller = new DiceRoller("Dice Roller");
		diceRoller.printGameIntro();
	 int rolls= scan.nextInt();
		diceRoller.processInput(rolls);
	  } 
//FOR HIGHER OR LOWER	 
	 else if (option == 2) {
		HigherOrLower higherOrLower = new HigherOrLower();
		higherOrLower.printGameIntro();
		higherOrLower.processInput();
	  } 
//FOR HANGMAN	 
	 else if (option == 3) {
		Hangman hangMan = new Hangman();
		hangMan.printGameIntro();
		hangMan.processInput();
	  }
		scan.close();
	}
	private static boolean isInt (String value) {
		try {
			Integer.parseInt(value);
			return true;
		}
		catch(NumberFormatException error) {
			return false;
		}
	}
}