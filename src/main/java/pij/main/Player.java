package pij.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

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
        for (int i = 0; i < 7; i++) {
            char tile = tileBag.getRandomTile(); // Assuming getRandomTile() method is accessible
            rack.put(tile, 1);
        }
        return rack;
    }

}
