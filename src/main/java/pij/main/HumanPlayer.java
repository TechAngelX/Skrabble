package pij.main;

import java.util.HashMap;

public class HumanPlayer extends Player {

    private HashMap<Character, Integer> tileRack;

    public HumanPlayer(HashMap<Character, Integer> tileRack) {
        this.tileRack = tileRack;
    }

    // Other m

    @Override
    protected void setName(String name) {
        super.setName("humanPlayer");
    }
}






