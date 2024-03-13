package pij.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// In-Game AI and Logic
public class GamePlay {
    Scanner scanner = new Scanner (System.in);
    public TileBag tileBag;
    public  HumanPlayer humanPlayer;
    public  ComputerPlayer computerPlayer;
    private static final String WORD_LIST = "src/resources/wordlist.txt";
    BoardInit boardInit; // To access boardsize dimensions, and other Boardinit methods and constants.

    public GamePlay() throws IOException {

        tileBag = new TileBag();
        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);

        humanPlayer.intializePlayerTileRack();
        computerPlayer.intializePlayerTileRack();



        humanPlayer.printTileRack("Your Tiles: ");
        computerPlayer.printTileRack("Computer's Tiles: ");


    }

    public void enterWordAndDirection() {
        while (true) {
            System.out.print("Please enter your move in the format: \"word,square\"\n" +
                    "For example, for suitable direction rack and board configuration, a downward movecould\n" +
                    "be HI,f4 and a rightward move could be HI,4f.\n>> ");

            String input = scanner.nextLine();

            String[] strings = input.split(",");

            if (strings.length != 2) {
                System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                continue; // Restart the loop to prompt the user again
            }

            String word = strings[0].trim();
            String direction = strings[1].trim().toUpperCase();
            String enteredDirection = direction;



            // Check if the first part is a word
            if (!word.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input. The first part must be a word.");
                continue;
            }

            // Check if the second part is in the correct format

            if (!direction.matches("[a-pA-P]\\d{0,2}|1?[0-6],[a-pA-P]|1?[0-6][a-pA-P]")) {
                System.out.println("Invalid input. The second part must either contain a letter up to and including 'p' followed by up to two digits, or a number up to 16 followed by a letter up to 'p'.");
                continue;
            }


            // Check for letter/number direction, for pretty print
            if (Character.isLetter(direction.charAt(0))) {
                direction = "(Vertical)";
            } else {
                direction = "(Horizontal)";
            }

            System.out.println("Entered word: " + word);
            System.out.println("Entered direction: "+ enteredDirection+" " + direction);
            break;
        }
        scanner.close();
    }


    /** Helper Methods: Not for game play usage, but to assist with code writing/debugging.
  _________________________________________________________________________________
     */
    //        tileBag.remainingTilesInBag();; // Helper method to see how many tiles in tileBag remaining. Not for game use.

}



