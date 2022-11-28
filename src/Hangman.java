import java.util.*;
import java.io.*;
public class Hangman {
//IMPORTING SCANNER , WORDLIST AND ASSIGNING NAMES TO VARIABLES    
    File words;
    Scanner fileReader;
    String data;
    List<String> wordsList;
    int randomIndex;
    String targetWord;

    char[] targetWordArray;
    char[] myAns;
    ArrayList<String> preGuesses;
//WELCOME STATEMENT AND CHOOSING A RANDOM WORD FROM THE GIVEN WORD LIST
    public void printGameIntro() {
        try {
        System.out.println("Welcome to Hangman\nI'm thinking of a word!");
        words = new File("C:\\Users\\user\\git\\f27sa_2022-23_coursework-3\\wordList.txt");
        fileReader = new Scanner(words);
        Random random = new Random();
        data = fileReader.nextLine();
        wordsList = new ArrayList<String>(Arrays.asList(data.split(",")));
        randomIndex = random.nextInt(wordsList.size());
        targetWord = wordsList.get(randomIndex);
        }
        catch (FileNotFoundException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }
    }
//GUESSING THE WORD PART
    public boolean processInput() {
            
        Scanner scan = new Scanner(System.in);
        targetWordArray = targetWord.toCharArray();
        myAns = new char[targetWordArray.length];
        preGuesses = new ArrayList<String>();
        for (int i = 0; i<targetWordArray.length; i++) {
           myAns[i] = '?';
        }
          
    boolean correct = false;
    while (correct==false) {
        System.out.println("\nGuess a Letter : ");
        String guess = scan.next();
    if (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
        System.out.println("You can enter a single alphabet only, try again");
        guess = scan.next();
        }
//CHOOSING THE SAME ALPHABET                  
    if (preGuesses.contains(guess)) {
        System.out.println("You already guessed that letter. Pick a different one!");
        guess = scan.next();
        }
                
    boolean found = false;
    for (int i =0; i< targetWordArray.length; i++) {
    if (guess.charAt(0) == targetWordArray[i]) {
        myAns[i] = targetWordArray[i];
        found = true;
        }
   }
//IF THE ALPHABET GUESSED IS THERE OR NOT THERE STATEMENT                
    if (found) {
        System.out.println("Yes, my word does have that letter!");
        }
    if (!found) {
        System.out.println("Sorry, the word I am thinking of does not have this letter");
        }
                
    boolean done = true;
    for (int i =0; i< myAns.length; i++) {
    if (myAns[i] == '?') {
        System.out.print("_");
        done  = false;
        }
    
    else {
        System.out.print(""+  myAns[i]);
         }
     }
//FINAL STATEMENT , THE COMPLETELY GUESSED WORD & THANK YOU STATEMENT                
    if (done) {
        System.out.println("\nYou've guessed my word! It was: "+targetWord);
        System.out.println("You needed to guess " +targetWord.chars().distinct().count()+" letters.");
        System.out.println("Thank you for playing, goodbye!");
            correct = true;
            scan.close();
            return true;
         }
                
    preGuesses.add(guess);
         }
            
    fileReader.close();
    scan.close();
    return true;
    }
}