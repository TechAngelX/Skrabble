package pij.main;
/**
 * The Tile class represents a single tile used in a game.
 * Each tile has a key (letter) and a value (numerical value/point) associated with it.
 */
public class Tile {
    private char tileLetter;
    private int tileValue;
    /**
     * Constructs a new Tile object with the specified letter and value.
     *
     * @param letter the letter of the tile (i.e., Q)
     * @param value  the value of the tile (i.e., 12 for letter Q)
     */
    public Tile(char letter, int value) {
        this.tileLetter = letter;
        this.tileValue = value;
    }
    public char getTileLetter() {
        return tileLetter;
    }

    public int getTileValue() {
        return tileValue;
    }
    public void setCount(int count) {
        this.tileValue = count;
    }
}
