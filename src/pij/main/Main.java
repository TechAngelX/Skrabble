package pij.main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

//        GameInit newGame = new GameInit();
//        newGame.intro_Header();
//        newGame.board_Config();

//        GamePlay inGame = new GamePlay();
//        inGame.initialTileBag();
//
//        System.out.println(inGame.getTile('B'));
        // This will print the value associated with the letter 'A'

SimpleAddJUnitTest add = new SimpleAddJUnitTest();
add.simpleAdderJUnitTest(2,3);


    }

}



//        String [] cars = {"Lambo","Tesla","Ford"};
//
//        try {
//            FileWriter writer = new FileWriter("myText.txt");
//
//            writer.write("Ricki Is an Angel");
//            for (String carName : cars) {
//                writer.write("\n" + carName);
//            }
//            {
//
//            }
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("blah blah blah");
//            e.printStackTrace();
//        }