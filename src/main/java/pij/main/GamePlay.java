package pij.main;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GamePlay {
    public TileBag tileBag;
    private MoveValidator moveValidator;
    public HumanPlayer humanPlayer;
    public ComputerPlayer computerPlayer;
    private boolean isGameTypeOpen = false;
    private String humanPlayerLastMove = "";
    Scanner scanner = new Scanner(System.in);




    String[][] board;
    private final BoardInit boardInstance; // Declared instance, to be able to access boardsize dimensions, and other Boardinit methods and constants.

    public GamePlay(BoardInit boardInstance) throws IOException {
        this.boardInstance = boardInstance;
        tileBag = new TileBag();
        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);
        humanPlayer.intializePlayerTileRack();
        computerPlayer.intializePlayerTileRack();
        this.scanner = new Scanner(System.in);
        moveValidator = new MoveValidator(boardInstance, humanPlayer);
//      moveValidator = new MoveValidator(boardInstance, computerPlayer);

    }

    // gameInPlay() This is the 'meat and veg' of the game, where main game logic takes place.
    // =======================================================================================
    // Inside the gameInPlay() method
    public void gameInPlay() throws IOException {
        isGameTypeOpen = hasUserSelectedOpenGame(); // logic to always return human tiles/computer tiles if user chose open or closed.
        this.board = boardInstance.board;
        if (isGameTypeOpen) {
            openGameShowTiles();
        } else {
            closedGameShowTiles();
        }

        while (true) {
            // Human player's turn
            // -------------------
            if (humanPlayerLastMove != null && humanPlayerLastMove.equals("humanPassFlagged")) {
                humanPlayer.playerPassCount++;
                humanPlayer.getPlayerPassCount(humanPlayer); // Just a test print to see if value is 1, after human presses comma.
                computersTurn(computerPlayer);
            } else {
                // Continue with the human player's turn
                if (isEndGameCriteriaMet()) { // If so, break out and instigate game ending.
                    break;
                }
                // Prompt for word and direction only if it's not a pass
                humansTurn(humanPlayer);
            }

            // Computer player's turn (similar logic)
            // ---------------------------------------
            computersTurn(computerPlayer);

            // Check end game criteria after each player's turn
            if (isEndGameCriteriaMet()) {
                break;
            }
        }
    }









    // openGameShowTiles() : Explicitly prints OPEN GAME: and computers tiles, as well as human tiles,
    // based on if user presses 'O'.
    public void openGameShowTiles() throws IOException {
        computerPlayer.printPlayerTileRack("Computer's Tiles:  ", true);
        humanPlayer.printPlayerTileRack("Your Tiles:\t\t  ", true);
    }

    // closedGameSjowTiles() : Just prints human tiles for a closed game
    // based on if user presses 'c'.
    public void closedGameShowTiles() {
        humanPlayer.printPlayerTileRack("Your Tiles:\t", false);
    }

    /**
     hasUserSelectedOpenGame() : Prompts the user to choose between an open or closed game type and validates their input.
     Returns true if the user chooses an open game, false if they choose a closed game.
     @return true if the user selects an open game, false if they select a closed game.
     @throws IOException if there are issues with input/output operations.
     */
        public boolean hasUserSelectedOpenGame() throws IOException {
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
        } else {
        }

        return isOpenGame;
    }


    public void someMethodInGameplay() {
        humanPlayer.setPlayerPassCount(2);
        int currentPassCount = humanPlayer.getPlayerPassCount(humanPlayer);
        System.out.println("Current pass count for human player: " + currentPassCount);
    }



    private final boolean isHumanTurn = true;


    // HUMAN TURN GAME LOGIC
    // ======================
    /**
     * humansTurn() : Handles the human player's turn during gameplay.
     * ---------------------------------------------------------------
     * * This method guides the human player through their turn, including the following steps:
     * 1. Prompts the player to enter a word and direction for placement on the board.
     * 2. Validates the entered word and direction according to brief's rules. (hopefully!)
     * 3. If the input is valid, places the word on the game board. (again, hopefully - work in progress)
     * 4. Updates the human player's score based on the points earned from the placed word.
     * 5. Displays the updated game board state after the player's turn.
     * 6. Draw another random tile into player's tile rack, and deprecate a tile from the tileBag. (unseen by human player).
     *
     * @param humanPlayer The HumanPlayer object representing the current player.
     * @throws IOException If there are issues with user input during the turn.
     */
   public void humansTurn(HumanPlayer humanPlayer) throws IOException {


        humanPlayerLastMove = humanPlayer.enterWordAndDirection(scanner);
        if (humanPlayerLastMove == null) {
            System.out.println("Human player passed the turn."); // test print
        }
        if (!humanPlayerLastMove.equals("humanPassFlagged")) { // Check if the move is not a pass
            // Passes board instance parameter, so that word (length) and direction (co-ordinates) can be checked against board size.
            System.out.println("You have placed word: '" + humanPlayer.getWord() + "' at position " + humanPlayer.getDirection().toUpperCase() + ".");

            boardInstance.placeWordOnBoard(humanPlayer);
            boardInstance.setElement(2,"B","W");
            moveValidator.isWithinBoard(humanPlayer.getWord(), humanPlayer.getDirection(), boardInstance.board);

            
            boardInstance.placeWordOnBoard(humanPlayer);
            moveValidator.isWithinBoard(humanPlayer.getWord(), humanPlayer.getDirection(), boardInstance.board);
//            humanPlayer.getScore();

            System.out.println(boardInstance.toString());
        }
//        boardInstance.placeWordOnBoard(this, humanPlayer);
//        Remove used tiles from player's rack - huumanPlayer.removeFromTileRack(tiles used in the word);
//        Update player's score
//        Draw new tiles for the player -  humanPlayer.drawTiles(tileBag);
//        humanPlayer.printPlayerTileRack("Your Tiles:\t\t\t", true);
        }


