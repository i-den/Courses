import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {

    private static final String INPUT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuationMarks = Arrays.asList('!', ',', '.', '?');

        int vowelsCnt = 0;
        int consonantsCnt = 0;
        int punctuationMarksCnt = 0;
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currChar = line.charAt(i);
                    if (currChar == ' ') {
                        continue;
                    } else if (vowels.contains(currChar)) {
                        vowelsCnt++;
                    } else if (punctuationMarks.contains(currChar)) {
                        punctuationMarksCnt++;
                    } else {
                        consonantsCnt++;
                    }
                }
            }

            bufferedWriter.write(String.format("%s: %d%n", "Vowels", vowelsCnt));
            bufferedWriter.write(String.format("%s: %d%n", "Consonants", consonantsCnt));
            bufferedWriter.write(String.format("%s: %d%n", "Punctuation", punctuationMarksCnt));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}