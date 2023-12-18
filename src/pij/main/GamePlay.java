/**
 * wordListChecker() Reads and prints the contents of a word list file.
 * The file path is specified as an absolute path in the method.
 * Uses a try-with-resources statement to automatically close the FileReader. *
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
         * Initializes the tile bag for the human player.
         * Populates a HashMap with key-value pairs representing letters and their associated values.
         * The key represents a letter, and the associated value represents the point value (score) of that letter in the game.
         * We should call typically call this method  at the beginning of a game to set up the initial tiles.
         *
         * The initialized tile bag will contain key-value pairs for letters 'A' to 'Z' with their corresponding point values (scores:
         * - 'A': 1, 'B': 3, 'C': 3, ..., 'Z': 10.
         *
         * It also contains the wildcard tile '_', which i guess is the same as the 'blank' tile in the real scrabble game.
         * Rhe '_' tile has a value of 5.
         *
         */

        humanTiles = new HashMap<>();

        humanTiles.put('A', 1);
        humanTiles.put('B', 3);
        humanTiles.put('C', 3);
        humanTiles.put('D', 2);
        humanTiles.put('E', 1);
        humanTiles.put('F', 4);
        humanTiles.put('G', 2);
        humanTiles.put('H', 4);
        humanTiles.put('I', 1);
        humanTiles.put('J', 9);
        humanTiles.put('K', 6);
        humanTiles.put('L', 1);
        humanTiles.put('M', 3);
        humanTiles.put('N', 1);
        humanTiles.put('O', 1);
        humanTiles.put('P', 3);
        humanTiles.put('Q', 12);
        humanTiles.put('R', 1);
        humanTiles.put('S', 1);
        humanTiles.put('T', 1);
        humanTiles.put('U', 1);
        humanTiles.put('V', 4);
        humanTiles.put('W', 4);
        humanTiles.put('X', 9);
        humanTiles.put('Y', 5);
        humanTiles.put('Z', 11);
        humanTiles.put('_', 5);


    }

    public void tileRackHuman(){
//        Set <int>

    }

    public void tileRackComputer(){

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


