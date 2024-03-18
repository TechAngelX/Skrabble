package pij.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HumanPlayer extends Player implements WordValidator {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }

    public void enterWordAndDirection(GamePlay gamePlay) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move in the format: 'word,square'. For example, downward (vertical) move could be DOG,K6 \n" +
                "and a rightward (horizontal) move could be DOG 6K. When choosing your word, Upper-case letters are formed from \n" +
                "staandard tiles. Lower-case letters formed from blank tiles [_5]. If you are stuck, press \",\" to pass.\n\n");

        while (true) {

            System.out.print("Enter 'word,square' or ',' to pass:\n  >> ");

            String input = scanner.nextLine();


            if (input.equals(",")) {
                System.out.println("Passed move. Over to Computer");
            break;
            }

            String[] strings = input.split(",");

            if (strings.length != 2) {
                System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                continue;
            }

            String word = strings[0].trim();
            String direction = strings[1].trim();
            String enteredDirection = direction;
            try {
                if (!validateAndProcessWord(word, direction, gamePlay)) {
                    continue; // Restart the loop to prompt the user again if the word is invalid
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Dictionary file not found.");
                continue; // Restart the loop if an error occurs while checking the word
            }


            // Check for letter/number direction, for pretty print
            if (Character.isLetter(direction.charAt(0))) {
                direction = "(Vertical)";
            } else {
                direction = "(Horizontal)";
            }

            System.out.println("Entered word: '" + word + "'");
            System.out.println("Entered direction: " + enteredDirection + " " + direction);
            break; // Exit the loop when valid input is provided
        }
        scanner.close();
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

    @Override
    public boolean validatePlayerTurn(Player player, String word, BoardInit board) {
        return false;
    }

    @Override
    public boolean isWordInDictionary(String word, String WORD_LIST) throws FileNotFoundException {
        return false;
    }
}
