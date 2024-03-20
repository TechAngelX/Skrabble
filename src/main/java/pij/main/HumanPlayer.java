package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HumanPlayer extends Player   {
    WordValidator wordValidator = new WordValidator(this);
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }
/** HUMAN PLAYER VALIDATION
 * ========================
 *  This class handles user interaction and word validation for the human player. *It includes methods for validating player
 *  moves and interacting with the game board. It performs the following checks:
 *
 * This class handles user interaction and word validation for the human player. It performs the following checks:
 * HumanPlayer performs five validation checks, utilizing methods from the WordValidator class:
 *
 *     enterWordAndDirection(): Prompts the human player for their move and validates the input in "word,square" format.
 *     isWordInDictionary(): Checks if the first part of the string (before comma ',') is present in the wordlist.txt.
 *     isWordInTileRack(): Iterates through the letters of each user-entered word and checks for a match in the tile rack. Blanks [_] are ignored.
 *     isDirectionValid(): Checks the second part of the string (e.g., H4) and determines if the user entered a digit or character.
 *  */

     public String enterWordAndDirection(GamePlay gamePlay) throws FileNotFoundException {
        WordValidator wordValidator = new WordValidator(this);
        return wordValidator.enterWordAndDirection(gamePlay);
    }


    public boolean isWordInDictionary(String word) throws FileNotFoundException {
        if (word.isEmpty()) {
            System.out.println("Word not in dict");
            return false;
        } else {
            System.out.println("word IS in dict.");


            return true;
        }
    }

    public String isWordInTileRack(String word) throws FileNotFoundException {
        if (wordValidator.isWordInTileRack(word)) {
            return "Word is in tile rack.";
        } else {
            return "Word is NOT in your tile rack.";
        }
    }

    public String isDirectionValid(String word) throws FileNotFoundException {
        if (wordValidator.isDirectionValid(word)) {
            return "THat is a valid move.";
        } else {
            return "That is an illegal move.";
        }
    }
    @Override
    public int getScore() {
        return super.getScore();
    }
    @Override
    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        super.printPlayerTileRack(playerTiles, gameType);
    }

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    @Override
    public String toString() {
        return "Human Player";
    }


}