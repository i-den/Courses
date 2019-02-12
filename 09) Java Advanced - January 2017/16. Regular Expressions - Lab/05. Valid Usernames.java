import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    private static String strToEndInput = "END";
    private static String validInput = "valid";
    private static String invalidInput = "invalid";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern validUsernameRegEx = Pattern.compile("^\\w{3,16}$");

        try {
            String currInputLine = reader.readLine();
            while (!strToEndInput.equals(currInputLine)) {
                Matcher validUsernameMatcher = validUsernameRegEx.matcher(currInputLine);
                if (validUsernameMatcher.find()) {
                    System.out.println(validInput);
                } else {
                    System.out.println(invalidInput);
                }

                currInputLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}