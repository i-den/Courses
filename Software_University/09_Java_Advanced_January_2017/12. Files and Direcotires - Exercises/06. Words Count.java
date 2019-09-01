import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordsCount {

    private static final String wordsFile = "enterHere";
    private static final String inputFile = "enterHere";
    private static final String outputFile = "enterHere";

    public static void main(String[] args) {
        HashMap<String, Long> wordsCnt = new HashMap<>();
        HashMap<String, String> originalWords = new HashMap<>();

        try (
                BufferedReader wordsReader = Files.newBufferedReader(Paths.get(wordsFile));
                BufferedReader inputTxtReader = Files.newBufferedReader(Paths.get(inputFile));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            List<String> wordsToSearchFor = getWordsToSearchFor(wordsReader);
            fillWordMaps(wordsCnt, originalWords, wordsToSearchFor);
            countWords(wordsCnt, inputTxtReader);
            writeWordsCntToOutputFile(wordsCnt, originalWords, bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWordsCntToOutputFile(
            HashMap<String, Long> wordsCnt,
            HashMap<String, String> originalWords,
            BufferedWriter bufferedWriter
    ) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        wordsCnt.entrySet()
                .stream()
                .sorted((firstWordCnt, secWordCnt) ->
                        secWordCnt.getValue().compareTo(firstWordCnt.getValue()))
                .forEach(currWordCnt -> stringBuilder.append(String.format(
                        "%s - %d%s",
                        originalWords.get(currWordCnt.getKey()),
                        currWordCnt.getValue(),
                        System.lineSeparator()
                )));

        bufferedWriter.write(stringBuilder.toString());
    }

    private static void countWords(
            HashMap<String, Long> wordsCnt,
            BufferedReader inputTxtReader
    ) throws IOException {

        String currInputLine = inputTxtReader.readLine();
        while (currInputLine != null) {
            String[] inputWords = Arrays.stream(currInputLine.split("(\\s|,|\\.|\\?|!|;)+"))
                    .map(String::toLowerCase)
                    .toArray(String[]::new);

            for (String currInputWord : inputWords) {
                if (wordsCnt.containsKey(currInputWord)) {
                    wordsCnt.put(
                            currInputWord,
                            wordsCnt.get(currInputWord) + 1
                    );
                }
            }

            currInputLine = inputTxtReader.readLine();
        }
    }

    private static void fillWordMaps(
            HashMap<String, Long> wordsCnt,
            HashMap<String, String> originalWords,
            List<String> wordsToSearchFor
    ) {
        for (String currWordToSearchFor : wordsToSearchFor) {
            if (!originalWords.containsKey(currWordToSearchFor)) {
                String lowCaseOrigWord = currWordToSearchFor.toLowerCase();
                originalWords.put(
                        lowCaseOrigWord,
                        currWordToSearchFor
                );
                wordsCnt.put(lowCaseOrigWord, 1L);
            }
        }
    }

    private static List<String> getWordsToSearchFor(BufferedReader bufferedReader) throws IOException {

        String currLine = bufferedReader.readLine();
        List<String> list = new ArrayList<>();

        while (currLine != null) {
            String[] currLineTkns = currLine.split("\\s+");
            Collections.addAll(list, currLineTkns);

            currLine = bufferedReader.readLine();
        }

        return list;
    }
}