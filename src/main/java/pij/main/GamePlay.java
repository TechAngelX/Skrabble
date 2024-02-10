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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlay {
    private Map<Character, Integer> tileBag;

    public void wordListChecker() {
        String absolutePath = "/Users/xeon2035/Library/Mobile Documents/com~apple~CloudDocs/UniWerk/PROJECT-PIJ/resources/wordlist.txt";

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

        tileBag.put('A', 8);  // value is worth 1 point
        tileBag.put('B', 2);  // value is worth 3 points
        tileBag.put('C', 2);  // value is worth 3 points
        tileBag.put('D', 4);  // value is worth 2 points
        tileBag.put('E', 10); // value is worth 1 point
        tileBag.put('F', 3);  // value is worth 4 points
        tileBag.put('G', 4);  // value is worth 2 points
        tileBag.put('H', 3);  // value is worth 4 points
        tileBag.put('I', 8);  // value is worth 1 point
        tileBag.put('J', 1);  // value is worth 9 points
        tileBag.put('K', 1);  // value is worth 6 points
        tileBag.put('L', 4);  // value is worth 4 points
        tileBag.put('M', 2);  // value is worth 3 points
        tileBag.put('N', 7);  // value is worth 1 point
        tileBag.put('O', 7);  // value is worth 1 point
        tileBag.put('P', 2);  // value is worth 3 points
        tileBag.put('Q', 1);  // value is worth 12 points
        tileBag.put('R', 6);  // value is worth 1 point
        tileBag.put('S', 4);  // value is worth 1 point
        tileBag.put('T', 6);  // value is worth 1 point
        tileBag.put('U', 5);  // value is worth 1 point
        tileBag.put('V', 2);  // value is worth 4 points
        tileBag.put('W', 1);  // value is worth 4 points
        tileBag.put('X', 1);  // value is worth 9 points
        tileBag.put('Y', 2);  // value is worth 5 points
        tileBag.put('Z', 1);  // value is worth 11 points
        tileBag.put('_', 2);  // value is worth 5 points

    }

//        public List<Character> tileRackHiman(){
//        List<Character> tileRackHuman;
//    }

    public void tileRackComputer() {
    }
    /**
     * This method retrieves the current count of tiles in the SkraBBKle game
     * and prints it to the console.
     * */
    public void printNumberInTileBag() {

        System.out.println("\nTiles remaining in the bag:  (Letter / Number Count of that letter)");


        // Sort tiles alphabetically
        List<Map.Entry<Character, Integer>> tilesSorted = new ArrayList<>(tileBag.entrySet());
        tilesSorted.sort((entry1, entry2) -> Character.compare(entry1.getKey(), entry2.getKey()));

        // Print tiles in groups of 5 with aligned columns
        int count = 0;
        for (Map.Entry<Character, Integer> entry : tilesSorted) {
            char tile = entry.getKey();
            int tileCount = entry.getValue();
            System.out.printf("%c: %-2d\t", tile, tileCount);
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
        // Just adds a newline after the last tile if not printed in a group of 5, to neaten things up.
        if (count > 0) {
            System.out.println();
        }
    }

}












