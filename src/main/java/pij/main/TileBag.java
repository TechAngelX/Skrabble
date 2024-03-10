/**
 TODO - write clearer javadocs.
 */

package pij.main;

import java.util.*;

public class TileBag {
protected Map <Character, Integer> tileSetMap;
private  final int INITIAL_NUMBER_OF_PLAYER_TILES = 7;


    /** TileBag() Initializes a TileBag array (collection) with a set of tiles objects. Each object having its own
    //  letter and corresponding numerical score value.
    **/
    public TileBag() {
        tileSetMap = new HashMap<>();

        tileSetMap.put('A', 1);
        tileSetMap.put('B', 3);
        tileSetMap.put('C', 3);
        tileSetMap.put('D', 2);
        tileSetMap.put('E', 1);
        tileSetMap.put('F', 4);
        tileSetMap.put('G', 2);
        tileSetMap.put('H', 4);
        tileSetMap.put('I', 1);
        tileSetMap.put('J', 9);
        tileSetMap.put('K', 6);
        tileSetMap.put('L', 1);
        tileSetMap.put('M', 3);
        tileSetMap.put('N', 1);
        tileSetMap.put('O', 1);
        tileSetMap.put('P', 3);
        tileSetMap.put('Q', 12);
        tileSetMap.put('R', 1);
        tileSetMap.put('S', 1);
        tileSetMap.put('T', 1);
        tileSetMap.put('U', 1);
        tileSetMap.put('V', 4);
        tileSetMap.put('W', 4);
        tileSetMap.put('X', 9);
        tileSetMap.put('Y', 5);
        tileSetMap.put('Z', 11);
        tileSetMap.put('_', 5);

    }


    //Generates a rack of 7 random tiles (from the tileBag) for the Human or Computer player.
    // Pulls it out of bag using getRandomTile() method, and decrements tilebag. This Method called only once.
    public Map<Character, Integer> createTileRack() {
        TreeMap<Character, Integer> rack = new TreeMap<>(); //  The tile rack's data structure.
        for (int i = 0; i < INITIAL_NUMBER_OF_PLAYER_TILES; i++) {
            char tile = getRandomTile();

            rack.put(tile, 1);
        }
        return rack;
    }


    // Gets random tile from tilebag.  Should also remove from tileBag. TODO.
    public char getRandomTile() {
        Map<Character, Integer> availableTilesInBag = new TreeMap<>(tileSetMap); // Copy tileSetMap to availableTilesInBag

        // Check if there are available tiles
        if (availableTilesInBag.isEmpty()) {
            System.out.println("No more tiles in the bag. The tile bag is now empty.");
            return ' '; // TODO Move to tally up scores and create an Endgame() method.
        }

        // Select a random entry (key-value pair) from the available tiles
        Random random = new Random();
        int index = random.nextInt(availableTilesInBag.size());
        Map.Entry<Character, Integer> selectedEntry = (Map.Entry<Character, Integer>) availableTilesInBag.entrySet().toArray()[index];

        // Retrieve the selected tile character and its score
        char selectedTile = selectedEntry.getKey();
        int tileScore = selectedEntry.getValue();

        // Print the selected tile and its score

        // Remove the selected tile from the bag
        removeOneTile(selectedTile);
        return selectedTile;
    }


    private void removeOneTile(char tile) {
        // Update the count of the selected tile
        tileSetMap.put(tile, tileSetMap.get(tile) - 1);

        // Remove the tile if count becomes 0
        if (tileSetMap.get(tile) <= 0) {
            tileSetMap.remove(tile);
        }

    //Generates a rack of 7 random tiles (from the tileBag) for the human player
    // by repeatedly calling a method called getRandomTile.






    }}




















