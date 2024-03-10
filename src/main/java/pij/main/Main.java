package pij.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize Board for this game's instance.
        BoardInit currentGame = new BoardInit();
//        currentGame.introHeader();
//        currentGame.customOrDefaultBoardChooser();
        currentGame.openOrClosedGameChooser();
        HumanPlayer humanPlayer = new HumanPlayer();
        humanPlayer.createTileRack(new TileBag());
        humanPlayer..



        // Creaate tilebag object, and initialize the tile bag for this game's instance.
        TileBag tileBag = new TileBag();
        tileBag.wholeTileBag();










//        ArrayList<Character> tilesPc = readyPlayer1.tileRackComputer();
//        System.out.print("OPEN GAME: The computer's tiles:" );
//        for (char tile : tilesPc) {
//            System.out.print(tile + " ");
//        }
//


//
//        System.out.println(currentGame.setElement(0,1,"R1"));
//        System.out.println(currentGame.setElement(1,1,"I1"));
//        System.out.println(currentGame.setElement(2,1,"C3"));
//        System.out.println(currentGame.setElement(3,1,"K4"));
//        System.out.println(currentGame.setElement(4,1,"I1"));

//        System.out.println(currentGame.toString());

        //     currentGame.setElement(5,4,"(-5)"); // Possibly use this method to input tiles onto the board after board init?


//      BELOW METHODS AND CODE ARE ALL ON THE OLD DEPRECATED BOARDINITOLDTMP CLASS. I WILL SLOWLY MIGRATE THEM OVER.
//        currentGame.printDefaultBoard();



//
//


    }}