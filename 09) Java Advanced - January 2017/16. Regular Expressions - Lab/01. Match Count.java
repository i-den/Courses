import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String needleStr = scanner.nextLine();
        String haystackTxt = scanner.nextLine();

        Pattern regEx = Pattern.compile(needleStr);
        Matcher foundTxtMatcher = regEx.matcher(haystackTxt);

        int count = 0;
        while (foundTxtMatcher.find()) {
            System.out.println(foundTxtMatcher.group());
            count++;
        }

        System.out.println(count);
    }
}