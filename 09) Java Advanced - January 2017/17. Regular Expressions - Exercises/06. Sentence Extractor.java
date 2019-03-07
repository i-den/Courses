import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> correctSentences = new LinkedHashSet<>();

        Pattern validSentenceRegEx = Pattern.compile("[A-Z][^.!?]*[.!?]");

        try {
            String needleWord = reader.readLine();
            String haystackText = reader.readLine();

            Pattern validNeedleWordRegEx = Pattern.compile(String.format("%s%s%s", "\\b", needleWord, "\\b"));
            Matcher validSentenceFinder = validSentenceRegEx.matcher(haystackText);

            while (validSentenceFinder.find()) {
                String currValidSentence = validSentenceFinder.group();

                Matcher validWordFinder = validNeedleWordRegEx.matcher(currValidSentence);
                if (validWordFinder.find()) {
                    correctSentences.add(currValidSentence);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String correctSentence : correctSentences) {
            System.out.println(correctSentence);
        }
    }
}