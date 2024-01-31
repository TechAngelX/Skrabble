

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

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BoardInit {
    private String boardType;

    public void intro_Header() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    public void boardConfig() {
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");
        try (Scanner scanner = new Scanner(System.in)) {
            String boardType;
            while (true) {

                //Converts the inputted string to lowercase, and takes the first character:
                boardType = scanner.nextLine().toLowerCase().substring(0, 1);

                    if (boardType.equals("l") || (boardType.equals("d"))) {
                        if (boardType.equals("l")) {
                        loadBoard();
                    } else {
                        defBoard();
                    }
                    break;
                } else {
                    System.out.print("Invalid Entry. Please enter your choice (only 'l' or 'd'): ");
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid entry.");
        }
    }

    public void loadBoard() {
        String relPathDirectory = "src/main/java/pij/resources/userLoadBoard.txt";


        System.out.print("Please enter the filename of the board: ");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        String loadBoardFileName = ("src/main/java/pij/resources/"+tmp+".txt");

        System.out.println(loadBoardFileName);

    }

    public void defBoard() {

        String relPathDirectory = "src/main/java/pij/resources/defaultBoard.txt";

        try (FileReader fileReader = new FileReader(relPathDirectory)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("File not found or IO Exception: " + e.getMessage());
        }
    }

    public void openGame() {
        System.out.println("OPEN GAME: The computer's tiles:");
    }
}


