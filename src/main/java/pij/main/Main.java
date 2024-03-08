package pij.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize Board for this game's instance.
        BoardInit newGame = new BoardInit();
        newGame.customOrDefaultBoardChooser();
//        newGame.openOrClosedGameChooser();



        // Creaate tilebag object, and initialize the tile bag for this game's instance.
        TileControl tileControl = new TileControl();
         tileControl.tileBagInit(); // Initialize (otherwise, null pointer exception).

        tileControl.printNumberInTileBag(); // Prints current state of tiles in the bag.


          HashMap<Character, Integer> tiles = tileControl.tileRackHuman();
        System.out.print("\nIt's your turn. Your tiles: ");
        for (Map.Entry<Character, Integer> entry : tiles.entrySet()) {
            char tile = entry.getKey();
            int count = entry.getValue();
            System.out.print("["+tile + count +"] "); // Print tile and count
        }

                tileControl.printNumberInTileBag(); // Prints current state of tiles in the bag.

//        newGame.introHeader();






//        ArrayList<Character> tilesPc = readyPlayer1.tileRackComputer();
//        System.out.print("OPEN GAME: The computer's tiles:" );
//        for (char tile : tilesPc) {
//            System.out.print(tile + " ");
//        }
//



        System.out.println(newGame.setElement(0,1,"R1"));
        System.out.println(newGame.setElement(1,1,"I1"));
        System.out.println(newGame.setElement(2,1,"C3"));
        System.out.println(newGame.setElement(3,1,"K4"));
        System.out.println(newGame.setElement(4,1,"I1"));

//        System.out.println(newGame.toString());

        //     newGame.setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?


//      BELOW METHODS AND CODE ARE ALL ON THE OLD DEPRECATED BOARDINITOLDTMP CLASS. I WILL SLOWLY MIGRATE THEM OVER.
//        newGame.printDefaultBoard();



//
//


    }}