import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    private static final String STR_TO_END_INPUT = "Home";
    private static final String STR_TO_RETURN = "back";
    private static final String NO_PREV_URL_IN_STACK = "no previous URLs";
    private static final int STACK_SIZE_TO_HAVE_PREV_URL = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> urlStack = new ArrayDeque<>();

        String currInput;
        while (!STR_TO_END_INPUT.equals((currInput = scanner.nextLine()))) {
            if (STR_TO_RETURN.equals(currInput)) {
                if (urlStack.size() >= STACK_SIZE_TO_HAVE_PREV_URL) {
                    urlStack.pollFirst();
                    System.out.println(urlStack.peek());
                } else {
                    System.out.println(NO_PREV_URL_IN_STACK);
                }
            } else {
                urlStack.addFirst(currInput);
                System.out.println(currInput);
            }
        }
    }
}