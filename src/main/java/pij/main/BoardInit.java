// EDIT
package pij.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardInit {
    private final int[][] board;
    private final int MIN_BOARD_SIZE = 11;
    private final int MAX_BOARD_SIZE = 26;

    private static final String DEFAULT_BOARD_PATH = ("src/resources/defaultBoard.txt");

    public BoardInit() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH));
        String firstLine = reader.readLine();

        int boardSize = Integer.parseInt(firstLine.trim()); // Assuming the first line indicates the size of the square board (16 for example)
        if (boardSize < MIN_BOARD_SIZE || boardSize > MAX_BOARD_SIZE){
            throw new RuntimeException("Invalid Board size. Board must have a minimum of 11, and a maximum 26 elements.");
        }
        this.board = new int[boardSize][boardSize];

        // Initialize the board with default values
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 1;
            }
        }

    }



    public void setElement(int row, int col, int value) {
        if (isValidIndex(row, col)) {
            board[row][col] = value;
        }
    }

    public void setRow(int row, String string) {
        try {
            String[] numbers = string.split("");
            if (numbers.length == board[0].length) {
                for (int i = 0; i < numbers.length; i++) {
                    board[row][i] = Integer.parseInt(numbers[i]);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            //TODO - the NumberFormatException seems to work if FIRST LINE is not an integer, but randome text (i.e., dwieudiwei. Test More.
            e.printStackTrace(); // Handle exception appropriately
        }
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Print column headers a-p (or 's' if loadBoard
        builder.append("   "); // Extra space for alignment
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i);
            builder.append(columnHeader).append("  "); // Add spacing for readability
        }
        builder.append("\n");

        // Print row headers 1-16 (or 's' if loadBoard) and elements
        for (int i = 0; i < board.length; i++) {
            int rowHeader = i + 1;
            builder.append(rowHeader).append("  ");
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]).append("  ");
            }
            builder.append(" ").append(rowHeader).append("\n"); // Add row header at the end
        }

        // Print final row of column headers
        builder.append("   ");
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i);
            builder.append(columnHeader).append("  ");
        }

        return builder.toString();
    }



    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
