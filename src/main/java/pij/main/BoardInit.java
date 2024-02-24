/**
 * The GameInit class is responsible for initializing and configuring the SkraBBKle game.
 * It provides methods for displaying the game's intro header, configuring the game board
 * (prompting user to load a board file, or select the default file), and opening the game
 * with the computer's tiles.
 * <p>
 * To initiate the game, create an instance of this class and call the appropriate methods.
 * Usage Example for the Main.java class:
 * BoardInit boardInit = new BoardInit();
 * gameInit.intro_Header();
 * gameInit.board_Config();
 */

package pij.main;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BoardInit {
    private static final String DEFAULT_BOARD_PATH = "src/resources/defaultBoard.txt";
    private String boardType;
    private static final int ROWS = 16;
    private static final int COLUMNS = 16;

    public void intro_Header() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    private String setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your name: ");
        String userInputName = scanner.nextLine().trim(); // Trim input (anything after first string)

        // If user input is empty, (if user just presses Enter, return "Human Player"
        if (userInputName.isEmpty()) {
            return "Human Player";
        }
        // If he input contains a whitespace character, extract the first word
        int whiteSpaceIndex = userInputName.indexOf(" ");
        if (whiteSpaceIndex != -1) {
            userInputName = userInputName.substring(0, whiteSpaceIndex);
        }

        // Now Convert the first word to sentence case
        String firstWordSentnceCase = userInputName.substring(0, 1).toUpperCase() + userInputName.substring(1).toLowerCase();

        return firstWordSentnceCase;
    }
    public void boardConfig() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String playerName = setPlayerName(); // sets playerName as a string from the setPlayerName method

        System.out.print("Hello " + playerName + ". Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");

        String userChoice;
        while (true) {
            userChoice = scanner.nextLine().toLowerCase();
            if (userChoice.equals("l") || userChoice.equals("d")) {
                break;
            } else {
                System.out.print("Invalid entry. Please enter your choice (l/d): ");
            }
        }

        if (userChoice.equals("l")) {
            // Handle user-loaded board (not shown here)
        } else {
            defBoard();
        }
    }
    public void loadBoard(String filename) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }

        Scanner scanner = new Scanner(inputStream);
        int size = scanner.nextInt();
        board = new char[size][size];

        scanner.nextLine(); // Skip the size line

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                board[row][col] = line.charAt(col);
            }
        }
        scanner.close();
    }
    private char[][] board;
    public String[][] defBoard() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH))) {   // Keep this exact path reference.
            List<List<String>> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> row = new ArrayList<>();
                int start = 0;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '.' || c == '(' || c == ')' || c == '{') {
                        // Check if there are characters before the delimiter
                        if (i > start) {
                            row.add(line.substring(start, i));
                        }

                        // Add the delimiter itself as a separate cell
                        row.add(String.valueOf(c));

                        if (c == '{') {
                            // Extract the entire content within {} as a single cell
                            int endIndex = line.indexOf('}', i + 1);
                            if (endIndex != -1) {
                                row.add(line.substring(start + 1, endIndex + 1));
                                i = endIndex; // Skip to the closing brace
                            } else {
                                System.err.println("Warning: Unclosed '{' at position " + i + " in the file.");
                            }
                        }

                        start = i + 1;
                    } else {
                        // Handle the remaining non-delimiter characters as one cell
                        if (i == start) {
                            // Single character, add it directly
                            row.add(String.valueOf(c));
                        } else if (i > start + 1) {
                            // Multiple characters, treat as one cell
                            row.add(line.substring(start, i));
                        }
                        start = i + 1;
                    }
                }

                // Add the last element (if any)
                if (start < line.length()) {
                    row.add(line.substring(start));
                }

                // Handle empty rows
                if (row.isEmpty()) {
                    System.err.println("Warning: Skipping empty line in file.");
                    continue;
                }

                rows.add(row);
            }

            // Convert rows to a 2D array of strings
            String[][] board = new String[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                board[i] = new String[rows.get(i).size()]; // Pre-allocate correct size

                // Check for valid index before accessing elements
                if (board[i].length == 0) {
                    System.err.println("Error: Unexpected empty row in processed data.");
                    continue; // Skip to the next row or handle differently
                }

                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = rows.get(i).get(j);
                }
            }

            return board;
        }
    }


    public  void printDefaultBoard() {
        try {
            String[][] board = defBoard();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Handle file reading errors here
        }
    }






    public void openGame() {
        System.out.println("OPEN GAME: The computer's tiles:");
    }


    public void gameTypeOpenCLosed() {
        System.out.println("\nDo you want to play an _o_pen or _c_losed game?");
        System.out.println("Please enter your choice (o/c): ");

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
















}

