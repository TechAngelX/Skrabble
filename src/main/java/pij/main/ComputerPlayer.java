package pij.main;

import java.util.HashMap;

public class ComputerPlayer extends Player {


    private HashMap<Character, Integer> tileRack;

    public ComputerPlayer(HashMap<Character, Integer> tileRack) {
        this.tileRack = tileRack;
    }

    @Override
    protected void setName(String playerName) {
        super.setName("computerPlayer");
    }
}

