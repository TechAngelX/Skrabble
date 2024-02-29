package pij.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize Board for this game's instance.
        BoardInit newGame = new BoardInit();

        // Initialize the tile bag for this game's instance.
        TileControl tileControl = new TileControl();

        newGame.intro_Header();
        newGame.boardConfig();
//        newGame.gameTypeOpenCLosed();

        tileControl.tileBagInit();


//        System.out.println(newGame.setElement(0,1,"R1"));
//        System.out.println(newGame.setElement(1,1,"I1"));
//        System.out.println(newGame.setElement(2,1,"C3"));
//        System.out.println(newGame.setElement(3,1,"K4"));
//        System.out.println(newGame.setElement(4,1,"I1"));


        //     newGame.setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?


//      BELOW METHODS AND CODE ARE ALL ON THE OLD DEPRECATED BOARDINITOLDTMP CLASS. I WILL SLOWLY MIGRATE THEM OVER.
//        newGame.printDefaultBoard();



//
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