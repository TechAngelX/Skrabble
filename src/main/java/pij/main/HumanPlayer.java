package pij.main;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(TileBag tileBag) {
        super(tileBag);
    }

    public void enterWordAndDirection(GamePlay gameInPlay) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nPlease enter your move in the format: \"word,square\"\n" +
                    "For example, for suitable direction rack and board configuration, a downward movecould\n" +
                    "be HI,f4 and a rightward move could be HI,4f.\n>> ");

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

            // Check if word is valid in dictionary wordlist.
            boolean isValidWord = gameInPlay.isValidWord(word);

            if (isValidWord) {
                word = word.toUpperCase();
            } else {
                System.out.println("Error. '" + word + "' does not exist in dictionary");
                continue; // Check, and/or restart the loop if the word is invalid
            }

            // Check if the second part (directions) is in the correct format
            if (!direction.matches("[a-pA-P]\\d{0,2}|1?[0-6],[a-pA-P]|1?[0-6][a-pA-P]")) {
                System.out.println("Invalid input. The second part must either contain a letter up to and including 'p' followed by up to two digits, or a number up to 16 followed by a letter up to 'p'.");
                continue;
            }

            // Check direction and validate placement on the board (using GamePlay object)
            if (!gameInPlay.canPlaceWord(word,4,32,"jhhj")) {
                System.out.println("Invalid placement. The word cannot be placed on the board in that direction.");
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
}
