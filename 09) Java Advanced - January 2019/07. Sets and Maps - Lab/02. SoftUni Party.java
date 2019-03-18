import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {

    private static final int REQUIRED_INPUT_LEN = 8;
    private static final String STR_TO_END_INPUT = "END";
    private static final String REMOVE_MEMBERS_FROM_LIST = "PARTY";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> VIPGuestsList = new TreeSet<>();
        TreeSet<String> regularGuestsList = new TreeSet<>();

        String input;
        while (!REMOVE_MEMBERS_FROM_LIST.equals((input = scanner.nextLine()))) {
            if (input.length() != REQUIRED_INPUT_LEN) {
                continue;
            }

            if (Character.isDigit(input.charAt(0))) {
                VIPGuestsList.add(input);
            } else {
                regularGuestsList.add(input);
            }
        }

        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            if (Character.isDigit(input.charAt(0))) {
                VIPGuestsList.remove(input);
            } else {
                regularGuestsList.remove(input);
            }
        }

        System.out.println(VIPGuestsList.size() + regularGuestsList.size());
        for (String s : VIPGuestsList) {
            System.out.println(s);
        }
        for (String s : regularGuestsList) {
            System.out.println(s);
        }
    }
}