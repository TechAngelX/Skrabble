package pij.main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// In-Game AI and Logic
public class GamePlay {
    private HumanPlayer humanPlayer;
    private TileBag humanTileRack;
    private ComputerPlayer computerPlayer;
    private TileBag computerTileRack;


    public GamePlay() {
     humanPlayer = new HumanPlayer(humanTileRack);
     humanTileRack = new TileBag();

     computerPlayer = new ComputerPlayer(computerTileRack);
     computerTileRack = new TileBag();


        // Create the tile racks for the human and computer players
        HashMap<Character, Integer> humanTileRackMap = humanTileRack.createTileRack();
        HashMap<Character, Integer> computerTileRackMap = computerTileRack.createTileRack();

        // Initialize players with their tile racks
        humanPlayer = new HumanPlayer(humanTileRackMap);
        computerPlayer = new ComputerPlayer(computerTileRackMap);

//        return super.createTileRack(tileBag);

    // printTileBag() A TreeMap to store counts of each tile value, sorted by tile letter

//humanPlayer.createTileRack(new TileBag())

}}