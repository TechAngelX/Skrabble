package pij.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardInit {

    // Initialize the board with default values, and check min/max board sizes.
    private final String[][] board;
    private final int MIN_BOARD_SIZE = 11;
    private final int MAX_BOARD_SIZE = 26;

    private static final String DEFAULT_BOARD_PATH = "src/resources/defaultBoard.txt";

    public BoardInit() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH));
        String firstLine = reader.readLine();

        int boardSize = Integer.parseInt(firstLine.trim());
        if (boardSize < MIN_BOARD_SIZE || boardSize > MAX_BOARD_SIZE) {
            throw new RuntimeException("Invalid Board size. Board must have a minimum of 11, and a maximum 26 elements.");
        }
        this.board = new String[boardSize][boardSize];

        String line;

        int i = 0; // Initialize row index

        while ((line = reader.readLine()) != null) {
            if (i >= boardSize) {
                // Handle potential extra lines in the file (e.g., log warning or throw an exception)
                break;
            }

            String[] elementsFromTextFile = line.split("");

            int j = 0; // Initialize column index
            int columnIndex = 0; // Additional column index for handling enclosed characters

            while (j < elementsFromTextFile.length) {
                StringBuilder currentElement = new StringBuilder();

                if (elementsFromTextFile[j].equals("{")) {
                    // Handle curly braces
                    currentElement.append("{");
                    j++; // Move to the next character after '{'

                    while (!elementsFromTextFile[j].equals("}")) {
                        currentElement.append(elementsFromTextFile[j]);
                        j++;
                    }

                    currentElement.append("}");
                } else if (elementsFromTextFile[j].equals("(")) {
                    // Handle parentheses
                    currentElement.append("(");
                    j++; // Move to the next character after '('

                    while (!elementsFromTextFile[j].equals(")")) {
                        currentElement.append(elementsFromTextFile[j]);
                        j++;
                    }

                    currentElement.append(")");
                } else {
                    // Handle regular characters without curly braces or parentheses
                    currentElement.append(elementsFromTextFile[j]);
                }

                // Store only the first three characters
                board[i][columnIndex] = currentElement.substring(0, Math.min(3, currentElement.length()));

                columnIndex++; // Move to the next column index
                j++; // Move to the next character
            }
            i++; // Move to the next row
        }
        reader.close();

    }

    public String setElement(int row, int col, String value) {
        if (isValidIndex(row, col) && board != null) {
            board[row][col] = value;
            return "Element set successfully"; // Example return value
        } else {
            return "Invalid index or board not initialized"; // Example return value
        }
    }

    public void setRow(int row, String string) {
        try {
            String[] values = string.split("");
            if (values.length == board[0].length) {
                for (int i = 0; i < values.length; i++) {
                    board[row][i] = values[i];
                }
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); // TODO handle exception more better/appropriately
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Print alphabetic board column headers based on size (e.g., a-p if board size is 16).
        builder.append("  "); // Extra space for alignment
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i); // Unicode increments from U+0061 (97) to 'S' (board.length)
            builder.append(columnHeader).append("   "); // Add spacing for readability
        }
        builder.append("\n");

        // Print numeric board row headers based on size (e.g., 1-16 if board size is 16).
        for (int i = 0; i < board.length; i++) {
            String rowHeaderFormatted = String.format("%2d", i + 1);
            builder.append(rowHeaderFormatted).append(" ");
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]).append("  ");
            }
            builder.append(" ").append(rowHeaderFormatted).append("\n"); // Add row header at the end
        }

        // Print bottom row of column headers
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


