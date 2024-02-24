package pij.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BoardInit newGame = new BoardInit();
//        newGame.intro_Header();
        newGame.defBoard();
        newGame.printDefaultBoard();

        tileControl readyPlayer1 = new tileControl();

        // Initialize the tile bag for this game's instance.
//        readyPlayer1.tileBagInit();
//
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
//            System.out.print(tile + " ");
//
//        }
//
//



    }}