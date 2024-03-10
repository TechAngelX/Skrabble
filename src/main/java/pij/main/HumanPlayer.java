package pij.main;
import pij.main.TileBag;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HumanPlayer extends Player {

    private Map<Character, Integer> tileRack;


    public HumanPlayer() {
        super(new TileBag()); // Call the parent class constructor (Player)

//       if (this.tileRack != null) {
//           this.tileRack = new TileBag().createTileRack();
//        } else {
            // Handle the case where tileRack is not yet initialized (optional)

    }


    @Override
    protected void setName(String name) {
        super.setName("humanPlayer");
    }
}






