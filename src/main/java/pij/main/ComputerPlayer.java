package pij.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerPlayer extends Player {
    private String word;
    private String direction;
    private final WordValidator wordValidator;

    public ComputerPlayer(TileBag tileBag) {
        super(tileBag);
        this.wordValidator = new WordValidator(this);
        this.word = "";
    }

    public void setDirection(String direction) {
        this.direction = direction;    }

// COMPUTER AI AND LOGIC
// =========================
    public String enterWordAndDirectionAI(GamePlay gamePlay) {
        int maxScore = 0;
        String chosedWordAI = "";

        List<Character> letters = extractLettersFromTileRack(tileRack);

        // Iterate over each letter in the rack
        for (char letter : letters) {
            StringBuilder tmpCurrentWord = new StringBuilder();
            tmpCurrentWord.append(letter);
            AIBuildWords(tileRack.removeTile(letter), tmpCurrentWord, wordValidator.isWordInDictionary(), 0, highestScoringWord, maxScore);
            tileRack.addTile(new Tile(letter)); // Add back the letter after exploration
        }

        // If no valid word found, pass
        if (highestScoringWord.isEmpty()) {
            System.out.println("No valid word found. Passing turn.");
            playerPassCount++;
            return null;
        } else {
            this.word = highestScoringWord;
            return wordValidator.validateWord(word);  // Potentially update word based on validation
        }
    }

    // extractLettersFromTileRack() : Using Pattern Matcher function to isolate ascending letters from numbers.
    // Very much a work in progress.
    private List<Character> extractLettersFromTileRack(List<Player> tileRack) {
        List<Character> letters = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z][0-9]"); // Matches two characters: letter and digit
        for (Tile tile : tileRack) {
            Matcher matcher = pattern.matcher(tile.getTileLetter() + ""); // Convert tile to string
            if (matcher.matches()) {
                letters.add(matcher.group(1).charAt(0)); // Extract the letter (group 1)
            }
        }
        return letters;
    }

    @Override
    public void printPlayerTileRack(String playerTiles, boolean gameType) {
        super.printPlayerTileRack(playerTiles, gameType);
    }

    private void AIBuildWords(Tile tile, StringBuilder currentWord, HashMap<String, Integer> dictionary, int currentScore, String bestWord, int maxScore) {
        // ... (rest of exploreWords logic remains the same)
    }

        //DICTIONARY CHECK.sends computer generated 'word' to WordValidator class to check if in wordlist.
        if (wordValidator.isWordInTileRack(word))
            // Word is valid in the dictionary, check for tile rack next
            if (wordValidator.isWordInTileRack(word,direction)) {


            } else {
                System.out.println("INVALID TILE: HUMAN");
//                    printMyileRackHelper("With tiles "+ printMyileRackHelper(""));
            }
//                    System.out.println("WANKR ! With the FUCKIN tiles " +             printPlayerTileRackClean("");
//                    + ", you cannot HP key,e3play word "+word+","+direction);                }
//        } else {
//            System.out.println("\"" + word + "\" not in the dictionary. Please try again.");
//        }
//    }
//        return null;
//}
//

    // ecursively explore possible words that can be formed using the available tiles in a player's tile rack.
    private void AIBuildWords(TileRack remainingTiles, StringBuilder tmpCurrentWord, HashMap<String, Integer> dictionary, int maxScore, String bestWord) {
        if (dictionary.containsKey(tmpCurrentWord.toString())) {
            // TODO Check if the word is playable with remaining tiles
            if (isPlayableWord(tmpCurrentWord.toString(), remainingTiles)) {
                int score = calculateWordScore(tmpCurrentWord.toString());
                if (score > maxScore) {
                    maxScore = score;
                    bestWord = tmpCurrentWord.toString();
                }
            }

            // Explore words with one additional character
            for (char child = 'A'; child <= 'Z'; child++) {
                if (remainingTiles.containsTile(child)) {
                    tmpCurrentWord.append(child);
                    AIBuildWords(remainingTiles.removeTile(child), tmpCurrentWord, dictionary, maxScore, bestWord);
                    tmpCurrentWord.deleteCharAt(tmpCurrentWord.length() - 1);
                }
            }

            // Helper methods: maybe isPlayableWord, calculateWordScore


            }
        }}