// COMPUTER TURN GAME LOGIC
// ======================
      public void computersTurn(ComputerPlayer computerPlayer) throws IOException {
        System.out.println("OK Computer. It's the Computer's turn!");

          // Just to bit of fun to add atmosphere to the AI. set maxTime to 0 (secondds) to turn effect off.
          computerPlayer.randomAIWaitTime(4);



//        // 1. Check if the computer can pass (no valid moves)
////        if (!computerPlayer.hasValidMoves(board, boardInstance.boardSize)) {
//            System.out.println("Computer passes its turn.");
////            computerPlayer.playerPassCount++;
//            return;
//        }

        // 2. Call the computer's AI to choose the best move
//        Move bestMove = computerPlayer.chooseMove(board, boardInstance.boardSize);

        // 3. Place the word on the board based on the chosen move
//        String word = bestMove.getWord();
//        String direction = bestMove.getDirection();
//        placeComputerTile(word, direction);
//
//        // 4. Update computer's score
//        computerPlayer.setScore(computerPlayer.getScore() + computerPlayer.calculateScore(word));
//
//        System.out.println("Computer placed: " + word + ", " + direction);
//        // 5. Draw new tiles for the computer (assuming drawTiles method exists)
//        computerPlayer.drawTiles(tileBag);
    }


// ENDING THE GAME
// ===============
    /**
     * isEndGameCriteriaMet() : Determines if the game has reached its end state. (This method is Unfinished / Work In Progress).
     * =====================================================================================
     * This method checks for the predefined criteria that signify the end of the SkraBBKle game.
     * If criteria met, it calls the endGame() method.
     */
    public boolean isEndGameCriteriaMet() {
        // Check for both conditions (empty tile bag AND either one of the players' rack is empty)
        if ((tileBag.tilesInBag.isEmpty() && humanPlayer.tileRack.isEmpty()) ||
                (tileBag.tilesInBag.isEmpty() && computerPlayer.tileRack.isEmpty())) {
            endGame();
            return true;
        }
        // Check for repeated passing by either player
        if (humanPlayer.playerPassCount == humanPlayer.TWO_PASS_COUNTS_IN_SUCCESSION ||
                computerPlayer.playerPassCount == computerPlayer.TWO_PASS_COUNTS_IN_SUCCESSION) {
            endGame();
            return true;
        }
        // Othewise, Game continues
        return false;
    }

    /** endGame( Ends the game and displays the final scores and winner.
     * =====================================================================================
     * Sets the scores for both human and computer players.Displays the scores, and announces the winner.
     * If scores are equalt, it announces a draw.  (Unfinished / WOrk In Progress).
     */
    public void endGame() {
        // Example test score for hypothetical end of game situation. (setScore parameters will not be manually set).
        humanPlayer.setScore(216);
        computerPlayer.setScore(203);

        System.out.println("\nGame Over!");
        System.out.println(humanPlayer.toString() + " scored " + humanPlayer.getScore() + " points.");
        System.out.println(computerPlayer.toString() + " scored " + computerPlayer.getScore() + " points.");

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
            System.out.println("Thanks for playing SkraBBKle\n====================+++====");
        }
    }

    /**
     * Helper Methods: Not for game play usage, but to assist with code writing/debugging.
     * _________________________________________________________________________________
     */
//   tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.
}
