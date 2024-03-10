package pij.main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// In-Game AI and Logic
public class GamePlay {
    public  HumanPlayer humanPlayer;
    public  ComputerPlayer computerPlayer;
    public GamePlay() {
        TileBag tileBag = new TileBag(); // To access some tileBag helper methods unique only to Helper class. Not for gameplay.
//        tileBag.wholeTileBag();

        humanPlayer = new HumanPlayer(tileBag);
        computerPlayer = new ComputerPlayer(tileBag);
        humanPlayer.printTileRack("Your Tiles: ");
        computerPlayer.printTileRack("Computer's Tiles: ");
//        tileBag.wholeTileBag();

    }
}