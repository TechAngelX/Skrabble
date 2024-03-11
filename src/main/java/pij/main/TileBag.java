package pij.main;

import java.util.*;

public class TileBag {
    private List<Tile> tileList;

    public TileBag() {
        tileList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tileList.add(new Tile('A', 1));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('B', 3));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('C', 3));
        }
        for (int i = 0; i < 4; i++) {
            tileList.add(new Tile('D', 2));
        }
        for (int i = 0; i < 10; i++) {
            tileList.add(new Tile('E', 1));
        }

        // TODO Add more tiles as needed.
    }

    public void remainingTilesInBag() {
        System.out.println("Remaining Tiles in TileBag: ");
        Map<String, Integer> numberOfKeyValueTiles = new TreeMap<>();
        for (Tile tile : tileList) {
            String tileKey = tile.getTileLetter() + Integer.toString(tile.getTileValue());
            numberOfKeyValueTiles.put(tileKey, numberOfKeyValueTiles.getOrDefault(tileKey, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : numberOfKeyValueTiles.entrySet()) {
            String tileKey = entry.getKey();
            int count = entry.getValue();
            System.out.println(count + " x [" + tileKey + "]");
        }
            }

    public Tile getRandomTile() {
        if (tileList.isEmpty()) {
            System.out.println("No more tiles in the bag. The tile bag is now empty.");
            return null; // Handle empty bag condition. Perhaps tot up score, and endGame() method.
        }

        Random random = new Random();
        int index = random.nextInt(tileList.size());
        return tileList.remove(index);
    }

}




