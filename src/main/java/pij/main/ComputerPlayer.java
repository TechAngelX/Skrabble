package pij.main;

import java.util.HashMap;

public class ComputerPlayer extends Player {
    private HashMap<Character, Integer> tileRack;
    public ComputerPlayer(TileBag tileBag) {
        super(tileBag); // Call the parent class constructor (Player)
    }
    @Override
    protected void setName(String playerName) {
        super.setName("computerPlayer");
    }
}

