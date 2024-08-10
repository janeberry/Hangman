package Hangman;

import java.util.*;
public class Hangman {
    private static String [] words =   //choose secret word from these
            {"geography", "cat", "yesterday", "java", "truck", "opportunity",
                    "fish", "token", "transportation", "bottom", "apple", "cake",
                    "remote", "pocket", "terminology", "arm", "cranberry", "tool",
                    "caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
                    "fundamental", "capitol", "garbage", "anticipate", "apple"};

    private String secretWord;       // the chosen secret word
    private List<Character> correctLetters;   // correct guesses
    private List<Character> incorrectLetters; // incorrect guesses
    private Scanner stdin = new Scanner(System.in); // for user input




    public Hangman() {
        //TODO: Randomly choose a word from list of words
        //      and set the word as a secretWord (Use the Random class)
        Random rand = new Random();
        int randIndex = rand.nextInt(words.length);
        this.secretWord= words[randIndex];


        // TODO: Build a initial pattern with _ based on the secretWord (correctLetters)
        //       initialize incorrectLetters here using an ArrayList
        correctLetters = new ArrayList<Character>();
        for (int i=0; i<secretWord.length(); i++){
            correctLetters.add('_');
        }
        this.incorrectLetters = new ArrayList<Character>();
    }



    /**
     * playGame
     *
     * Until the game is not over,
     * the game starts with showing hangman first and the secret word size
     * read and print correct and incorrect guess until win or lose the game.
     * print the secret word after game is over
     * and let user know whether they win or lose.
     */
    public void playGame() {
        while (!gameOver()) {

            //Print the Hangman picture
            printHangman();

            //Print the correct guesses in the secret word
            for (int i = 0; i < this.correctLetters.size(); i++)
                System.out.print(this.correctLetters.get(i) + " ");

            //Print the incorrect letters that have been guessed
            System.out.print("\nWrong letters: ");
            for (int i = 0; i < this.incorrectLetters.size(); i++)
                System.out.print(this.incorrectLetters.get(i) + " ");

            //Prompt and read the next guess
            System.out.print("\nEnter a lower-case letter as your guess: ");
            String guess = stdin.nextLine();

            //Process the next guess
            handleGuess(guess.charAt(0));
        }

        System.out.println("The secret word was: " + secretWord);
        if (gameWon()) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Sorry, you lost.");
            printHangman();
        }
    }


    /**
     * handleGuess
     *
     * If the guessed letter (parameter ch) is in the secret word
     * then add it to the array list of correct guesses and tell the user
     *      that the guess was correct;
     * otherwise, add the guessed letter to the array list of incorrect
     *      guesses and tell the user that the guess was wrong.
     *
     * @param ch the guessed letter
     */
    public void handleGuess(char ch) {
        //////////////////////////
        // TODO your code here
        //////////////////////////

        //check letter
        if (ch >= 'a' && ch <= 'z') {
        //Checking if the user input is a letter

            //same guess
            if (correctLetters.contains(ch) || incorrectLetters.contains(ch)) {
                System.out.println("Try again with different letter");
                //If user guessed more than once with same letter, it will be not counted as wrong or incorrect,
                //and make user try again with different letter

            } else {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (ch == secretWord.charAt(i)) {
                        correctLetters.remove(i);
                        correctLetters.add(i, ch);
                    }
                }
                String guess = ch + "";
                if (secretWord.contains(guess)) {
                    System.out.println("Great! You guessed the right one!");
                } else {
                    incorrectLetters.add(ch);
                    System.out.println("Oops! " + ch + " was the wrong guess :(");
                }
            }
        } else {
            System.out.println("Write a letter please.");

        }
    }


    /**
     * gameWon
     *
     * Return true if the user has won the game
     * otherwise, return false.
     *
     * @return true if the user has won, false otherwise
     */
    public boolean gameWon() {
        return (!correctLetters.contains('_'));
    }

    /**
     * gameLost
     *
     * Return true if the user has lost the game(has made 7 wrong guesses)
     * otherwise, return false.
     *
     * @return true if the user has lost, false otherwise
     */
    public boolean gameLost() {
        if(incorrectLetters.size()==7){
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * gameOver
     *
     * Return true if the user has either won or lost the game;
     * otherwise, return false.
     *
     * @return true if the user has won or lost, false otherwise
     */
    public boolean gameOver() {
        return (gameLost() == true || gameWon() == true);

    }

    /**
     * printHangman
     *
     * Print the Hangman that corresponds to the given number of
     * wrong guesses so far.
     *
     */
    public void printHangman() {
        int poleLines = 6;   // number of lines for hanging pole
        System.out.println("  ____");
        System.out.println("  |  |");

        int badGuesses = this.incorrectLetters.size();
        if (badGuesses == 7) {
            System.out.println("  |  |");
            System.out.println("  |  |");
        }

        if (badGuesses > 0) {
            System.out.println("  |  O");
            poleLines = 5;
        }
        if (badGuesses > 1) {
            poleLines = 4;
            if (badGuesses == 2) {
                System.out.println("  |  |");
            } else if (badGuesses == 3) {
                System.out.println("  | \\|");
            } else if (badGuesses >= 4) {
                System.out.println("  | \\|/");
            }
        }
        if (badGuesses > 4) {
            poleLines = 3;
            if (badGuesses == 5) {
                System.out.println("  | /");
            } else if (badGuesses >= 6) {
                System.out.println("  | / \\");
            }
        }
        if (badGuesses == 7) {
            poleLines = 1;
        }

        for (int k = 0; k < poleLines; k++) {
            System.out.println("  |");
        }
        System.out.println("__|__");
        System.out.println();
    }


    /**
     * toString
     *
     * Returns a string representation of the Hangman object.
     * Note that this method is for testing purposes only!
     * @return a string representation of the Hangman object
     */
    public String toString() {
        String s = "secret word: " + this.secretWord;

        s += "\ncorrect letters: ";
        for (int i = 0; i < this.correctLetters.size(); i++)
            s += this.correctLetters.get(i) + " ";

        s += "\nused letters: ";
        for (int i = 0; i < this.incorrectLetters.size(); i++)
            s += this.incorrectLetters.get(i) + " ";

        s += "\n# bad letters: " + this.incorrectLetters.size();

        return s;
    }

    public void setCurrentWord(String newWord) {
        this.secretWord = newWord;
    }

    public void setCorrectLetters(ArrayList<Character> newGuesses) {
        this.correctLetters = newGuesses;
    }

    public void setIncorrectLetters(ArrayList<Character> newUsedLetters) {
        this.incorrectLetters = newUsedLetters;
    }

    public void setBadGuesses(int newBadGuesses) {
        this.incorrectLetters.clear();
        for (int i = 0; i < newBadGuesses; i++) {
            this.incorrectLetters.add('x');
        }
    }
}
