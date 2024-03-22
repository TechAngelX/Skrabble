package pij.main;

/**
 * This class represents a basic blueprint of a single tile. It has a letter, and a value.
 */
public class Tile {
    private char tileLetter;
    private int tileValue;

    /**
     * Constructs a tile with the specified letter and value.
     *
     * @param letter the letter of the tile
     * @param value  the value of the tile
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
}
