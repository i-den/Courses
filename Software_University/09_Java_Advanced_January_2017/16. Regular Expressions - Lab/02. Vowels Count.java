import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String haystackTxt = scanner.nextLine();

        Pattern regEx = Pattern.compile("[EYUIOAeyuioa]");
        Matcher foundTxtMatcher = regEx.matcher(haystackTxt);

        int vowCnt = 0;
        while (foundTxtMatcher.find()) {
            vowCnt++;
        }

        System.out.println("Vowels: ".concat(String.valueOf(vowCnt)));
    }
}