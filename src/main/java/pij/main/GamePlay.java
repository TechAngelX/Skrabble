package pij.main;

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
        System.out.print("Please enter your move in the format: \"word,square\"\n" +
                "For example, for suitable tile rack and board configuration, a downward movecould\n" +
                "be HI,f4 and a rightward move could be HI,4f.\t>> ");

        String input = scanner.nextLine();

        String[] strings = input.split(",");

        if (strings.length != 2) {
            System.out.println("Invalid input format. Please enter in the format \"word,square\"");
            return;
        }

        String word = strings[0].trim();
        String tile = strings[1].trim().toUpperCase();

        // TODO - Maybe Create a map (optional, if needed?)
        // Map<String, String> tileEntry = new HashMap<>();
        // tileEntry.put("word", word);
        // tileEntry.put("tile", tile);

        System.out.println("Entered word: " + word);
        System.out.println("Entered tile: " + tile);

        scanner.close();

    }


    }



