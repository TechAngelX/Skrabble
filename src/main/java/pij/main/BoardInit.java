package pij.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// class BoardInit - Initializes the board (custom or default), and checks min/max board sizes.
public class BoardInit {

    protected static String CUSTOM_BOARD_DIR_PATH = "src/resources/"; // Directory for custom board files.
    protected static final String DEFAULT_BOARD_FILE_PATH = "src/resources/defaultBoard.txt"; // dir and rel path for default board.

    protected final int MIN_BOARD_SIZE = 11;
    protected final int MAX_BOARD_SIZE = 26;
    protected int currentGameBoardSize; // Gets board size depending on first line (integer) read from loaded custom board.
    private GamePlay gameConfig;
    protected String[][] board;


    // BoardInit() - Constructor to Initialize board, loads data into 2D array, formats and prints initial board.
    public BoardInit() throws IOException {
        this.gameConfig = new GamePlay(this);

        String filePath = DEFAULT_BOARD_FILE_PATH;

        BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_FILE_PATH));
        String firstLine = reader.readLine();

        int boardSize = Integer.parseInt(firstLine.trim());
        currentGameBoardSize = boardSize;
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

    // introHeader() -  Prints the game introduction header.
    private void introHeader() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }



    // isCustomBoard() : Prompts the user to load a custom board, or use the default board.
    // Sets flag (true/false) which will determine whether the createTheBoard() method loads a custom or default board.
    private boolean isCustomBoard() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");

        String boardChoice;
        while (true) {
            boardChoice = scanner.nextLine().toLowerCase();
            if (boardChoice.equals("l") || boardChoice.equals("d")) {
                break;
            } else {
                System.out.print("Invalid entry. Please enter your choice (l/d): ");
            }
        }
        if (boardChoice.equals("l")) {
            return true; //  Passes this true value to createTheBoard
        } else {
            return false; // Ditto
        }
    }

    // createTheBoard() : Checks/parses filename based on if user selected custom or default board.
    // Initializes the board, loads data into 2D array, prints initial board.

    private void createTheBoard() throws IOException {
        String filePathCustomOrDefault;
        Scanner scanner = new Scanner(System.in);

        if (isCustomBoard()) {
            while (true) {
                System.out.print("Please enter the file name of the board: ");
                String customBoardFileName = scanner.nextLine().toLowerCase().replaceAll("^([^.]+).*", "$1");
                filePathCustomOrDefault = CUSTOM_BOARD_DIR_PATH + customBoardFileName + ".txt";

                File file = new File(filePathCustomOrDefault);
                if (file.exists() && file.isFile()) {
                    break;
                } else {
                    System.out.println(customBoardFileName + ".txt" + ", is not a valid file. ");
                }
            }
        } else {
            filePathCustomOrDefault = DEFAULT_BOARD_FILE_PATH;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathCustomOrDefault))) {
            String firstLine = reader.readLine();

            int boardSize = Integer.parseInt(firstLine.trim());
            currentGameBoardSize = boardSize;

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
                        currentElement.append("{");
                        j++; // Move to the next character after '{'

                        while (!elementsFromTextFile[j].equals("}")) {
                            currentElement.append(elementsFromTextFile[j]);
                            j++;
                        }

                        currentElement.append("}");
                    } else if (elementsFromTextFile[j].equals("(")) {
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

                    // Store only first three characters
                    this.board[i][columnIndex] = currentElement.substring(0, Math.min(3, currentElement.length()));

                    columnIndex++; // Move to next column index
                    j++; // Move to next character
                }
                i++; // Move to next row
            }
        } catch (IOException e) {
            e.printStackTrace(); // TODO Write messages/code to Handle IOException appropriately
        }

        // Now that initialized, Print this game instances' loaded custom board, then prompt user to select open or closed game.
        System.out.println(this);
        gameConfig.gameInPlay(); // Jump to GamePlay class, gameInPlay() method.
    }


    /** setElement(): Method for overwriting elements (tiles) onto the board, on x or y axis.*/
    public String setElement(int row, int col, String value) {
        if (isValidIndex(row, col) && board != null) {
            board[row][col] = value; // Update the board element with the value
            return value; // (Optional) return the updated value

        } else {
            return null; // (Optional) return null for invalid index or null board
        }
    }



    // placeWordOnBoard() : Responsible for taking input from a human player (a word and its direction),
    // parsing it, and placing the word onto the current instances' game board accordingly.
    public void placeWordOnBoard(GamePlay gamePlay, HumanPlayer humanPlayer) throws IOException {
        String wordAndDirection = humanPlayer.enterWordAndDirection(gamePlay);
        if (wordAndDirection == null) {
            // Handles passing turn, for example, if user enters ',' - nothing to be placed on board.
            return;
        }

        // Extract word AND direction from wordAndDirection - e.g., doG,4C
        String[] twoParts = wordAndDirection.split(",");
        String word = twoParts[0].trim();
        String direction = twoParts[1].trim();

        // Split the word into characters and puts them into an array. - e.g., d,o,G
        String[] wordAsArray = word.split("");

        // Variables to track row and column based on direction e.g., 4C is row 4, and C is column C.
        int row = 0;
        int col = 0;

        // TODO Logic based on direction - need to work on
        if (direction.equalsIgnoreCase("vertical")) {
        } else if (direction.equalsIgnoreCase("horizontal")) {
            // Update col for each letter, row stays the same
            col++; // Initial offset for horizontal placement (we can adjust if needed)
        } else {
            // Handle invalid direction (possibly throw exception or display error)
            return;
        }

        // Loop through each character and update the board
        for (int i = 0; i < wordAsArray.length; i++) {
            String letter = wordAsArray[i];
            setElement(row, col, letter); // Update board using setElement() method
            if (direction.equalsIgnoreCase("vertical")) {
                row++;
            } else {
                col++;
            }
        }
    }


