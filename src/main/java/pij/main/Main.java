package pij.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BoardInit newGame = new BoardInit();
        newGame.intro_Header();
        newGame.setPlayerName();;



        tileControl readyPlayer1 = new tileControl();

        // Initialize the tile bag for this game's instance.
        readyPlayer1.tileBagInit();


        newGame.boardConfig();
//        readyPlayer1.printNumberInTileBag();
//
//        ArrayList<Character> tiles = readyPlayer1.tileRackHuman();
//        System.out.print("Your tiles on the Rack: ");
//        for (char tile : tiles) {
//            System.out.print(tile + " ");
//        }




    }}