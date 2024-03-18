package pij.main;


public class ComputerPlayer extends Player {
    public ComputerPlayer(TileBag tileBag) {
        super(tileBag);
    }


    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        super.printPlayerTileRack(playerTiles, gameType);
    }


    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    @Override
    public String toString() {
        return "Computer Player";
    }
}

