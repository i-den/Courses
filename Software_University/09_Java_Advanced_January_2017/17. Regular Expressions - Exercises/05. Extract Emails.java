import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {

    private static String strToEndInput = "end";

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> validEmails = new LinkedHashSet<>();
        Pattern validEmailRegEx = Pattern.compile("\\b(?<![-_.])[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@[A-Za-z\\d]+([-_.][A-Za-z\\d]+)+");

        try {
            String currLine;
            while (!strToEndInput.equals((currLine = reader.readLine()))) {
                Matcher matchedEmails = validEmailRegEx.matcher(currLine);
                while ((matchedEmails).find()) {
                    validEmails.add(matchedEmails.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String validEmail : validEmails) {
            System.out.println(validEmail);
        }
    }
}