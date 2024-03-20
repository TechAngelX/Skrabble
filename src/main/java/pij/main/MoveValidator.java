package pij.main;

/** BOARD MOVE VALIDATION
 * ========================
 * This class validates moves made by the human player on the game board.  It utilizes information about the current  game
 * board size, the player's entered word, and the required direction of placement of their tiles (e.g., H4)to perform various checks.
 *
 *     isWithinBoard( ) :Checks if user-entered word fits within current board dimensions (e.,g., 16 x 16 if using default board).
 *     isValidPlacement() :  Check if word fits on board (within boundaries)
 *     areOtherTilesInTheWay() : Checks if the placement connects to existing letters or starts on an empty space
 *     *
 *  */
public class MoveValidator {
    protected String word;
    protected String direction;
    private final int currentGameBoardSize;

    public MoveValidator(BoardInit boardInstance, HumanPlayer humanPlayer) {
        this.currentGameBoardSize = boardInstance.currentGameBoardSize(); // Access board size
        this.word = humanPlayer.getWord(); // Access word using getter
        this.direction = humanPlayer.getDirection(); // Access direction using getter
    }


    protected boolean isWithinBoard(String word, String direction, String[][] board) {
        int row = -1; // initialized for indices.
        int col = -1;

        char char1 = direction.charAt(0);
        char char2 = direction.charAt(1);

        // Determine col and row based on letters and numbers (ignoring the other)
        if (Character.isLetter(char1)) {
            col = Character.toLowerCase(char1) - 'a' + 1; // Non-zero-based indexing, lowercase
        } else if (Character.isDigit(char1)) {
            row = Character.getNumericValue(char1) - 1; // Row starts from 1
        }

        if (Character.isLetter(char2)) {
            col = Character.toLowerCase(char2) - 'A' + 1; // Non-zero-based indexing, lowercase
        } else if (Character.isDigit(char2)) {
            row = Character.getNumericValue(char2) - 1; // Row starts from 1, ignore col
        }

        // Check if word length exceeds board dimensions
        if (row != -1 && col != -1 && (word != null && col + word.length() > currentGameBoardSize)) {
            return false;
        } else if (col != -1 && (row + word.length()) > currentGameBoardSize) {
            return false;
        }

        // Check if spaces on board are empty for the intended placement
        for (int i = 0; i < word.length(); i++) {
            int newRow = (row == -1) ? row : row + i;
            int newCol = (col == -1) ? col : col + i;
            if (!board[newRow][newCol].isEmpty()) {
                return false; // Overlap detected
            }
        }

        return true;
    }




// TODO - More Checking methods below
// ==================================

//    public boolean isValidPlacement(String word, int row, int col, String direction) {
//        if (!isWithinBoard(word, row, col, direction)) {
//            return false;
//        }
//
//        // Check if placement connects to existing letters or starts on an empty space
//        if (!isConnectedOrStartsEmpty(word, row, col, direction)) {
//            return false;
//        }
//
//        // Additional checks (optional):
//        // - Check if the word forms valid words using existing letters on the board
//
//        return true;
//    }
//
//    private boolean areOtherTilesInTheWay(String word, int row, int col, String direction) {
//        // Some Logic to check if the placement connects to existing letters or starts on an empty space
//        // Perhaps this  might involve iterating through the word characters and checking the corresponding board positions
//        // based on the direction.
//    }

}