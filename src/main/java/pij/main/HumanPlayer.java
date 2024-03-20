package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HumanPlayer extends Player  implements WordValidator {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }

    // isDirectionValid() : Implemented from WordValidator class. Prompts the human player for their move and validates the input
    // in "word,square" format.
    @Override
    public boolean isDirectionValid(String direction) {
        if (direction == null || direction.isEmpty()) { // Check if null.
            return false;
        }
        char firstChar = direction.charAt(0);

        // Check if the first character is a digit, if it's a digit, check if the next character is a letter.
        if (Character.isDigit(firstChar)) {
            if (direction.length() > 1 && Character.isLetter(direction.charAt(1))) {
                // if true, continue with logic.
                return true;
            }
        } else if (Character.isLetter(firstChar)) {
            // Check if the first character is a letter, if it's a letter, check if the next character is a digit.
            if (direction.length() > 1 && Character.isDigit(direction.charAt(1))) {
                // if true, continue with logic.
                return true;
            }
        }
        // If none of the conditions are met, return false
        return false;
    }


    // enterWordAndDirection() : Prompts the human player for their word/move, and calls various methods to validate if the
    // word is in dictionary, in their tilerack, and if in correct "word,square" format.
    public String enterWordAndDirection(GamePlay gamePlay) throws FileNotFoundException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your move in the format: 'word,square'. For example, downward (vertical) move could be DOG,K6 \n" +
                    "and a rightward (horizontal) move could be DOG 6K. When choosing your word, Upper-case letters are formed from \n" +
                    "standard tiles. Lower-case letters formed from blank tiles [_5]. If you are stuck, press \",\" to pass.\n\n");

            while (true) {
                System.out.print("Enter 'word,square' or ',' to pass:\n>> ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String input = scanner.nextLine();
                if (input.equals(",")) {
                    System.out.println("Passed move. Over to Computer");
                    return null;
                }
                String[] strings = input.split(",");
                if (strings.length != 2) {
                    System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                    continue;
                }
                String word = strings[0].trim();
                String direction = strings[1].trim();

                // Calls isDirectionValid() and applies logic.
                if (!isDirectionValid(direction)) {
                    System.out.println("Invalid input format. \nPlease enter in the format 'word,square'. Square must be, for example,: H4 or 7D. If you are stuck, press ',' to pass.");
                    continue;
                }
                // Calls isWordInDictionary() and applies logic.
                if (isWordInDictionary(word, WORD_LIST)) {
                    return word + "," + direction; // Variables for us to use outside this class..
                } else {
                    System.out.println(" \"" + word + "\" not in the dictionary. Please try again.");
                    // No return here, so the loop will continue prompting for input.
                }
            }
        }
        // This statement is unreachable because the loop will continue until a valid word is entered.
        return null;
    }


    // Implemented isWordInDictionary here to comply with WordValidator interface
    @Override
    public boolean isWordInDictionary(String word, String WORD_LIST) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(WORD_LIST))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        }
        return false;
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