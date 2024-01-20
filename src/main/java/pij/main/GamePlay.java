/**
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class GamePlay {
    private HashMap<Character, Integer> humanTiles;

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

    public void initialTileBag() {
        /**
         * This method initializes the tile bag for the human player.
         * Populates a HashMap with key-value pairs representing letters and their
         * associated values. The key represents a letter, and the associated value
         * represents the number of letters of that tile. i.e, A, 8 means there are
         * eight tiles of letter A in the bag.
         * initialTileBag also contains the wildcard two '_',  tiles, which i guess
         * is the same as the two 'blank' tile in the real scrabble game.

         */

        humanTiles = new HashMap<>();

        humanTiles.put('A', 8);  // value is worth 1 point
        humanTiles.put('B', 2);  // value is worth 3 points
        humanTiles.put('C', 2);  // value is worth 3 points
        humanTiles.put('D', 4);  // value is worth 2 points
        humanTiles.put('E', 10); // value is worth 1 point
        humanTiles.put('F', 3);  // value is worth 4 points
        humanTiles.put('G', 4);  // value is worth 2 points
        humanTiles.put('H', 3);  // value is worth 4 points
        humanTiles.put('I', 8);  // value is worth 1 point
        humanTiles.put('J', 1);  // value is worth 9 points
        humanTiles.put('K', 1);  // value is worth 6 points
        humanTiles.put('L', 4);  // value is worth 4 points
        humanTiles.put('M', 2);  // value is worth 3 points
        humanTiles.put('N', 7);  // value is worth 1 point
        humanTiles.put('O', 7);  // value is worth 1 point
        humanTiles.put('P', 2);  // value is worth 3 points
        humanTiles.put('Q', 1);  // value is worth 12 points
        humanTiles.put('R', 6);  // value is worth 1 point
        humanTiles.put('S', 4);  // value is worth 1 point
        humanTiles.put('T', 6);  // value is worth 1 point
        humanTiles.put('U', 5);  // value is worth 1 point
        humanTiles.put('V', 2);  // value is worth 4 points
        humanTiles.put('W', 1);  // value is worth 4 points
        humanTiles.put('X', 1);  // value is worth 9 points
        humanTiles.put('Y', 2);  // value is worth 5 points
        humanTiles.put('Z', 1);  // value is worth 11 points
        humanTiles.put('_', 2);  // value is worth 5 points


    }

    public void tileRackHuman() {
//        Set <int>

    }

    public void tileRackComputer() {

    }

    public Integer getTile(Character tileLetter) {
        return humanTiles.get(tileLetter);
    }


//    public static int computeScore(String word) {
//        int sum = 0;
//        for(int i = 0; i <word.length();i++) {
//            //look up the current char in the alphabet and add it's value to sum
//            sum += alphabet.get(word.charAt(i));
//        }
//        return sum;
//
//    }


}


