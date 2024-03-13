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
        for (int i = 0; i < 3; i++) {
            tileList.add(new Tile('F', 4));
        }
        for (int i = 0; i < 4; i++) {
            tileList.add(new Tile('G', 2));
        }
        for (int i = 0; i < 3; i++) {
            tileList.add(new Tile('H', 4));
        }
        for (int i = 0; i < 8; i++) {
            tileList.add(new Tile('I', 1));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('J', 9));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('K', 6));
        }
        for (int i = 0; i < 4; i++) {
            tileList.add(new Tile('L', 1));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('M', 3));
        }
        for (int i = 0; i < 7; i++) {
            tileList.add(new Tile('N', 1));
        }
        for (int i = 0; i < 7; i++) {
            tileList.add(new Tile('O', 1));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('P', 3));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('Q', 12));
        }
        for (int i = 0; i < 6; i++) {
            tileList.add(new Tile('R', 1));
        }
        for (int i = 0; i < 4; i++) {
            tileList.add(new Tile('S', 1));
        }
        for (int i = 0; i < 6; i++) {
            tileList.add(new Tile('T', 1));
        }
        for (int i = 0; i < 5; i++) {
            tileList.add(new Tile('U', 1));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('V', 4));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('W', 4));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('X', 9));
        }
        for (int i = 0; i < 2; i++) {
            tileList.add(new Tile('Y', 5));
        }
        for (int i = 0; i < 1; i++) {
            tileList.add(new Tile('Z', 11));
        }
        for (int i = 0; i < 5; i++) {
            tileList.add(new Tile('_', 5)); // Wildcard
        }
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




