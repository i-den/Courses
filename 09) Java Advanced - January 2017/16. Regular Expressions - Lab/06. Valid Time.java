import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {

    private static String strToEndInput = "END";
    private static String validInput = "valid";
    private static String invalidInput = "invalid";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern validTimeRegEx = Pattern.compile("^([1-2][\\d])(:([0-5][\\d])){2}\\s[AP]M$");

        try {
            String currInputLine = reader.readLine();
            while (!strToEndInput.equals(currInputLine)) {
                Matcher validTimeInput = validTimeRegEx.matcher(currInputLine);
                if (validTimeInput.find()) {
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