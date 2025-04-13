import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * A utility class for converting Morse code into English.
 * Uses a static MorseCodeTree instance to perform conversions.
 */
public class MorseCodeConverter {

    /** The morse tree. */
    private static MorseCodeTree morseTree = new MorseCodeTree();

    /**
     * Converts a Morse code string to an English string.
     * Letters are separated by spaces, words by slashes (/).
     * 
     * @param code the Morse code string
     * @return the English translation
     */
    public static String convertToEnglish(String code) {
        StringBuilder result = new StringBuilder();
        String[] words = code.trim().split(" / "); // Split words by "/"

        for (int w = 0; w < words.length; w++) {
            String[] letters = words[w].split(" ");
            for (String morseLetter : letters) {
                result.append(morseTree.fetch(morseLetter));
            }
            if (w < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    /**
     * Converts the contents of a file (with Morse code) to English.
     * 
     * @param file the File object containing Morse code
     * @return the English translation
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder morse = new StringBuilder();
        while (scanner.hasNext()) {
            morse.append(scanner.next()).append(" ");
        }
        scanner.close();
        return convertToEnglish(morse.toString().trim());
    }

    /**
     * Used for testing: returns the MorseCodeTree in LNR (Inorder) traversal.
     * 
     * @return a space-separated string of the MorseCodeTree values
     */
    public static String printTree() {
        StringBuilder result = new StringBuilder();
        for (String letter : morseTree.toArrayList()) {
            result.append(letter).append(" ");
        }
        return result.toString().trim();
    }
    

}
