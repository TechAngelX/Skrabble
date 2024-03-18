package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HumanPlayer extends Player  implements WordValidator {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }


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

    /**
     *  enterWordAndDirection()  Prompts the human player for their move and validates the input in "word,square" format.
     *
     * The method validates the user input for:
     *   - Correct format (word and square separated by a comma)
     *   - Valid word using the provided dictionary (replace `isWordInDictionary`)
     *     *
     * @param gamePlay A reference to the current GamePlay object.
     * @throws FileNotFoundException If there's an issue accessing the word dictionary (replace `WORD_LIST` with your actual path).
     */
         public void enterWordAndDirection(GamePlay gamePlay) throws FileNotFoundException {

             try (Scanner scanner = new Scanner(System.in)) {
                 System.out.print("Enter your move in the format: 'word,square'. For example, downward (vertical) move could be DOG,K6 \n" +
                         "and a rightward (horizontal) move could be DOG 6K. When choosing your word, Upper-case letters are formed from \n" +
                         "standard tiles. Lower-case letters formed from blank tiles [_5]. If you are stuck, press \",\" to pass.\n\n");

                 while (true) {
                     System.out.print("Enter 'word,square' or ',' to pass:\n>> ");

                     String input = scanner.nextLine();

                     if (input.equals(",")) {
                         System.out.println("Passed move. Over to Computer");
                         break; // Exit the loop for a pass
                     }

                     String[] strings = input.split(",");

                     if (strings.length != 2) {
                         System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                         continue;
                     }

                     String word = strings[0].trim();
                     String direction = strings[1].trim();
                     //
                     if (!isDirectionValid(direction)) {
                         System.out.println("Invalid input format. \nPlease enter in the format 'word,square'. Square must be, for example,: H4 or 7D. If you are stuck, press ',' to pass.");
                        continue;
                     }

                     // Check Word is in Dictionary
                     if (!isWordInDictionary(word, WORD_LIST)) { // Overridden method from WordValidator class
                         System.out.println(" \"" + word + "\" is not a valid word. Please try again.");
                         continue;
                     }

                     // If word in dictionary, exit loop
                     break;
                 }
             }
         }

    // isWordInDictionary() : Simply checks whether user-inputted word (first half of the word,square string) is in dictionary.
    @Override
    public boolean isWordInDictionary(String word, String WORD_LIST) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(WORD_LIST))) {
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().equalsIgnoreCase(word)) {
                    return true;
                }
            }
            return false;
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