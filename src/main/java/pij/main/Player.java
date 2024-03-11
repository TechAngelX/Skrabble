package pij.main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int INITIAL_NUMBER_OF_PLAYER_TILES = 7;

    private List<Tile> tileRack;
    private TileBag tileBag;

    public Player(TileBag tileBag) {
        this.tileBag = tileBag;
        this.tileRack = new ArrayList<>(); // Initialize the player's tileRack

    }

    //Initializes a rack of 7 random tiles (from the tileBag) for the human or computer player. Only to be used once.
    protected void intializePlayerTileRack() {
        for (int i = 0; i < 7; i++) {
            Tile tile = tileBag.getRandomTile();
            if (tile != null) {
                tileRack.add(tile);
            }
        }
    }

      public void printTileRack(String name) {
        System.out.print(name + ": ");
        for (Tile tile : tileRack) {
            System.out.print("[" + tile.getTileLetter() + tile.getTileValue() + "] ");
        }
        System.out.println(); // Add a new line after printing all tiles
    }
}
