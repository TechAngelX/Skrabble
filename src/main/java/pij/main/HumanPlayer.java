package pij.main;
import pij.main.TileBag;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HumanPlayer extends Player {
//    private Map<Character, Integer> tileRack;

    public HumanPlayer(TileBag tileBag) {
        super(tileBag); // Call the parent class constructor (Player)
    }

    @Override
    public void printTileRack(String playerRack) {
        super.printTileRack(playerRack); // Call the parent class method
    }

    @Override
    protected void setName(String name) {
        super.setName("humanPlayer");
    }
}






