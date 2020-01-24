package org.pjay;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author vijayk
 */
public class HangmanGame {

    String[] words = {"apple", "panda", "sweety"};
    Random random = new Random();
    int maxAttempts = 8;
    String lettersAllowed = "abcdefghijklmnopqrstuvwxyz";
    String wordToGuess;
    char[] wordGuessed;
    int numberOfAttempts;
    ArrayList<String> lettersEnteredByUser = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the game Hangman!");
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.startGame();
        hangmanGame.playGame();
    }

    private void startGame() {
        numberOfAttempts = 0;
        wordToGuess = getRandomWord();
        wordGuessed = new char[wordToGuess.length()];
        for (int i = 0; i < wordGuessed.length; i++) {
            wordGuessed[i] = '_';
        }
        System.out.println("I am thinking of a word that is " + wordToGuess.length() + " letters long.");
    }

    private String getRandomWord() {
        return words[random.nextInt(words.length)];
    }

    private String wordGuessedContent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wordGuessed.length; i++) {
            builder.append(wordGuessed[i]);
            builder.append(' ');
        }
        return builder.toString();
    }

    private void playGame() {
        Scanner scanner = new Scanner(System.in);
        String enteredLetter;
        try {
            while (numberOfAttempts < maxAttempts) {
                System.out.println("\n------------------");
                System.out.println("You have " + (maxAttempts - numberOfAttempts) + " guesses left.");
                System.out.println("Available Letters: " + lettersAllowed);
                System.out.println("Please guess a letter: ");
                enteredLetter = scanner.next();
                // If user enters more than one char then we will take only first char
                if (null != enteredLetter) {
                    enteredLetter = enteredLetter.toLowerCase();
                    if (enteredLetter.length() > 1) {
                        enteredLetter = enteredLetter.substring(0, 1);
                    }
                }
                checkEnteredLetter(enteredLetter);

                if (isWordFound()) {
                    System.out.println("\n------------------");
                    System.out.println("Congratulations, you won!");
                    break;
                }
            }
            if (numberOfAttempts == maxAttempts) {
                System.out.println("\n------------------");
                System.out.println("You lost :( ");
            }
        } finally {
            scanner.close();
        }
    }

    private void checkEnteredLetter(String enteredLetter) {
        if (!lettersEnteredByUser.contains(enteredLetter)) {
            if (wordToGuess.contains(enteredLetter)) {
                int index = wordToGuess.indexOf(enteredLetter);
                while (index >= 0) {
                    wordGuessed[index] = wordToGuess.charAt(index);
                    index = wordToGuess.indexOf(enteredLetter, index + 1);
                }
                System.out.println("Good guess: " + wordGuessedContent());
                //lettersEnteredByUser.add(enteredLetter);
                //lettersAllowed = lettersAllowed.replaceAll(enteredLetter, "");
            } else {
                //System.out.println("Wrong guess: " + wordGuessedContent());
                //lettersEnteredByUser.add(enteredLetter);
                numberOfAttempts++;
            }
            lettersEnteredByUser.add(enteredLetter);
            lettersAllowed = lettersAllowed.replaceAll(enteredLetter, "");
        } else {
            System.out.println("Oops! You've already guessed that letter: " + wordGuessedContent());
        }
    }

    private boolean isWordFound() {
        return wordToGuess.equals(new String(wordGuessed));
    }
}
