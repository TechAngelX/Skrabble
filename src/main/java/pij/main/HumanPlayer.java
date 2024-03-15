package pij.main;

public class HumanPlayer<GamePlay> extends Player {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }

    @Override
    public String takeTurn(GamePlay gameInPlay) { // TODO Right to use as Type?
        return placementString; // Return the constructed placement string

    }
}





