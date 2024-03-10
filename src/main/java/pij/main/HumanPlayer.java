package pij.main;

import java.util.HashMap;

public class HumanPlayer extends Player {

    @Override
    protected void setName(String human) {
        super.setName("humanPlayer");
    }
    @Override
    public HashMap<Character, Integer> createTileRack(TileBag tileBag) {
        return super.createTileRack(tileBag);
    }
}

