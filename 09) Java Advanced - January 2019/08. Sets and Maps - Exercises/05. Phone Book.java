import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

    private static final String STR_TO_SEARCH_FOR_NAMES = "search";
    private static final String STR_TO_STOP = "stop";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> namesPhoneNums = new HashMap<>();

        String input;
        while (!STR_TO_SEARCH_FOR_NAMES.equals((input = scanner.nextLine()))) {
            String[] namesPhoneNumsTokens = input.split("-");
            namesPhoneNums.put(namesPhoneNumsTokens[0], namesPhoneNumsTokens[1]);
        }

        while (!STR_TO_STOP.equals((input = scanner.nextLine()))) {
            if (namesPhoneNums.containsKey(input)) {
                System.out.printf("%s -> %s%s", input, namesPhoneNums.get(input), System.lineSeparator());
            } else {
                System.out.printf("Contact %s does not exist.%s", input, System.lineSeparator());
            }
        }
    }
}