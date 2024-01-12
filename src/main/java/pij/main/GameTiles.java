package pij.main;

import java.util.HashMap;
import java.util.Map;
public class GameTiles {
    private Map<String, Integer> tileBagSort;

    public GameTiles() {
         tileBagSort = new HashMap<>();
         initTileBag();;
    }
    private void initTileBag(){
        tileBagSort.put("A1", 8);
        tileBagSort.put("B3", 2);
        tileBagSort.put("C3", 2);
        tileBagSort.put("D2", 4);
        tileBagSort.put("E1", 10);
        tileBagSort.put("F4", 3);
        tileBagSort.put("G2", 4);
        tileBagSort.put("H4", 3);
        tileBagSort.put("I1", 8);
        tileBagSort.put("J9", 1);
        tileBagSort.put("K6", 1);
        tileBagSort.put("L1", 4);
        tileBagSort.put("M3", 2);
        tileBagSort.put("N7", 7);
        tileBagSort.put("O1", 7);
        tileBagSort.put("P3", 2);
        tileBagSort.put("Q12", 1);
        tileBagSort.put("R1", 6);
        tileBagSort.put("S1", 4);
        tileBagSort.put("T1", 6);
        tileBagSort.put("U1", 5);
        tileBagSort.put("V4", 2);
        tileBagSort.put("W4", 1);
        tileBagSort.put("X9", 1);
        tileBagSort.put("Y5", 2);
        tileBagSort.put("Z11", 1);


    }
}
