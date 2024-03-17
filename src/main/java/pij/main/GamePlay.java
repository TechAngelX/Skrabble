package pij.main;

import java.io.*;
import java.util.Scanner;

public class GamePlay {
    Scanner scanner = new Scanner(System.in);
    public TileBag tileBag;
    public HumanPlayer humanPlayer;
    public ComputerPlayer computerPlayer;
    private static final String WORD_LIST = "src/resources/wordlist.txt";
    BoardInit boardInit; // To access boardsize dimensions, and other Boardinit methods and constants.

    public GamePlay() throws IOException {

        tileBag = new TileBag();
        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);

        humanPlayer.intializePlayerTileRack();
        computerPlayer.intializePlayerTileRack();

            }
    public void openGameShowTiles() {
        System.out.println("OPEN GAME:\n------------");
        computerPlayer.printTileRack("Computer's Tiles: ");
        humanPlayer.printTileRack("Your Tiles: ");
    }
        public void closedGameShowTiles() {
        humanPlayer.printTileRack("Your Tiles: ");
    }

    // gameInPlay() This is the 'meat and veg' of the game, where main game logic takes place.
    // =======================================================================================
    public void gameInPlay(boolean isOpenGame) {
        if (isOpenGame) {
            openGameShowTiles();
        }
    else
            humanPlayer.printTileRack("Your Tiles: ");

        humanPlayer.enterWordAndDirection(this);
    }



    protected boolean isValidWord(String word) {
        try (Scanner wordListScanner = new Scanner(new File(WORD_LIST))) {
            while (wordListScanner.hasNextLine()) {
                String dictionaryWord = wordListScanner.nextLine().trim().toUpperCase();
                if (dictionaryWord.equals(word.toUpperCase())) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Word list file not found: " + WORD_LIST);
        }

        return false;
    }



    public boolean canPlaceWord(String word, int startingRow, int startingCol, String direction) {
        // Check word length against board boundaries
        if (word.length() > boardInit.currentGameBoardSize) {
            return false; // Word too long for the board
        }

        // Check for edge cases
        if ((direction.equals("horizontal") && startingCol + word.length() > boardInit.currentGameBoardSize) ||
                (direction.equals("vertical") && startingRow + word.length() > boardInit.currentGameBoardSize)) {
            return false; // Word would go beyond the board
        }

        // Placeholder for additional validation based on board state and game rules
        // ...

        // If validation passes, simulate placement using setElement:
        int currentRow = startingRow;
        int currentCol = startingCol;

        for (char letter : word.toCharArray()) {
            try {
                boardInit.setElement(currentRow, currentCol, String.valueOf(letter));
            } catch (IndexOutOfBoundsException e) {
                return false; // Placement would go out of bounds
            }

            // Update coordinates for the next letter
            if (direction.equals("horizontal")) {
                currentCol++;
            } else {
                currentRow++;
            }
        }

        // If simulation completes successfully, placement is valid
        return true;
    }

















//        setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?

    /** Helper Methods: Not for game play usage, but to assist with code writing/debugging.
     _________________________________________________________________________________
     */
    //        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.
}






