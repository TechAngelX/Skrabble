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

        humanPlayer.printTileRack("Your Tiles: ");
        computerPlayer.printTileRack("Computer's Tiles: ");
    }

    public void gameInPlay() {
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
    public boolean canPlaceWord(String word) {
        // TODO
        // This method should check if the provided word can be placed on the board in the given direction
        // considering the current board dimensions (16 default, or any size from 11 to 26).

        if (1 < word.length()) { // TODO  - REMOVE THIS WHEN PROPER LOGIC WORKED OUT.
//        if (boardInit.getCustomBoardSize() < word.length()) {
            return false; // Word too long for the board
        } else
            return true; // Placeholder for now, replace with full validation
    }


//        setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?

    /** Helper Methods: Not for game play usage, but to assist with code writing/debugging.
     _________________________________________________________________________________
     */
    //        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.
}






