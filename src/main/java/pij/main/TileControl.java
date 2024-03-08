/**
 * This GamePlay class is the superclass for the OpenGame and ClosedGame classes.
 * My thinking is to keep a degree of seperation as per the users selection of
 * and open or closed game.
 *
 * Both the OpenGame and ClosedGame classes extend this class, and inherit
 * its methods.
 *
 * wordListChecker() Reads and prints the contents of a word list file.
 * The file path is specified as an absolute path in the method.
 * Uses a try-with-resources statement to automatically close the FileReader. *
 *
 * @throws IOException If an IO Exception occurs during file reading.
 */

package pij.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TileControl {
    private Map<Character, Integer> tileBag;
    private static final String WORDLIST_FILE_PATH = "src/resources/wordlist.txt"; // dir and rel path for wordlist text document.

    public void wordListChecker() {
        String absolutePath = WORDLIST_FILE_PATH;

        try (FileReader fileReader = new FileReader(absolutePath)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("File not found or IO Exception: " + e.getMessage());
        }
    }

    public void tileBagInit() {
        /**
         * This method initializes and sets the tile bag, for which, tiles will be distributed
         * to Human and computer.
         * Populates a HashMap with key-value pairs representing letters and their
         * associated values. The key represents a letter, and the associated value
         * represents the number of letters of that tile. i.e, A, 8 means there are
         * eight tiles of letter A in the bag.
         * initialTileBag also contains the wildcard two '_',  tiles, which i guess
         * is the same as the two 'blank' tile in the real scrabble game.

         */

        tileBag = new HashMap<>();

        tileBag.put('A', 1);  // 8 tiles in bag at start.
        tileBag.put('B', 3);  //2 tiles in bag at start.
        tileBag.put('C', 3);  //2 tiles in bag at start.
        tileBag.put('D', 2);  //4 tiles in bag at start.
        tileBag.put('E', 1); //10 tiles in bag at start.
        tileBag.put('F', 4);  //3 tiles in bag at start.
        tileBag.put('G', 2);  //4 tiles in bag at start.
        tileBag.put('H', 4);  //3 tiles in bag at start.
        tileBag.put('I', 1);  //8 tiles in bag at start.
        tileBag.put('J', 9);  //1 tiles in bag at start.
        tileBag.put('K', 6);  //1 tiles in bag at start.
        tileBag.put('L', 1);  //4 tiles in bag at start.
        tileBag.put('M', 3);  //2 tiles in bag at start.
        tileBag.put('N', 1);  //7 tiles in bag at start.
        tileBag.put('O', 1);  //7 tiles in bag at start.
        tileBag.put('P', 3);  //2 tiles in bag at start.
        tileBag.put('Q', 12);  //1 tiles in bag at start.
        tileBag.put('R', 1);  //6 tiles in bag at start.
        tileBag.put('S', 1);  //4 tiles in bag at start.
        tileBag.put('T', 1);  //6 tiles in bag at start.
        tileBag.put('U', 1);  //5 tiles in bag at start.
        tileBag.put('V', 4);  //2 tiles in bag at start.
        tileBag.put('W', 4);  //1 tiles in bag at start.
        tileBag.put('X', 9);  //1 tiles in bag at start.
        tileBag.put('Y', 5);  //2 tiles in bag at start.
        tileBag.put('Z', 11);  //1 tiles in bag at start.
        tileBag.put('_', 5);  //2 tiles in bag at start.

    }
    /**
     * The getRandomTile method grabs a random tile from the tileBag, which can tthen be
     * assigned to tileBagHuman or tileBagComputer.
     *
     * The TileRackHuman method keeps track of human (seven) tiles via an arrayList.
     * Upon calling this function, it can add a new tile from the tileBag.
     *
     * TODO - Create similar tileRackComputer
     *
     *a removeOneTile method does exactly that - removes one tile from the tileBag. used in conjuction with
     * tileRackHuman and tileRachComputer.
     *
     */
    public HashMap<Character, Integer> tileRackHuman() {
        //Generates a rack of 7 random tiles (from the tileBag) for the human player
        // by repeatedly calling a method called getRandomTile.

        HashMap<Character, Integer> rack = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            char tile = getRandomTile();
            rack.put(tile, 1); // Add tile with count 1
        }
        return rack;
    }





    private char getRandomTile() {
        // Create a list to store available tiles
        List<Character> availableTiles = new ArrayList<>();

        // Firstly, we populate the list with tiles from the tileBag
        for (Map.Entry<Character, Integer> entry : tileBag.entrySet()) {
            char tile = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                availableTiles.add(tile);
            }
        }

        // Check if there are available tiles
        if (availableTiles.isEmpty()) {
         // Return a default value or throw an exception ?
            return ' ';
        }

        // This part now selects a random tile from the available tiles
        Random random = new Random();
        int index = random.nextInt(availableTiles.size());
        char selectedTile = availableTiles.get(index);

        //Call method to remove ONE selected tile from the tileBag
        removeOneTile(selectedTile);

        return selectedTile;
    }

    public void removeOneTile(char tile) {
        //Removes a selected tile from the tileBag, AFTER it has been chosen (getRandomTile).
        if (tileBag.containsKey(tile)) {
            int count = tileBag.get(tile);
            if (count > 1) {
                tileBag.put(tile, count - 1);
            } else {
                tileBag.remove(tile);
            }
        }
    }



    public ArrayList<Character> tileRackComputer() {
        //generates a rack of 7 random tiles (from the tileBag) for the Computer player
        // by repeatedly calling a method called getRandomTile.
      ArrayList<Character> rack = new ArrayList<>();
      Random random = new Random();
        for (int i = 0; i < 7; i++) {
            char tile = getRandomTile();
            rack.add(tile);
        }
    return rack;
    }
    /**
     * This method retrieves the current count of tiles in the SkraBBKle game
     * and prints it to the console.
     * */

    // printNumberInTileBag() Helper method. Use to show current state (number) of tiles in bag.
    public void printNumberInTileBag() {
        System.out.println("\nTiles remaining in the bag: ");

        // Sort tiles alphabetically
        List<Map.Entry<Character, Integer>> tilesSorted = new ArrayList<>(tileBag.entrySet());
        tilesSorted.sort((entry1, entry2) -> Character.compare(entry1.getKey(), entry2.getKey()));

        // Print headers
        System.out.printf("%-6s | %-6s%n", "Tile", "Count");
        System.out.println("------------------");

        // Print tiles and counts
        for (Map.Entry<Character, Integer> entry : tilesSorted) {
            char tile = entry.getKey();
            int tileCount = entry.getValue();
            System.out.printf("%-6c | %-6d%n", tile, tileCount);
        }
    }


}












