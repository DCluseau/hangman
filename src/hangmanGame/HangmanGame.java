package hangmanGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Main class
 */
public class HangmanGame {
	final static int nbErrorMax = 10;
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * Constructor (empty)
	 */
	HangmanGame() {
		
	}
	
	/**
	 * Function to create a list of the words to guess
	 * @return wordLists
	 */
	public static String[] createWordList(){
		String[] wordList = {"poutre", "pelle", "barbe", "trogne", "tractopelle", "covfefe", "abracadabra"};
		return wordList;
	}
	
	/**
	 * Function to randomly choose a word from a list
	 * @return word
	 */
	public static String chooseWord() {
		String[] wordList = createWordList();
		String word = "";
		Random rand = new Random();
		int numWord = rand.nextInt(wordList.length);
		word = wordList[numWord];
		return word;
	}
	
	/**
	 * Function to initialize the guess word
	 * @param word String
	 * @return emptyWord
	 */
	public static String initEmptyWord(String word) {
		String emptyWord= "";
		for(int i = 0; i < word.length(); i++) {
			emptyWord += "_";
		}
		return emptyWord;
	}
	
	/**
	 * Function to replace the underscores in the guess word with the guessed letter 
	 * @param guessWord String
	 * @param letter String
	 * @param index int
	 * @return guessWord
	 */
	public static String updateGuessWord(String guessWord, String letter, int index) {
		guessWord = guessWord.substring(0, index) + letter + guessWord.substring(index + 1);
		return guessWord;
	}
	
	/**
	 * Function to check if the given letter is in the word to guess
	 * @param letter String
	 * @param word String
	 * @return boolean
	 */
	public static boolean checkLetter(String letter, String word) {
		if(word.contains(letter)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Function to replace the underscores in the guess word with the guessed letter 
	 * @param word String
	 * @param guessWord String
	 * @param letter String
	 * @return guessWord
	 */
	public static String replaceChar(String word, String guessWord, String letter) {
		int index = 0;
		while(word.contains(letter)) {
			index = word.indexOf(letter);
			guessWord = updateGuessWord(guessWord, letter, index);
			word = word.substring(0, index) + "_" + word.substring(index + 1);
		}
		return guessWord;
	}
	
	/**
	 * Function to test if the entire word has been found
	 * @param guessWord String
	 * @return boolean
	 */
	public static boolean checkWin(String guessWord) {
		if(!guessWord.contains("_")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Function to ask a letter
	 * @return letter
	 */
	public static String askLetter() {
		String letter = "";
		System.out.println("Type a letter to guess the word : ");
		letter = scan.nextLine();
		if(letter.length() > 1) {
			System.out.println("Nice try, cheater !");
		}
		letter = letter.substring(0, 1);
		return letter;
	}
	
	/**
	 * Function to display emptyWord
	 * @param word String
	 */
	public static void displayGuess(String word) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		System.out.println(word);
	}
	
	/**
	 * Function to count number of remaining letters
	 * @param word String
	 * @param letter String
	 * @return count
	 */
	public static int countLetters(String word, String letter) {
		int count = 0;
		for(int i = 0; i < word.length() ; i++) {
			if(word.charAt(i) == letter.charAt(0)) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * Main program 
	 * @param args (empty)
	 */
	public static void main(String[] args) {
		String wordToGuess = chooseWord();
		String emptyWord = initEmptyWord(wordToGuess);
		String letter = "";
		int tries = 0;
		String letterTried = "";
		System.out.println("--------------------------------------------------------------");
		System.out.println("----------------------- HANGMAN ------------------------------");
		System.out.println("--------------------------------------------------------------");
		displayGuess(emptyWord);
		while(!checkWin(emptyWord) && tries < 10) {
			if(letterTried.length() > 0) {
				System.out.println("Letters tried : " + letterTried);
				System.out.println("You have " + (10 - tries) + " remaining tries.");
			}
			System.out.println("Remaining letters : " + countLetters(emptyWord, "_"));
			letter = askLetter();
			if(letterTried.contains(letter)) {
				tries++;
				System.out.println("You have already tried this letter.");
				System.out.println("You have " + (10 - tries) + " remaining tries.");
			}else if(checkLetter(letter, wordToGuess)) {
				//tries++;
				letterTried += letter + " ";
				emptyWord = replaceChar(wordToGuess, emptyWord, letter);
			}else {
				tries++;
				System.out.println("Sorry, the letter " + letter + " is not in the word.");
				letterTried += letter + " ";
				System.out.println("You have " + (10 - tries) + " remaining tries.");
			}
			displayGuess(emptyWord);
		}
		if(checkWin(emptyWord)) {
			System.out.println("You win !");
		}else {
			System.out.println("You lose !");
		}
	}
}
