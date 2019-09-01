import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    private static String strToEndInput = "end";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> validPhoneNumbers = new LinkedHashSet<>();
        Pattern validPhoneNumRegEx = Pattern.compile("^(\\+359)([-\\s])2\\2\\d{3}\\2\\d{4}$");

        try {
            String currInputPhoneNum;
            while (!strToEndInput.equals((currInputPhoneNum = reader.readLine()))) {
                if (validPhoneNumRegEx.matcher(currInputPhoneNum).find()) {
                    validPhoneNumbers.add(currInputPhoneNum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String validPhoneNumber : validPhoneNumbers) {
            System.out.println(validPhoneNumber);
        }
    }
}