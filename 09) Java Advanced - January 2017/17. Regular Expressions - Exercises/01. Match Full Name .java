import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

public class MatchFullName {

    private static String strToEndInput = "end";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> validNamesFound = new LinkedHashSet<>();
        Pattern validNameRegEx = Pattern.compile("^([A-Z][a-z]+)\\s([A-Z][a-z]+)$");

        String currNameInput;
        try {
            while (!strToEndInput.equals(currNameInput = reader.readLine())) {
                if (validNameRegEx.matcher(currNameInput).find()) {
                    validNamesFound.add(currNameInput);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String currValidName : validNamesFound) {
            System.out.println(currValidName);
        }
    }
}