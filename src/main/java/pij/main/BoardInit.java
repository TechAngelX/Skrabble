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
    public class BoardLoader {

        private static final String FILE_PATH = "src/resources/defaultBoard.txt";

        public static char[][] defBoard() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            int rows = 0;
            int cols = 0;

            // Determine the dimensions of the board
            while ((line = reader.readLine()) != null) {
                rows++;
                cols = Math.max(cols, line.length());
            }
            reader.close();

            // Create the 2D array
            char[][] board = new char[rows][cols];

            // Re-read the file and fill the array
            reader = new BufferedReader(new FileReader(FILE_PATH));
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    board[row][col] = line.charAt(col);
                }
                row++;
            }
            reader.close();

            return board;
        }

        public  void printDefaultBoard(char[][] board) {
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
            }
        }
    }

    private char[][] board;
    public  char[][] defBoard() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH)); // Keep this exact path reference.
        String line;
        int rows = ROWS;
        int cols = COLUMNS;

        // Determine the dimensions of the board
        while ((line = reader.readLine()) != null) {
            rows++;
            cols = Math.max(cols, line.length());
        }
        reader.close();

        // Create the 2D array
        char[][] board = new char[rows][cols];

        // Re-read the file and fill the array
        reader = new BufferedReader(new FileReader(DEFAULT_BOARD_PATH));
        int row = 0;
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                board[row][col] = line.charAt(col);
            }
            row++;
        }
        reader.close();

        return board;
    }

    public void openGame() {
        System.out.println("OPEN GAME: The computer's tiles:");
    }

    public  void printDefaultBoard() {
        try {
            char[][] board = defBoard();
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

