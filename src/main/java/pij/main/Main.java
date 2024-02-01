package pij.main;

public class Main {
    public static void main(String[] args) {
        BoardInit newGame = new BoardInit();
        GamePlay readyPlayer1 = new GamePlay();
//
//      newGame.intro_Header();
//      newGame.boardConfig();
        newGame.gameType();
        readyPlayer1.tileBagInit();

        readyPlayer1.printNumberInTileBag();

    }}
