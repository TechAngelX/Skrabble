package pij.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordValidator {
        protected  final String WORD_LIST = "src/resources/wordlist.txt";
        private final Map<String, Boolean> dictionary;

    public WordValidator() throws FileNotFoundException {
        this.dictionary = loadDictionary();
    }

    private Map<String, Boolean> loadDictionary() throws FileNotFoundException {
        Map<String, Boolean> dictionary = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(WORD_LIST))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                dictionary.put(line.toLowerCase(), true); // Store words in lowercase for case-insensitive comparison
            }
        }
        return dictionary;
    }

    // isWordInDictionary() : Checks the first part of string (before comma ',')  is in wordlist.txt.





    public boolean isWordInDictionary(String word) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(WORD_LIST))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        }
        return false;
    }





    // isWordInTileRack() : Iterates through the letter of each user-entered word and checks if a match. Ignores blanks [_].
    public boolean isWordInTileRack(String word, String direction, Player player) {
        Map<Character, Integer> tileCounts = new HashMap<>();
        boolean wildcardPresent = false; // Track if wildcard is present

        // Access tileRack directly from the player object
        for (Tile tile : player.getTileRack()) {
            char firstTileLetter = tile.getTileLetter();
            if (firstTileLetter == '_') {
                wildcardPresent = true;
            } else {
                tileCounts.put(firstTileLetter, tileCounts.getOrDefault(firstTileLetter, 0) + 1);
            }
        }

        // Convert the word to uppercase for consistency
        word = word.toUpperCase();

        // Check if the word can be formed from tiles in the rack
        for (char letter : word.toCharArray()) {
            if (tileCounts.containsKey(letter) && tileCounts.get(letter) > 0) {
                // If the letter is available in the tile rack, decrement its count
                tileCounts.put(letter, tileCounts.get(letter) - 1);
            } else if (wildcardPresent) {
                // If the letter is not available but there is a wildcard, continue checking
                wildcardPresent = false; // Consume the wildcard
            } else {
                // If the letter is not available and there are no wildcard tiles, return false
                System.out.println("Sorry. You only have "+player.cleanTileRack()+"in your rack, so ypu cannot make the word '"+word+"'.");
                return false;
            }
        }
        // If the loop completes, the word can be formed from the tiles. Break out of validation check and
        // go back to the respective Player subclass.
        return true;
    }





    // isDirectionValid() : Checks second part of the string (e.g., H4), and determines if user entered a digit or character.            if (Character.isDigit(firstChar)) {
        public boolean areCoordinatesValid(String direction) {
            if (direction == null || direction.isEmpty()) { // Check if null.
                return false;
            }
            char firstChar = direction.charAt(0);

            if (Character.isDigit(firstChar)) {
                if (direction.length() > 1 && Character.isLetter(direction.charAt(1))) {
                    // if true, continue with logic.
                    return true;
                }
            } else if (Character.isLetter(firstChar)) {
                // Check if the first character is a letter, if it's a letter, check if the next character is a digit.
                if (direction.length() > 1 && Character.isDigit(direction.charAt(1))) {
                    // if true, continue with logic.
                    return true;
                }
            }
            // If none of the conditions are met, return false
            return false;
        }
}


//  TODO Implement additional checks for valid placement here
//  - Check if the first tile placement is on an empty space or a star (center square)
//  - Verify if adjacent tiles on the board match the corresponding letters in the placed word
//  - (both horizontally and vertically)






