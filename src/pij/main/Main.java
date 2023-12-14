package pij.main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        GameInit newGame = new GameInit();
        newGame.intro_Header();
        newGame.board_Config();

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