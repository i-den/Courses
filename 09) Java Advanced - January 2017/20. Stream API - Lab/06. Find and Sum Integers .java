import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndSumIntegers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern matchesInput = Pattern.compile("Sum\\s+(?<firstNum>[-+]?\\d+)\\s+and\\s+(?<secNum>[-+]?\\d+)");

        String input = scanner.nextLine();
        Matcher inputValidate = matchesInput.matcher(input);

        if (inputValidate.find()) {
            int firstNum = Integer.parseInt(inputValidate.group("firstNum"));
            int sectNum = Integer.parseInt(inputValidate.group("secNum"));
            System.out.println(firstNum + sectNum);
        } else {
            System.out.println("No match");
        }
    }
}