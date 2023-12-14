/**
 * wordListChecker() Reads and prints the contents of a word list file.
 * The file path is specified as an absolute path in the method.
 * Uses a try-with-resources statement to automatically close the FileReader. *
 * @throws IOException If an IO Exception occurs during file reading.
 */

package pij.main;
import java.io.FileReader;
import java.io.IOException;

public class GamePlay {


    public void wordListChecker() {
        String absolutePath = "/Users/xeon2035/Library/Mobile Documents/com~apple~CloudDocs/UniWerk/PROJECT-PIJ/resources/wordlist.txt";

        try (FileReader fileReader = new FileReader(absolutePath)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("File not found or IO Exception: " + e.getMessage());
        }
    }


}
