package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface WordValidator {
    static final String WORD_LIST = "src/resources/wordlist.txt";

    //https://github.com/Birkbeck/pij-2023-24-coursework-TechGits/blob/76c007efbae935c9dffa76f29277f7201ff12e10/src/main/java/pij/main/GamePlay.java

    boolean validatePlayerTurn(Player player, String word, BoardInit board);

    // First, check if word is in dictionary.

    boolean isWordInDictionary(String word, String WORD_LIST) throws FileNotFoundException;

    default boolean validateAndProcessWord(String word, String direction, GamePlay gameInPlay) throws FileNotFoundException {
        boolean isValidWord = isWordInDictionary(word, WORD_LIST);

        if (!isValidWord) {
            System.out.println("Error. '" + word + "' does not exist in dictionary");
            return false; // Terminate processing if word is invalid
        }

        word = word.toUpperCase();



        // Check for letter/number direction, for pretty print
        System.out.println("Entered word: " + word);
        System.out.println("Entered direction: " + direction + " " + formatDirection(direction));
        return true; // Indicate successful validation and processing
    }

    private String formatDirection(String direction) {
        return Character.isLetter(direction.charAt(0)) ? "(Vertical)" : "(Horizontal)";
    }



    default boolean canPlaceWord(HumanPlayer word, int row, int col, BoardInit board) {
        // Check for word going off the board
        if (row < 0 || col < 0 || row + word.length() > board.currentGameBoardSize || col + word.length() > board.currentGameBoardSize) {
            System.out.println("The word '" + word + "' is too large for the board.");
            System.out.println("Please try again with a smaller word.");
            return false;
        }

        // Implement additional checks for valid placement here
        //  - Check if the first tile placement is on an empty space or a star (center square)
        //  - Verify if adjacent tiles on the board match the corresponding letters in the placed word
        //      (both horizontally and vertically)

        // Assuming these checks are implemented in helper methods (not shown here)
        return isValidPlacement(word, row, col, board);  // Call helper method for full validation
    }






}







