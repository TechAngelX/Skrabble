package pij.main;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }

    public void enterWordAndDirection(GamePlay gamePlay) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nPlease enter your move in the format: \"word,square (without the quotes)\"\n" +
                    "For example, for suitable direction rack and board configuration, a downward move could\n" +
                    "be DOG,f4 and a rightward move could be DOG,4f.\n>> ");

            String input = scanner.nextLine();
            String[] strings = input.split(",");

            if (strings.length != 2) {
                System.out.println("Invalid input format. Please enter in the format \"word,square\"");
                continue; // Restart the loop to prompt the user again
            }

            String word = strings[0].trim();
            String direction = strings[1].trim().toUpperCase();
            String enteredDirection = direction;

            // Check if the first part is a word
            if (!word.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input. The first part must be a word.");
                continue;
            }

            // Check for letter/number direction, for pretty print
            if (Character.isLetter(direction.charAt(0))) {
                direction = "(Vertical)";
            } else {
                direction = "(Horizontal)";
            }

            System.out.println("Entered word: " + word);
            System.out.println("Entered direction: " + enteredDirection + " " + direction);
            break;
        }
        scanner.close();
    }





    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        super.printPlayerTileRack(playerTiles, gameType);
    }

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    @Override
    public String toString() {
        return "Human Player";
    }
}
