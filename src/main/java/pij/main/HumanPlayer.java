package pij.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    protected  String word = "";
    protected String direction;
    private final WordValidator wordValidator;

    public HumanPlayer(TileBag tileBag) throws FileNotFoundException {
        super(tileBag);
        this.wordValidator = new WordValidator();
    }

    /**
     * enterWordAndDirection() : Prompts the human player for their move and validates the input in "word,square" format.
     * Example: "DOG,K6" for downward (vertical) move or "DOG 6K" for rightward (horizontal) move.
     * Upper-case letters are formed from standard tiles, while lower-case letters are formed from blank tiles.
     * If the player is stuck, they can press "," to pass.
     *
     * @param scanner The Scanner object used for user input.
     * @return The validated move in the format "word,direction".
     * @throws FileNotFoundException If the word list file is not found.
     */
    public String enterWordAndDirection(Scanner scanner) throws FileNotFoundException {
        while (true) {
            System.out.println(""); // Blank space
            System.out.print("____________________________________________________________________________________________________\n" +
                    "Enter your move in the format: 'word,square' (without the quotes). EXAMPLE: for a suitable tile rack\n" +
                    "and board configuration, downward move could be \"DOG,f4\" and a rightward move could be 'DOG,4f'.\n" +
                    "Upper-case letters are standard tiles and lower-case letters represent wildcards [_] in your tile \n" +
                    "rack. If you're stuck, entering \",\" on its own passes the turn.\n" +
                    "____________________________________________________________________________________________________\n" +
                    ">> ");

            String input = scanner.nextLine().trim();

            if (input.equals(",")) {
                setPlayerPassCount(); // A flag to count that the player passed on a move.
                return "humanPassFlagged";
            }

            String[] parts = input.split(",");
            if (parts.length != 2) {
                System.out.println("Invalid format. Entires must be seperated by a comma ',' for word and direction.\n");
                continue;
            }

            String word = parts[0];
            String direction = parts[1].trim();

            if (wordValidator.isWordInDictionary(word)) {
                if (wordValidator.isWordInTileRack(word, direction, this)) {
                    setDirection(direction);
                    setWord(word);
                    return word + "," + direction;
                } else {
                }
            } else {
                System.out.println("The word '"+word+"' is not found in dictionary." );
            }
        }

    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setWord(String word) {
        this.word = word;
    }


    public void setPlayerPassCount() {
        playerPassCount++;
    }


    /**
     * Checks if the given word is in the player's tile rack.
     *
     * @param word The word to check.
     * @return A message indicating if the word is in the tile rack or not.
     * @throws FileNotFoundException If the word list file is not found.
     */
    public String isWordInTileRack(String word) throws FileNotFoundException {
        if (wordValidator.isWordInTileRack(word, direction, this)) {
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


