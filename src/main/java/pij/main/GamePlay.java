package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// In-Game AI and Logic
public class GamePlay {
    Scanner scanner = new Scanner (System.in);
    public TileBag tileBag;
    public  HumanPlayer humanPlayer;
    public  ComputerPlayer computerPlayer;
    private static final String WORD_LIST = "src/resources/wordlist.txt";

    public GamePlay() {

        tileBag = new TileBag();
        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);

        humanPlayer.intializePlayerTileRack();
        computerPlayer.intializePlayerTileRack();

//        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.

        humanPlayer.printTileRack("Your Tiles: ");
        computerPlayer.printTileRack("Computer's Tiles: ");

//        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.

    }

    public void enterWordAndTile() {
        while (true) {
            System.out.print("Please enter your move in the format: \"word,square\"\n" +
                    "For example, for suitable tile rack and board configuration, a downward movecould\n" +
                    "be HI,f4 and a rightward move could be HI,4f.\n>> ");

            String input = scanner.nextLine();

            String[] strings = input.split(",");

            if (strings.length != 2) {
                System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                continue; // Restart the loop to prompt the user again
            }

            String word = strings[0].trim();
            String tile = strings[1].trim().toUpperCase();

            // Check if the first part is a word
            if (!word.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input. The first part must be a word.");
                continue;
            }

            // Check if the second part is in the correct format
            if (!tile.matches("[a-zA-Z]\\d+")) {
                System.out.println("Invalid input. The second part must contain one letter and one integer.");
                continue;
            }

            System.out.println("Entered word: " + word);
            System.out.println("Entered tile: " + tile);
            break; // Exit the loop as valid input is received
        }
        scanner.close();
    }



    }



