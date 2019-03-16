import java.util.*;

public class BalancedParenthesis {

    private static final HashMap<Character, Character> CLOSING_OPENING_PARENTHESIS = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    private static final String PARENTHESIS_ARE_BALANCED = "YES";
    private static final String PARENTHESIS_ARE_NOT_BALANCED = "NO";

    public static void main(String[] args) {
        char[] intputParenthesis = new Scanner(System.in).nextLine().toCharArray();
        if (checkParenthesisForBalance(intputParenthesis)) {
            System.out.println(PARENTHESIS_ARE_BALANCED);
        } else {
            System.out.println(PARENTHESIS_ARE_NOT_BALANCED);
        }
    }

    private static boolean checkParenthesisForBalance(char[] inputParenthesis) {
        ArrayDeque<Character> lastOpeningParenthesis = new ArrayDeque<>();

        Set<Character> openingParenthesis = CLOSING_OPENING_PARENTHESIS.keySet();
        for (char currParenthesis : inputParenthesis) {
            if (openingParenthesis.contains(currParenthesis)) {
                lastOpeningParenthesis.addFirst(currParenthesis);
            } else if (CLOSING_OPENING_PARENTHESIS.get(lastOpeningParenthesis.removeFirst()) != currParenthesis) {
                return false;
            }
        }
        return true;
    }
}