// The setRow() method utilizes System.arraycopy() to copy characters from the 'values' array (word letter characters extracted from the input string)
// into positions on the array. For example, given 'DiNT, H4', the 'D' would be placed in row 4, column H.
    public void setRow(int row, String string) {
        try {
            String[] values = string.split("");
            if (values.length == board[0].length) {
                System.arraycopy(values, 0, board[row], 0, values.length);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid format in the input string. Make sure all characters in the string are valid.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Invalid row index or the input string does not match the board dimensions.");
            e.printStackTrace();
        }
    }

    // toString(): Override Method for printing the current state of the board.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Print alphabetic board TOP column headers based on size (e.g., a-p if board size is 16).
        printColumnHeaders(builder);

        // Print the board content with even spacing
        printBoardContent(builder);

        // Print BOTTOM alphabetic board column headers
        printColumnHeaders(builder);

        return builder.toString();
    }
    private void printColumnHeaders(StringBuilder builder) {
        builder.append("      "); // Add an extra space to align with elements
        for (int i = 1; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i -1);
            builder.append(String.format("%-4s", columnHeader)); // Adjust the formatting

        }
        builder.append("\n");
    }
    private void printBoardContent(StringBuilder builder) {
        for (int i = 1; i < board.length; i++) {
            builder.append(String.format("%-5d", i + 1)); // Print row number
            for (int j = 1; j < board[i].length; j++) {
                builder.append(String.format("%-4s", board[i-1][j-1])); // Adjust the formatting
            }
            builder.append(String.format("%-5d\n", i + 1)); // Print row number at the end of the row
        }
    }


    // start() A clean method for main method to call to start game. Also, may implement a while (!game.isGameOver() loop.
    public void start() throws IOException {
        //  introHeader(); // Undo later when things are working.
        createTheBoard();
    }

    // Helper Methods: **Internal Use Only** These methods provide utility functions
    // for code writing and debugging, and are not intended for game play logic.
    // ______________________________________________________________________________


    // isValidIndex() Helper method to ensure user-provided coordinates for accessing elements
    // in the board array are within the valid range.
    protected boolean isValidIndex(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }




    /**
     * boardSizeDimensions This boardSize data structure is ONLY used to determine the board size for the GamePlay class,
     * so that horizontal and vertical words can be corrcctly read onto the board.
     **/
    public Map<Character, Integer> boardSizeDimensions() {
        Map<Character, Integer> boardSize = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            boardSize.put(c, c - 'A' + 1);
        }
        return boardSize;
    }

    public int currentGameBoardSize() {
        return currentGameBoardSize;
    }
}



