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
public class BoardInitOldTmp {
    private static final String DEFAULT_BOARD_PATH = "src/resources/defaultBoard.txt";
    private String boardType;
    private static final int ROWS = 16;
    private static final int COLUMNS = 16;


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
    //TODO - in hindsight, is this method really needed, or just cosmetic?

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










    public void openGame() {
        System.out.println("OPEN GAME: The computer's tiles:");
    }



















}

