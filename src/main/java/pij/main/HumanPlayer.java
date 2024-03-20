package pij.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private String word;
    private String direction;
    private final WordValidator wordValidator;

    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
        this.wordValidator = new WordValidator(this);
        this.word = "";
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
    public String enterWordAndDirection(GamePlay gamePlay) throws FileNotFoundException {
        Scanner scanner = gamePlay.getScanner();
        if (scanner == null) {
            System.out.println("Scanner is not available.");
            return null;
        }

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

            setDirection(direction);

            if (!wordValidator.areCoordinatesValid(direction)) {
                System.out.println("Co-ordinates entered incorrectly. \nPlease enter in the format 'word,square'. Square (representing the board co-ordinates), must be \n" +
                        "a letter and number, or vice versa. For example,: H4 or 7D. If you are stuck, enter comma ',' to pass.");
                continue;
            }
            if (wordValidator.isWordInDictionary(word)) {
                return word + "," + direction;
            } else {
                System.out.println("\"" + word + "\" not in the dictionary. Please try again.");
            }
        }
        return null;
    }

    /**
     * Checks if the given word is in the player's tile rack.
     *
     * @param word The word to check.
     * @return A message indicating if the word is in the tile rack or not.
     * @throws FileNotFoundException If the word list file is not found.
     */
    public String isWordInTileRack(String word) throws FileNotFoundException {
        if (wordValidator.isWordInTileRack(word)) {
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


