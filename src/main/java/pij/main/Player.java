package pij.main;

import java.util.*;

public  abstract class Player {
    private Map<Character, Integer> tileRack; // Use TreeMap for sorted output
    private String name; //subclasses will be hardcoded "humanPlayer" or "computerPlayer".

    public Player(TileBag tileBag) {
        this.tileRack = tileBag.createTileRack();
        this.name = "Player";
    }
    protected void setName(String name) {
    }
    public String getName() { return name;
    }
    TileBag tileBag = new TileBag();

    public void printTileRack(String playerRack) {
        System.out.print(playerRack);
        StringBuilder tileString = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : tileRack.entrySet()) {
            char tileLetter = entry.getKey();
            int tileValue = entry.getValue();

            tileString.append("[").append(tileLetter).append(tileValue).append("] ");
        }

        System.out.println(tileString.toString().trim()); // Remove trailing space
    }


    // wholeTileBag() A TreeMap Helper to store counts of each tile value, sorted by tile letter.
    // Just to check for debugging. Not for game use.
//    public void wholeTileBag(String tileBag) {
//        System.out.println("Current contents of the whole Tile Bag:");
//
//        Map<String, Integer> tileCount = new TreeMap<>();
//
//        for (Tile tile : tileSetMap) {
//            String tileKey = tile.getTileLetter() + Integer.toString(tile.getTileValue());
//            tileCount.put(tileKey, tileCount.getOrDefault(tileKey, 0) + 1);
//        }
//
//        // Print the count of tile objects.
//        for (Map.Entry<String, Integer> entry : tileCount.entrySet()) {
//            String tileLetter = entry.getKey().substring(0, 1); // Extract the letter part
//            int tileValue = Integer.parseInt(entry.getKey().substring(1)); // Extract the value part
//
//            System.out.println(entry.getValue() + " x [" + tileLetter + tileValue + "]");
//
//        }
//    }

    }



