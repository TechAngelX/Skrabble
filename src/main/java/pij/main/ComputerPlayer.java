package pij.main;


import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ComputerPlayer extends Player {
    private String word;
    private String direction;
    private WordValidator wordValidator;

    public ComputerPlayer(TileBag tileBag, BoardInit board) throws FileNotFoundException {
        super(tileBag);
        this.wordValidator = new WordValidator();
    }
    public ComputerPlayer(TileBag tileBag) throws FileNotFoundException {
        super(tileBag);
    }

    public String enterWordAndDirection(Scanner scanner) throws FileNotFoundException {
        while (true) {
            System.out.println(""); // Blank space
            System.out.println("OK Computer. It's the Computer's turn!");
            System.out.print("thinking ...");

            // Just to bit of fun to add atmosphere to the AI. set maxTime to 0 (secondds) to turn effect off.
        // randomAIWaitTime(5);

        }}

        // randomAIWaitTime() : Generates a random wait time between 0 and 'x' seconds, to simulate the AI thinkinn...
        // User can set the time when calling the method.
        protected void randomAIWaitTime ( int maxTime){
            Random random = new Random();
            int min = 2;
            int max = 4;
            System.out.print("thinking ...");

            int randNum = random.nextInt(maxTime - min + 1) + min;

            for (int i = 0; i < randNum; i++) {
                blinkThreeDots();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    //  Makes three dots blink consecutively
    private void blinkThreeDots() {
        System.out.print("...");

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("\b\b\b");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

//    ==========================================================================================================

//            public String generateWord() {
