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

    //// randomAIWaitTime() Generates  a random wait time between 0 and 4 seconds
    protected void randomAIWaitTime(int maxTime) {
        Random random = new Random();
        int min = 0;
        int max = 4;

        int randNum = random.nextInt(maxTime - min + 1) + min;
        System.out.print("thinking ...");

        for (int i = 0; i < randNum; i++) {
            System.out.print(" ...");

            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("\b\b\b\b\b\b\b\b\b\b");
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


