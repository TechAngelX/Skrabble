package pij.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BoardInit<String> defBoard = new BoardInit<>();
        defBoard.setElement(1,0,"5");
        System.out.println(defBoard.toString());

//      BELOW METHODS AND CODE ARE ALL ON THE OLD DEPRECATED BOARDINITOLDTMP CLASS. I WILL SLOWLY MIGRATE THEM OVER.
//        newGame.intro_Header();
//        newGame.printDefaultBoard();

//        tileControl readyPlayer1 = new tileControl();

        // Initialize the tile bag for this game's instance.
//        readyPlayer1.tileBagInit();
//
//        newGame.boardConfig();
//        readyPlayer1.printNumberInTileBag();
//
//        ArrayList<Character> tilesPc = readyPlayer1.tileRackComputer();
//        System.out.print("OPEN GAME: The computer's tiles:" );
//        for (char tile : tilesPc) {
//            System.out.print(tile + " ");
//        }
//
//        ArrayList<Character> tiles = readyPlayer1.tileRackHuman();
//        System.out.print("\nCurrent tiles on your Rack: ");
//        for (char tile : tiles) {
//            System.out.print(tile + " ");//
//        }


    }}