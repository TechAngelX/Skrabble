package pij.main;


import java.io.FileNotFoundException;

public class ComputerPlayer extends Player {
    private String word; private String direction;
    private final WordValidator wordValidator;

    public ComputerPlayer(TileBag tileBag) throws FileNotFoundException {
        super(tileBag);
        this.wordValidator = new WordValidator();
    }
}