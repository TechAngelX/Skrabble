/**
 TODO - write clearer javadocs.
 */

package pij.main;

import java.util.*;

public class TileBag {
private Map <Character, Integer> tileSetMap;


    /** TileBag() Initializes a TileBag array (collection) with a set of tiles objects. Each object having its own
    //  letter and corresponding numerical score value.
    **/
    public TileBag() {
        tileSetMap = new HashMap<>();

        tileSetMap.put('A', 8);
        tileSetMap.put('B', 2);
        tileSetMap.put('C', 2);
        tileSetMap.put('D', 4);
        tileSetMap.put('E', 10);
        tileSetMap.put('F', 3);
        tileSetMap.put('G', 4);
        tileSetMap.put('H', 3);
        tileSetMap.put('I', 8);
        tileSetMap.put('J', 1);
        tileSetMap.put('K', 1);
        tileSetMap.put('L', 4);
        tileSetMap.put('M', 2);
        tileSetMap.put('N', 7);
        tileSetMap.put('O', 7);
        tileSetMap.put('P', 2);
        tileSetMap.put('Q', 1);
        tileSetMap.put('R', 6);
        tileSetMap.put('S', 4);
        tileSetMap.put('T', 6);
        tileSetMap.put('U', 5);
        tileSetMap.put('V', 2);
        tileSetMap.put('W', 1);
        tileSetMap.put('X', 1);
        tileSetMap.put('Y', 2);
        tileSetMap.put('Z', 1);
        tileSetMap.put('_', 5);
    }


    //Generates a rack of 7 random tiles (from the tileBag) for the Human or Computer player.
    // Pulls it out of bag using getRandomTile() method, and decrements tilebag. This Method called only once.
    public Map<Character, Integer> createTileRack() {
        TreeMap<Character, Integer> rack = new TreeMap<>();
        for (int i = 0; i < 7; i++) {
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

        // Select a random tile from the available tiles
        Random random = new Random();
        int index = random.nextInt(availableTilesInBag.size());
        char selectedTile = (char) availableTilesInBag.keySet().toArray()[index]; // Get random key from the map

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




















