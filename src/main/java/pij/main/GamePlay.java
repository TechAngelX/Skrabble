package pij.main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// In-Game AI and Logic
public class GamePlay {
    public final HumanPlayer humanPlayer;
    private final TileBag humanTileRack;
    private final ComputerPlayer computerPlayer;
    private final TileBag computerTileRack;


    public GamePlay() {
        humanTileRack = new TileBag();
        computerTileRack = new TileBag();

        // Create the tile racks for the human and computer players
        HashMap<Character, Integer> humanTileRackMap = humanTileRack.createTileRack();
        HashMap<Character, Integer> computerTileRackMap = computerTileRack.createTileRack();

        // Initialize players with their tile racks
        humanPlayer = new HumanPlayer(humanTileRackMap);
        computerPlayer = new ComputerPlayer(computerTileRackMap);
        humanTileRack.printTileRack("Your Tiles: ");
//        computerTileRack.printTileRack(OPEN G);

      //    return super.createTileRack(tileBag);

        // printTileBag() A TreeMap to store counts of each tile value, sorted by tile letter

//humanPlayer.createTileRack(new TileBag())

    }
}