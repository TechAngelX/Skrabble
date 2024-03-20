package pij.main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int INITIAL_NUMBER_OF_PLAYER_TILES = 7;
    protected int score = 0;

    protected List<Tile> tileRack;
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

    /**
     * printPlayerTileRack() :  Prints the player's tile rack to screen..
     *
     * @param playerTiles The name of the player whose tiles will be printed.
     * @param gameType A boolean flag indicating the type of game being played.`true` for an open game, `false` for a closed game.
     *
     * If game is Open Type, it prints OPEN GAME and user tiles.
     */




    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        StringBuilder tempRackBuilder = new StringBuilder(); // Placeholder for tile representation
        for (Tile tile : tileRack) {
            tempRackBuilder.append("[").append(tile.getTileLetter()).append(tile.getTileValue()).append("] ");
        }

        String tempRack = tempRackBuilder.toString(); // Collect tile representations

        // Ternary Syntactic Sugar. If bool gameType is true, prints OPEN GAME. Implement in the subclasses.
        System.out.print(gameType ? "OPEN GAME: " + playerTiles + tempRack : playerTiles + tempRack);
        System.out.println(); // Add a newline for readability
    }



    public int getScore() {
        return score;
    }

    // Setter method for score
    public void setScore(int score) {
        this.score = score;
    }


    public String toString() {
        return super.toString();
    }
}

