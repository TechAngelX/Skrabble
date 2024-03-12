package pij.main;

import java.util.Scanner;

// In-Game AI and Logic
public class GamePlay {
    Scanner scanner = new Scanner (System.in);
    public TileBag tileBag;
    public  HumanPlayer humanPlayer;
    public  ComputerPlayer computerPlayer;
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
        System.out.println("Please enter your move in the format: \"word,square\"\n" +
                "For example, for suitable tile rack and board configuration, a downward move\n" +
                "could be HI,f4 and a rightward move could be HI,4f.");

        String input = scanner.nextLine();

        String[] strings = input.split(",");

        if (strings.length != 2) {
            System.out.println("Invalid input format. Please enter in the format \"word,square\"");
            return;
        }

        String word = strings[0].trim();
        String tile = strings[1].trim();

        // TODO - Maybe Create a map (optional, if needed?)
        // Map<String, String> tileEntry = new HashMap<>();
        // tileEntry.put("word", word);
        // tileEntry.put("square", square);

        System.out.println("Entered word: " + word);
        System.out.println("Entered tile: " + tile);


        scanner.close();
    }

    }



