import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {

    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {
        int vowelsCnt = 0;
        int consonantsCnt = 0;
        int punctuationCnt = 0;

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuation = Arrays.asList('!', ',', '.', '?');

        try (
                FileInputStream fileInputStream = new FileInputStream(inputFile);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            int currByte = fileInputStream.read();

            while (currByte >= 0) {
                char currChar = (char) currByte;

                if (vowels.contains(currChar)) {
                    vowelsCnt++;
                } else if (punctuation.contains(currChar)) {
                    punctuationCnt++;
                } else if (currChar != ' ') {
                    consonantsCnt++;
                }

                currByte = fileInputStream.read();
            }

            String output = String.format(
                    "Vowels: %d%nConsonants: %d%nPunctuation: %d",
                    vowelsCnt,
                    consonantsCnt,
                    punctuationCnt
            );
            bufferedWriter.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}