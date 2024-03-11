package pij.main;

public class Tile {
    private char tileLetter;
    private int tileValue;

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
