package pij.main;

public class Main {
    public static void main(String[] args) {
        BoardInit newGame = new BoardInit();
        tileControl readyPlayer1 = new tileControl();

//      newGame.intro_Header();
      newGame.boardConfig();
      readyPlayer1.tileBagInit();
      readyPlayer1.printNumberInTileBag();

    }}
