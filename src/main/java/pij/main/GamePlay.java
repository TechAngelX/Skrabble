package pij.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GamePlay {
    Scanner scanner = new Scanner(System.in);
    public TileBag tileBag;
    public HumanPlayer humanPlayer;
    public ComputerPlayer computerPlayer;
    String[][] board;
    BoardInit boardInstance; // Declared instance, to be able to access boardsize dimensions, and other Boardinit methods and constants.

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
        boardInstance = new BoardInit(); // Here we start this games' board instance.
        this.board = boardInstance.board;
        boolean isOpenGame = isOpenGame();
        while (true) {
            if (isOpenGame) { //i.e., if this choice is open...
                openGameShowTiles();
            } else
                closedGameShowTiles();


            // Human player's turn
            // -------------------
            takeTurn(humanPlayer);

            // takeTurn(), etc... WHen human finished their turn (finished placing tile on board and dding to
            // their score, call method to check if game conditions have finished.


            if (endGameCriteriaMet()) {
                break;
            }

            // Computer player's turn (similar logic)
            // ---------------------------------------

            // takeTurn(), etc... When computer finished its turn (finished placing tile on board and adding to
            // their score, call method to check if game conditions have finished.
        }
        return true;
    }


    // isOpenGame(): Prompts the user to choose either an open or closed game type,
    // validates their input, and returns true for an open game, false for a closed game.
    public boolean isOpenGame() throws IOException {
        boolean isOpenGame = false;

        System.out.println("\nDo you want to play an _o_pen or _c_losed game?");
        System.out.print("Please enter your choice (o/c): ");

        String input;

        while (true) {
            input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("o")) {
                isOpenGame = true;
                break;
            } else if (input.equals("c")) {
                isOpenGame = false;
                break;
            } else {
                System.out.print("Invalid entry. Please enter 'o' for open or 'c' for closed game: ");
            }
        }

        if (isOpenGame) {
            System.out.println("Starting an open game...\n");
        } else {
            System.out.println("Starting a closed game...\n");
        }

        return isOpenGame;
    }

    public void takeTurn(HumanPlayer humanPlayer) throws IOException {
        humanPlayer.enterWordAndDirection(this); // Call method from HumanPlayer to get user input
        //  TODO in this takeTurn method:
        System.out.println("\nYour turn! ");
        //  Place the word on the board//
        boardInstance.setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?
        System.out.println(boardInstance.toString());
//        boardInstance.getCustomBoardSizeHelper(); // DELETE
        //  Remove used tiles from player's rack - huumanPlayer.removeFromTileRack(tiles used in the word);
        //  Update player's score
        //  Draw new tiles for the player -  humanPlayer.drawTiles(tileBag);

//        humanPlayer.printPlayerTileRack("Your Tiles:\t\t\t", true);
    }



    // ENDING THE GAME
    // ===============
    public boolean endGameCriteriaMet() {
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
//
//        System.out.println("\nGame Over!");
//        System.out.println(humanPlayer.toString() + " scored " + humanPlayer.getScore() + " points.");
//        System.out.println(computerPlayer.toString() + " scored " + computerPlayer.getScore() + " points.");

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
//            System.out.println("`\nThe " + winner + " wins!");
//            System.out.println("Thanks for playing SkraBBKle\n====================+++====");


        }
    }






    // openGameShowTiles() : Explicitly prints OPEN GAME: and computers tiles, as well as human tiles
    public void openGameShowTiles() throws IOException {
        computerPlayer.printPlayerTileRack("Computer's Tiles:  ", true);
        humanPlayer.printPlayerTileRack("Your Tiles:\t\t  ", true);

    }

    // openGameSjowTiles() : Just prints human tiles
    public void closedGameShowTiles() {
        humanPlayer.printPlayerTileRack("Your Tiles:\t", false);
    }





    /** Helper Methods: Not for game play usage, but to assist with code writing/debugging.
     _________________________________________________________________________________
     */
    //        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.


}







