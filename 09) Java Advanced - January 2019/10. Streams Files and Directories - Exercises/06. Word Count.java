import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class WordCount {

    private static final String ALLOWED_WORDS_FILE = "enterHere";
    private static final String INPUT_TEXT_FILE = "enterHere";
    private static final String OUTPUT_FILE = "enterHere";

    public static void main(String[] args) {
        HashMap<String, String> allowedWordsLowerUpperCase = new HashMap<>();
        HashMap<String, Integer> wordsOccurrences = new HashMap<>();

        try (
                BufferedReader wordsBufferedReader = new BufferedReader(new FileReader(ALLOWED_WORDS_FILE));
                BufferedReader inputTxtFileBufferedReader = new BufferedReader(new FileReader(INPUT_TEXT_FILE));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE))
        ) {
            String line;
            while ((line = wordsBufferedReader.readLine()) != null) {
                String[] lineTokens = line.split("[\\W]");
                for (String lineToken : lineTokens) {
                    allowedWordsLowerUpperCase.put(lineToken.toLowerCase(), lineToken);
                }
            }

            Set<String> allowedWordsLowerCase = allowedWordsLowerUpperCase.keySet();
            while ((line = inputTxtFileBufferedReader.readLine()) != null) {
                for (String word : line.split("[\\W]")) {
                    String lowerCaseWord = word.toLowerCase();
                    if (allowedWordsLowerCase.contains(lowerCaseWord)) {
                        String originalWord = allowedWordsLowerUpperCase.get(lowerCaseWord);
                        wordsOccurrences.putIfAbsent(originalWord, 0);
                        wordsOccurrences.put(originalWord, wordsOccurrences.get(originalWord) + 1);
                    }
                }
            }

            StringBuilder textToWrite = new StringBuilder();
            wordsOccurrences.keySet().stream()
                    .sorted((wo1, wo2) -> wordsOccurrences.get(wo2).compareTo(wordsOccurrences.get(wo1)))
                    .forEach(w -> textToWrite.append(String.format("%s - %d%n", w, wordsOccurrences.get(w))));
            bufferedWriter.write(textToWrite.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}