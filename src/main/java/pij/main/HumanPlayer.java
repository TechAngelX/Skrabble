package pij.main;

import java.io.File;
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

        while (true) {
            System.out.print("Enter your move in the format: 'word,square' (without the quotes). For example, for a suitable tile rack" +
                    "\nand board configuration, a downward move could be \"HI,f4\" and a rightward move could be \"HI,4f\". " +
                    "\n\nIn the word, upper-case letters are standard tiles and lower-case letters are wildcards." +
                    "\nEntering \",\" passes the turn.\n>> ");



            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine();
            if (input.equals(",")) {
                System.out.println("Passed move. Over to Computer");
                playerPassCount++;
                return null;
            }
            String[] strings = input.split(",");
            if (strings.length != 2) {
                System.out.println("Illegal Word Format");
                continue;
            }
            String word = strings[0].trim();
            String direction = strings[1].trim();

            setDirection(direction);

            if (wordValidator.isWordInDictionary(word)) {
                // Word is valid in the dictionary, check for tile rack next
                if (wordValidator.isWordInTileRack(word,direction)) {


                } else {
                    System.out.println("INVALID TILE: HUMAN");
//                    printMyileRackHelper("With tiles "+ printMyileRackHelper(""));
                }
//                    System.out.println("WANKR ! With the FUCKIN tiles " +             printPlayerTileRackClean("");
//                    + ", you cannot HP key,e3play word "+word+","+direction);                }
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
        if (wordValidator.isWordInTileRack(word,direction)) {
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


