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

    protected static String LOAD_BOARD_DIR_PATH = "src/resources/"; // Directory for custom board files.
    protected static final String DEFAULT_BOARD_FILE_PATH = "src/resources/defaultBoard.txt"; // dir and rel path for default board.

    protected final int MIN_BOARD_SIZE = 11;
    protected final int MAX_BOARD_SIZE = 26;
    protected  int currentGameBoardSize; // Gets board size depending on first line (integer) read from loaded custom board.

    private String[][] board;
    GamePlay gamePlay = new GamePlay();


    // BoardInit() - Initializes default board, loads default.txt data into 2D array, prints initial board.
    public BoardInit() throws IOException {
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

    // customOrDefaultBoardChooser() - prompts the user to choose loading a custom board, or use the default board.
    private void customOrDefaultBoardChooser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");

        String userBoardChoice;
        while (true) {
            userBoardChoice = scanner.nextLine().toLowerCase();
            if (userBoardChoice.equals("l") || userBoardChoice.equals("d")) {
                break;
            } else {
                System.out.print("Invalid entry. Please enter your choice (l/d): ");
            }
        }
        if (userBoardChoice.equals("l")) {
            loadCustomBoard();
        } else {
            new BoardInit();
            System.out.println(this);

        }
    }

    // loadCustomBoard() - Checks/parses filename, initializes custom board, loads filename data into 2D array, prints initial board.
    private void loadCustomBoard() throws IOException {
        String tmpCustomFilePath;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter the file name of the board: ");
            String lBoardName = scanner.nextLine().toLowerCase().replaceAll("^([^.]+).*", "$1");
            tmpCustomFilePath = LOAD_BOARD_DIR_PATH + lBoardName + ".txt";

            File file = new File(tmpCustomFilePath);
            if (file.exists() && file.isFile()) {
                break;
            } else {
                System.out.println(lBoardName + ".txt" + ", is not a valid file. ");
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(tmpCustomFilePath))) {
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
                    this.board[i][columnIndex] = currentElement.substring(0, Math.min(3, currentElement.length()));

                    columnIndex++; // Move to the next column index
                    j++; // Move to the next character
                }
                i++; // Move to the next row
            }
        } catch (IOException e) {
            e.printStackTrace(); // TODO Write messages/code to Handle IOException appropriately
        }

// Now that initialized, Print the initial loaded custom board
        System.out.println(this);

    }


    // openOrClosedGameChooser(): Prompts user to choose either an open, or closed game type.
    private void openOrClosedGameChooser() {
        System.out.println("\nDo you want to play an _o_pen or _c_losed game?");
        System.out.print("Please enter your choice (o/c): ");

        try (Scanner scanner = new Scanner(System.in)) {
            String openClosedOption;
            while (true) {
                openClosedOption = scanner.nextLine().toLowerCase().substring(0, 1);
                if (openClosedOption.equals("o") || openClosedOption.equals("c")) {
                    if (openClosedOption.equals("o")) {
                        System.out.println("Starting an open game...");



                    } else {
                        System.out.println("Starting a closed game...");

                    }
                    break;
                } else {
                    System.out.print("Invalid entry.\nPlease enter 'o' for open or 'c' for closed game: ");
                }
            }
        } catch (Exception e) {
        }
    }

    /** setElement(): Method for overwriting elements (tiles) onto the board, on x or y axis.*/
    public String setElement(int row, int col, String value) {
        if (isValidIndex(row, col) && board != null) {
            board[row][col] = value;
            return ""; // Example return value
        } else {
            return ""; // Example return value
        }
    }

    public void setRow(int row, String string) {
        try {
            String[] values = string.split("");
            if (values.length == board[0].length) {
                System.arraycopy(values, 0, board[row], 0, values.length);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(); // TODO handle exception more better/appropriately
        }
    }

    // toString(): Override Method for printing the current state of the board.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Calculate the maximum width needed for each column
        int[] maxWidths = new int[board[0].length];
        for (String[] row : board) {
            for (int j = 0; j < row.length; j++) {
                maxWidths[j] = Math.max(maxWidths[j], row[j].length());
            }
        }

        // Print alphabetic board TOP column headers based on size (e.g., a-p if board size is 16).
        builder.append("      "); // Add an extra space to align with elements
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i);
            builder.append(String.format("%-4s", columnHeader)); // Adjust the formatting
        }
        builder.append("\n");

        // Print the board content with even spacing
        for (int i = 0; i < board.length; i++) {
            builder.append(String.format("%-5d", i + 1)); // Print row number
            for (int j = 0; j < board[i].length; j++) {
                builder.append(String.format("%-4s\uFEFF", board[i][j])); // Adjust the formatting with BOM standard
            }
            // Print row headers at the end of the board
            builder.append(String.format("%-5d\n", i + 1));
        }

        // Print BOTTOM alphabetic board column headers
        builder.append("      "); // Add an extra space to align with elements
        for (int i = 0; i < board[0].length; i++) {
            char columnHeader = (char) ('a' + i);
            builder.append(String.format("%-4s", columnHeader)); // Adjust the formatting
        }
        return builder.toString();
    }




    // start() A clean method for main method to call to start game. Also, may implement a while (!game.isGameOver() loop.
    public void start() throws IOException { // Needed as loadBoard might throw exception.
//        introHeader();
        customOrDefaultBoardChooser();
        openOrClosedGameChooser();
    }


    // Helper Methods: **Internal Use Only** These methods provide utility functions
// for code writing and debugging, and are not intended for game play logic.
// ______________________________________________________________________________
    public void getCustomBoardSize() {
        System.out.println("This games current board size is: "+ currentGameBoardSize);
    }

    // isValidIndex() Helper method to ensure user-provided coordinates for accessing elements
// in the board array are within the valid range.
    private boolean isValidIndex(int row, int col) {
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
}


