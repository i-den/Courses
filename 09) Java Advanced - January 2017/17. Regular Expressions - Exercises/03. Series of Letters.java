import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern conseqLettersRegEx = Pattern.compile("(.)\\1*");
        StringBuilder outputNonConseqChars = new StringBuilder();

        try {
            String input = reader.readLine();
            Matcher foundConseqLetters = conseqLettersRegEx.matcher(input);

            while (foundConseqLetters.find()) {
                outputNonConseqChars.append(foundConseqLetters.group(1));
            }

            System.out.println(outputNonConseqChars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
