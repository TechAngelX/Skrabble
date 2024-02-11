package pij.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//      newGame.intro_Header();
        BoardInit newGame = new BoardInit();
        tileControl readyPlayer1 = new tileControl();

        // Initialize the tile bag
        readyPlayer1.tileBagInit();

        // Call other methods
        newGame.boardConfig();
        readyPlayer1.printNumberInTileBag();

        ArrayList<Character> tiles = readyPlayer1.tileRackHuman();
        System.out.println("Your tiles on the Rack:");
        for (char tile : tiles) {
            System.out.print(tile + " ");
        }



    }}