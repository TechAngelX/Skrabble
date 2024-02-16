

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BoardInit {
    private String boardType;

    public void intro_Header() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    private String setPlayerName (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your name: ");
        String userInputName = scanner.next().trim(); // Trim in case enters multiple names, i.e Carl Gustavus Theodore von Holst !

        // Convertss the first character to uppercase and the rest to lowercase
        String playerName = userInputName.substring(0, 1).toUpperCase() + userInputName.substring(1).toLowerCase();
        return playerName;
    }
    public void boardConfig() {
        Scanner scanner = new Scanner (System.in);
        String playerName = setPlayerName();
        System.out.print("Hello "+ playerName+". Would you like to _l_oad a board or use the _d_ef board?\n");
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
            loadBoard(scanner);
        } else {
            try {
                defBoard();
            } catch (IOException e) {
                System.out.println("Error reading default board file: " + e.getMessage());
            }
        }
    }
    public void loadBoard(Scanner scanner) {
        // Read the data on a player's advance board from the loadBoard file.
        // NOTE for Ricki: This method is called once in the game, then goes to gameTypeOpenClosed method.
        System.out.print("Please enter the filename of the board: ");
        String loadBoardFileName = "src/main/java/pij/resources/" + scanner.nextLine();

        String relPathDirectory = "src/main/java/pij/resources/userLoadBoard.txt";
        //TODO Logic

        System.out.println(loadBoardFileName); // just test printout to confirm path of user's loadBoard.txt file.
        // Move control flow onto next part - ask whether open or closed game
        gameTypeOpenCLosed();
    }



    // Assuming this method is within the BoardInit class in src/main/java/pij/main
    public void defBoard() throws IOException {
        String defBoardFilePath = "src/resources/defaultBoard.txt";

        try (FileReader fileReader = new FileReader(defBoardFilePath)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("File not found or IO Exception: " + e.getMessage());
        }
        // This calls my method to control flow onto next part - ask whether open or closed game
        gameTypeOpenCLosed();
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