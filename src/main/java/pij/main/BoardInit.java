package pij.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardInit<T> {
    private  final T[][] board;
    private final int MIN_BOARD_SIZE = 11;
    private final int MAX_BOARD_SIZE = 26;

    private static final String DEFAULT_BOARD_PATH = "src/resources/defaultBoard.txt";

    // Initialize the board with default values, and check min/max board sizes.
    public BoardInit() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH));
        String firstLine = reader.readLine();

        int boardSize = Integer.parseInt(firstLine.trim());
        if (boardSize < MIN_BOARD_SIZE || boardSize > MAX_BOARD_SIZE) {
            throw new RuntimeException("Invalid Board size. Board must have a minimum of 11, and a maximum 26 elements.");
        }
        this.board = (T[][]) new Object[boardSize][boardSize];

        String line;
        int i = 0; // Row index
        while ((line = reader.readLine()) != null) {
            if (i >= boardSize) {
                // Handle potential extra lines in the file (e.g., log warning or throw an exception)
                break;
            }
            String[] values = line.split("");
            if (values.length == boardSize) {
                for (int j = 0; j < values.length; j++) {
                    board[i][j] = (T)(values[j]);
                }
            } else {
                // Handle lines with invalid number of elements (e.g., log warning or throw an exception)
                System.err.println("Invalid line format in file: " + line);
            }
            i++;
        }
        reader.close();
    }
    public  void setElement(int row, int col, T value) {
        if (isValidIndex(row, col)) {
            board[row][col] = value;
        }
    }
    public void setRow(int row, String string) {
        try {
            String[] values = string.split("");
            if (values.length == board[0].length) {
                for (int i = 0; i < values.length; i++) {
                    board[row][i] = (T) (values[i]);
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); // TODO handle exception more better/appropriately
        }
    }

    // Helper method to convert string values to type T


    @Override
    public  String toString() {
        StringBuilder builder = new StringBuilder();

        // Print alphabetic board column headers based on size (e.g., a-p if board size is 16).
        builder.append("  "); // Extra space for alignment
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i);
            builder.append(columnHeader).append("  "); // Add spacing for readability
        }
        builder.append("\n");

        // Print numeric board row headers based on size (e.g., 1-16 if board size is 16).
        for (int i = 0; i < board.length; i++) {
            String RowHeaderFormatted = String.format("%2d", i + 1);
            builder.append(RowHeaderFormatted).append(" ");
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]).append("  ");
            }
            builder.append(" ").append(RowHeaderFormatted).append("\n"); // Add row header at the end
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
