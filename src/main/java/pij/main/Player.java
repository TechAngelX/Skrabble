package pij.main;

import java.util.*;

public class Player {

    private HashMap<Character, Integer> tileRack;

    private String name; //subclasses will be hardcoded "humanPlayer" or "computerPlayer".
    public Player() {
        this.name = name;
    }
    protected void setName(String human) {
    }
    public String getName() { return name;
    }
    TileBag tileBag = new TileBag();
    public HashMap<Character, Integer> createTileRack(TileBag tileBag) {
        HashMap<Character, Integer> rack = new HashMap<>();
        tileRack = new HashMap<>(); // Initialize the tileRack to prevent null pointer exceptions.

        for (int i = 0; i < 7; i++) {
            char tile = tileBag.getRandomTile(); // Assuming getRandomTile() method is accessible
            rack.put(tile, 1);
        }
        return rack;
    }
    public void printTileRack(String playerRack) {

        System.out.println("Tile Rack:");
        for (Map.Entry<Character, Integer> entry : tileRack.entrySet()) {
            char tileLetter = entry.getKey();
            int tileCount = entry.getValue();
            System.out.println(tileCount + " x [" + tileLetter + "]");
        }
    }

    // printTileBag() A TreeMap to store counts of each tile value, sorted by tile letter

    }



