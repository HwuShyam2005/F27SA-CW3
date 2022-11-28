import java.util.Random;
//THIS CLASS INHERITS FROM GAMESUPERCLASS
public class DiceRoller extends GameSuperclass{
    public String gameName;
//CREATING AN ATTRIBUTE AND CONSTRUCTOR
    public DiceRoller(String gameName) {
    	super(gameName);
        this.gameName=gameName;
    }
//INITIALIZING THE RANDOM CLASS AND GAME INTRODUCTION
    public void printGameIntro() {
        System.out.println("Welcome to "+ super.gameName);
//ASKING THE USER TO INPUT REQUIRED D6S (SIX SIDED DICE) TO BE ROLLED        
        System.out.println("Please input how many D6s you want to roll: ");
    }
//THE DICE ROLLING CONDITION AND WAY OF PRINTING    
    @Override
    public boolean processInput(int value) {
    	Random random = new Random(); 
        System.out.println("Dice rolled : ");
        for (int i = 1;i<value+1;i++) {
            System.out.print("Die "+i+" rolled "+(random.nextInt(7 - 1) + 1));
            if (i<value) {
                System.out.print(" | ");
            }
        }
//FINAL STATEMENT AND THANK YOU STATEMENT 
        System.out.println("All dice rolled!");
        System.out.println("Thank you for playing, goodbye!");
        return true;
    }
}