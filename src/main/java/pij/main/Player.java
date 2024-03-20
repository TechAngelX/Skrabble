package pij.main;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected final int INITIAL_NUMBER_OF_PLAYER_TILES = 7;
    protected final int PLAYER_RACK_IS_EMPTY= 0;
    protected final int TWO_PASS_COUNTS_IN_SUCCESSION = 2; // More than two passes in a row meets criteria to trigger endGame()
    protected  int playerPassCount = 0;

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














        public void removeTile(String letter) {
            // Find the index of the tile to remove
            int index = -1;
            for (int i = 0; i < tileRack.size(); i++) {
                if (tileRack.get(i).getTileLetter() == letter.charAt(0)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Tile '" + letter + "' not found in your rack.");
                return;
            }

            // Remove the tile at the index from the tile rack
            tileRack.remove(index);

            System.out.println("Tile '" + letter + "' removed from your rack.");
        }


    public static int getPointsSwitchCase(char letter) {
        int score = 0;
        switch (letter) {
            // Cases for score 1
            case 'A':
            case 'E':
            case 'I':
            case 'L':
            case 'N':
            case 'O':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
                score = 1;
                break;
            // Cases for score 2
            case 'D':
            case 'G':
                score = 2;
                break;
            // Cases for score 3
            case 'B':
            case 'C':
            case 'M':
            case 'P':
                score = 3;
                break;
            // Cases for score 4
            case 'F':
            case 'H':
            case 'V':
            case 'W':
                score = 4;
                break;
            // Cases for higher scores
            case 'Y':
                score = 5;
                break;
            case '_':
                score = 5; // Our friend, the wildcard.
                break;
            case 'K':
                score = 6;
                break;
            case 'J':
            case 'X':
                score = 9;
                break;

            case 'Z':
                score = 11;
                break;
            case 'Q':
                score = 12;
            default:
                score = 0; // Handle unexpected characters
        }
        return score;
    }





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

