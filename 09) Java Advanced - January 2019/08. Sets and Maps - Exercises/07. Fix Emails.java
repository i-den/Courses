import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {

    private static final String STR_TO_END_INPUT = "stop";
    private static final String INVALID_EMAIL_REG_EX = "^.*?([Uu][SsKk]|[Cc][Oo][Mm])$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> namesEmail = new LinkedHashMap<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String email = scanner.nextLine();

            if (!email.matches(INVALID_EMAIL_REG_EX)) {
                namesEmail.put(input, email);
            }
        }

        for (String name : namesEmail.keySet()) {
            System.out.printf("%s -> %s%s", name, namesEmail.get(name), System.lineSeparator());
        }
    }
}