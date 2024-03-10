package pij.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BoardInit start = new BoardInit(); // Initialize Board for this game's instance.
        start.start();

        // GAMEPLAY CLASS NOW TAKES OVER
        // -----------------------------

           GamePlay game = new GamePlay();


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

    }}