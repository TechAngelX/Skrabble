package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private String word = ""; private String direction;
    private final WordValidator wordValidator;
    public HumanPlayer(TileBag tileBag) throws FileNotFoundException {
        super(tileBag);
        this.wordValidator = new WordValidator();
    }


    /** enterWordAndDirection() : Prompts the human player for their move and validates the input in "word,square" format.
     * Example: "DOG,K6" for downward (vertical) move or "DOG 6K" for rightward (horizontal) move.
     * Upper-case letters are formed from standard tiles, while lower-case letters are formed from blank tiles.
     * If the player is stuck, they can press "," to pass.
     *
     * @param gamePlay The current game instance.
     * @return The validated move in the format "word,direction".
     * @throws FileNotFoundException If the word list file is not found.
     */
    public String enterWordAndDirection(Scanner scanner) throws FileNotFoundException {
        while (true) {
            System.out.print("Enter your move in the format: 'word,square' (without the quotes) or enter ',' to pass: ");
            String input = scanner.nextLine().trim();

            if (input.equals(",")) {
                System.out.println("Passed move. Over to Computer");
                playerPassCount++;
                return null;
            }

            String[] parts = input.split(",");
            if (parts.length != 2) {
                System.out.println("Invalid format. Please enter word and direction separated by comma.");
                continue;
            }

            String word = parts[0];
            String direction = parts[1].trim();

            if (wordValidator.isWordInDictionary(word)) {
                if (wordValidator.isWordInTileRack(word, direction, this)) {
                    setDirection(direction);
                    System.out.println("Valid move: " + word + " at position " + direction.toUpperCase());
                    System.out.println("You have placed word: '" + word + "' at position " + direction.toUpperCase() + ".");
                    return word + "," + direction;
                } else {
                    System.out.println("You don't have the tiles to form the word: " + word);
                }
            } else {
                System.out.println("Word not found in dictionary: " + word);
            }
        }

    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    /**
     * Checks if the given word is in the player's tile rack.
     *
     * @param word The word to check.
     * @return A message indicating if the word is in the tile rack or not.
     * @throws FileNotFoundException If the word list file is not found.
     */
    public String isWordInTileRack(String word) throws FileNotFoundException {
        if (wordValidator.isWordInTileRack(word,direction,this)) {
            return "Word is in tile rack.";
        } else {
            return "Word is NOT in your tile rack.";
        }
    }

    /**
     * Checks if the given direction is valid.
     *
     * @param direction The direction to check.
     * @return A message indicating if the direction is valid or not.
     */
    public String isDirectionValid(String direction) {
        if (wordValidator.areCoordinatesValid(direction)) {
            return "That is a valid move.";
        } else {
            return "That is an illegal move.";
        }
    }

    public int calculateScore(String word) {
        int score = 0;
        for (char letter : word.toCharArray()) {
            score += Player.getPointsSwitchCase(letter);
        }
        return score;
    }

    public String getWord() {
        return word;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public int getScore() {
        return super.getScore();
    }


    //printPlayerTileRack() : Used EXTERNALLY to print formatted tile rack.
    @Override
    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        super.printPlayerTileRack(playerTiles, gameType);
    }
    //playerTileRackUnformulated() : Helper method Used Internally to print this humanPlayer tile rack only, with no string formatting.

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }






    @Override
    public String toString() {
        return "Human Player";
    }
}


