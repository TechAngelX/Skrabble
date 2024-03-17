package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GamePlay {
    Scanner scanner = new Scanner(System.in);
    public TileBag tileBag;
    public HumanPlayer humanPlayer;
    public ComputerPlayer computerPlayer;
    private static final String WORD_LIST = "src/resources/wordlist.txt";
    BoardInit boardInit; // Declared instance, to be able to access boardsize dimensions, and other Boardinit methods and constants.

    public GamePlay() throws IOException {
        tileBag = new TileBag();
        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);

        humanPlayer.intializePlayerTileRack();
        computerPlayer.intializePlayerTileRack();
            }

    // gameInPlay() This is the 'meat and veg' of the game, where main game logic takes place.
    // =======================================================================================
    // Old info for reference: https://github.com/Birkbeck/pij-2023-24-coursework-TechGits/commit/ade26d95c356a7c5c67760dc6f87f31b0531b7a7

    public boolean gameInPlay() throws IOException { // TODO - Also create a 'gameIsFinished' method.
        boardInit = new BoardInit(); // Here we start this games' board instance.
        boolean isOpenGame = isOpenGame(); // Call once and store result
        while (true) {
            if (isOpenGame()) { //i.e., if this choice is open...
                openGameShowTiles();
                System.out.println("next open"); // test print.
            } else
                closedGameShowTiles();
            System.out.println("next closed"); // test print.


            // Human player's turn
            // -------------------

            // takeTurn(), etc... WHen human finished their turn (finished placing tile on board and dding to
            // their score, call method to check if game conditions have finished.


            if (endGameCriteriaMet());
            break;
          }

            // Computer player's turn (similar logic)
            // ---------------------------------------

           // takeTurn(), etc... When computer finished its turn (finished placing tile on board and adding to
           // their score, call method to check if game conditions have finished.



        return false;
    }












    protected boolean isOpenGame() throws IOException {
        System.out.println("\nDo you want to play an _o_pen or _c_losed game?");
        System.out.print("Please enter your choice (o/c): ");

        boolean userChoice = false;

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().toLowerCase().trim();
                userChoice = input.equals("o");
                if (userChoice || input.equals("c")) {
                    System.out.println("Starting " + (userChoice ? "an open" : "a closed") + " game...\n"); // Some Ternary syntactic sugar.

                } else {
                    System.out.print("Invalid entry. Please enter 'o' for open or 'c' for closed game: ");
                }
            }
        } catch (Exception e) {
            // Handle exception appropriately (e.g., print an error message)
            System.err.println("Error getting user input: " + e.getMessage());
        }
        return userChoice;

    }







    private boolean endGameCriteriaMet() {
    // Test Logic - replace with checks for game end conditions (e.g., empty tile bag).
    // If Tilebacg empty, tot up score and call method endGame()
    int num1 = 4;
    int num2 = 5;
    if (num1 < num2) {
        endGame();
        return true;

    } else {
        System.out.println("game continues");
        return false;
    }
    }

    // endGame() My initial draft of what the code to end the game would look like.
    // ===================================================================================
    public void endGame() {
        // Test scores for example.
        humanPlayer.setScore(216);
        computerPlayer.setScore(203);

        System.out.println("Game Over!");
        System.out.println("The " + humanPlayer + " scored " + humanPlayer.getScore() + " points.");
        System.out.println("The " + computerPlayer + " scored " + computerPlayer.getScore() + " points.");

        int humanScore = humanPlayer.getScore();
        int computerScore = computerPlayer.getScore();

        if (humanScore == computerScore) {
            System.out.println("It's a draw!");
        } else {
            String winner;
            if (humanScore > computerScore) {
                winner = humanPlayer.toString();

            } else {
                winner = computerPlayer.toString();
            }
            System.out.println("`\nThe " + winner + " wins!");
            System.out.println("Thanks for playing SkraBBKle\n========================");


        }
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


    public void openGameShowTiles() {
        System.out.println("OPEN GAME:\n----------");
        computerPlayer.printTileRack("Computer's Tiles:\t");
        humanPlayer.printTileRack("Your Tiles:\t\t\t");
    }
    public void closedGameShowTiles() {
        humanPlayer.printTileRack("Your Tiles: ");
    }





//        setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?

    /** Helper Methods: Not for game play usage, but to assist with code writing/debugging.
     _________________________________________________________________________________
     */
    //        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.
}






