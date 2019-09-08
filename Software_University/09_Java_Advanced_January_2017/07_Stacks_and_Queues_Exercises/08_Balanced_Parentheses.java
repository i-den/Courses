import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> lastOpeningParens = new ArrayDeque<>();

        boolean matches = true;

        String inputParens = scanner.nextLine();

        for (int i = 0; i < inputParens.length(); i++) {
            char currParen = inputParens.charAt(i);

            switch (currParen) {
                case '(':
                case '{':
                case '[':
                    lastOpeningParens.push(currParen);
                    break;
                case ')':
                case '}':
                case ']':
                    char lastOpeningParen = lastOpeningParens.pop();
                    if (!verifyLastParen(currParen, lastOpeningParen)) {
                        matches = false;
                    }
                    break;
            }

            if (!matches) {
                break;
            }
        }

        System.out.printf("%s", matches ? "YES" : "NO");
    }

    private static boolean verifyLastParen(char currParen, char lastOpeningParen) {
        if (currParen == ')' && lastOpeningParen == '(') {
            return true;
        }

        if (currParen == '}' && lastOpeningParen == '{') {
            return true;
        }

        return (currParen == ']' && lastOpeningParen == '[');
    }
}