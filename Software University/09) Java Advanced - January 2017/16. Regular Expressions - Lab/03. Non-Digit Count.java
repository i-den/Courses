import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonDigitCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String haystackTxt = scanner.nextLine();

        Pattern regEx = Pattern.compile("[\\D]");
        Matcher foundTxtMatcher = regEx.matcher(haystackTxt);

        int nonDigitCnt = 0;
        while (foundTxtMatcher.find()) {
            nonDigitCnt++;
        }

        System.out.println("Non-digits: ".concat(String.valueOf(nonDigitCnt)));
    }
}