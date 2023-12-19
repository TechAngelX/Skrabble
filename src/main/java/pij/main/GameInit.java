
/**
 * The GameInit class is responsible for initializing and configuring the SkraBBKle game.
 * It provides methods for displaying the game's intro header, configuring the game board
 * (prompting user to load a board file, or select the default file), and opening the game
 * with the computer's tiles.
 * <p>
 * To initiate the game, create an instance of this class and call the appropriate methods.
 * Usage Example for the Main.java class:
 * GameInit gameInit = new GameInit();
 * gameInit.intro_Header();
 * gameInit.board_Config();
 */

package pij.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GameInit {
    private String boardType;

    public void intro_Header() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    public void board_Config() {
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");
        try (Scanner scanner = new Scanner(System.in)) {

            String boardType;
            while (true) {

                //formats the string to lowercase and first character:
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
        System.out.println("loadboard");
        System.out.print("Please enter the filename of the board: ");

        // TODO - input validation
    }

    public void defBoard() {
        String absolutePath = "/resources/defaultBoard.txt";

        try (FileReader fileReader = new FileReader(absolutePath)) {
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


