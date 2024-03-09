/**
 TODO - write clearer javadocs.
 */

package pij.main;

import java.util.*;

public class TileBag {
    private List<Tile> tileSetArray; // Used to store instances of the Tile class.


    /** TileBag() Initializes a TileBag array (collection) with a set of tiles objects. Each object having its own
    //  letter and corresponding numerical score value.
    **/
    public TileBag() {
        tileSetArray = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            tileSetArray.add(new Tile('A', 1));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('B', 3));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('C', 3));
        }
        for (int i = 0; i <4 ; i++) {
            tileSetArray.add(new Tile('D', 2));
        }
        for (int i = 0; i <10 ; i++) {
            tileSetArray.add(new Tile('E', 1));
        }
        for (int i = 0; i <3 ; i++) {
            tileSetArray.add(new Tile('F', 4));
        }
        for (int i = 0; i <4 ; i++) {
            tileSetArray.add(new Tile('G', 2));
        }

        for (int i = 0; i <3 ; i++) {
            tileSetArray.add(new Tile('H', 4));
        }
        for (int i = 0; i <8 ; i++) {
            tileSetArray.add(new Tile('I', 1));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('J', 9));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('K', 6));
        }
        for (int i = 0; i <4 ; i++) {
            tileSetArray.add(new Tile('L', 1));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('M', 3));
        }
        for (int i = 0; i <7 ; i++) {
            tileSetArray.add(new Tile('N', 1));
        }
        for (int i = 0; i <7 ; i++) {
            tileSetArray.add(new Tile('O', 1));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('P', 3));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('Q', 12));
        }
        for (int i = 0; i <6 ; i++) {
            tileSetArray.add(new Tile('R', 1));
        }
        for (int i = 0; i <4 ; i++) {
            tileSetArray.add(new Tile('S', 1));
        }
        for (int i = 0; i <6 ; i++) {
            tileSetArray.add(new Tile('T', 1));
        }
        for (int i = 0; i <5 ; i++) {
            tileSetArray.add(new Tile('U', 1));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('V', 4));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('W', 4));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('X', 9));
        }
        for (int i = 0; i <2 ; i++) {
            tileSetArray.add(new Tile('Y', 5));
        }
        for (int i = 0; i <1 ; i++) {
            tileSetArray.add(new Tile('Z', 11));
        }
        for (int i = 0; i <5 ; i++) {
            tileSetArray.add(new Tile('_', 5));
        }

    }

    //Generates a rack of 7 random tiles (from the tileBag) for the human player
    // by repeatedly calling a method called getRandomTile.
    public HashMap<Character, Integer> tileRackHuman() {
        HashMap<Character, Integer> rack = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            char tile = getRandomTile();
            rack.put(tile, 1);
        }
        return rack;
    }


    // Gets random tile from tilebag.  Should also remove from tileBag. TODO.
    private char getRandomTile() {
        List<Character> availableTiles = new ArrayList<>();
        for (Tile tile : tileSetArray) {
            availableTiles.add(tile.getTileLetter());
        }
        // Check if there are available tiles
        if (availableTiles.isEmpty()) {
            return ' '; // TODO Return a default value or throw an exception
        }

        // Select a random tile from the available tiles
        Random random = new Random();
        int index = random.nextInt(availableTiles.size());
        char selectedTile = availableTiles.get(index);

        // Remove the selected tile from the bag
        removeOneTile(selectedTile);
        return selectedTile;
    }

    private void removeOneTile(char tile) {
        for (Tile t : tileSetArray) {
            if (t.getTileLetter() == tile) {
                if (t.getTileValue() > 1) {
                    t.setCount(t.getTileValue() - 1);
                } else {
                    tileSetArray.remove(t);
                }
                break;
            }
        }
    }

    public void printTileBag() {
        System.out.println("Tile Bag:");

        // Create a map to store counts of each tile value
        Map<String, Integer> tileCounts = new HashMap<>();

        for (Tile tile : tileSetArray) { //Iterates over a collection of tile objects stored in tileSetArray.
            String tileKey = tile.getTileLetter() + Integer.toString(tile.getTileValue());
            tileCounts.put(tileKey, tileCounts.getOrDefault(tileKey, 0) + 1);
        }

        // Print the count of tile objects.
        for (Map.Entry<String, Integer> entry : tileCounts.entrySet()) {
            String tileLetter = entry.getKey().substring(0, 1); // Extract the letter part
            int tileValue = Integer.parseInt(entry.getKey().substring(1)); // Extract the value part

            System.out.println(entry.getValue() + " x [" + tileLetter + tileValue + "]");

        }
    }


}















