import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidQuotes {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern validQuoteRegEx = Pattern.compile("((['\"]).*?\\2)");
        LinkedHashSet<String> foundQuotations = new LinkedHashSet<>();
        
        try {
            String currInput = reader.readLine();
            Matcher validQuotes = validQuoteRegEx.matcher(currInput);
            while (validQuotes.find()) {
                foundQuotations.add(validQuotes.group());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String foundQuotation : foundQuotations) {
            System.out.println(foundQuotation);
        }
    }
}