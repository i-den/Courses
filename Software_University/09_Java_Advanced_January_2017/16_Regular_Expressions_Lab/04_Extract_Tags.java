import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {

    private static String strToEndInput = "END";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> savedTags = new LinkedHashSet<>();

        Pattern tagRegEx = Pattern.compile("<.+?>");

        try {
            String currLineOfInputTxt = reader.readLine();

            while (!strToEndInput.equals(currLineOfInputTxt)) {
                Matcher currLineMatch = tagRegEx.matcher(currLineOfInputTxt);
                if (currLineMatch.find()) {
                    savedTags.add(currLineMatch.group());
                }

                currLineOfInputTxt = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String savedTag : savedTags) {
            System.out.println(savedTag);
        }
    }
}