package pij.main;


import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ComputerPlayer extends Player {
    private String word; private String direction;
    private final WordValidator wordValidator;

    public ComputerPlayer(TileBag tileBag) throws FileNotFoundException {
        super(tileBag);
        this.wordValidator = new WordValidator();
    }

    protected String getDirection() {
        return direction;
    }
    protected void setDirection(String direction) {
        this.direction = direction;
    }

    // randomAIWaitTime() : Generates a random wait time between 0 and 'x' seconds, to simulate the AI thinkinn...
    // User can set the time when calling the method.
    protected void randomAIWaitTime(int maxTime) {
        Random random = new Random();
        int min = 2;
        int max = 4;
        System.out.print("thinking ...");

        int randNum = random.nextInt(maxTime - min + 1) + min;

        for (int i = 0; i < randNum; i++) {
            blinkThreeDots(); // Calls a separate method for blinking three dots
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to blink three dots consecutively
    private void blinkThreeDots() {
        System.out.print("...");

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("\b\b\b");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

}


