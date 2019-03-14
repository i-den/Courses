import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    private static final char OPENING_BRACKET = '(';
    private static final char CLOSING_BRACKET = ')';

    public static void main(String[] args) {
        String inpExpression = new Scanner(System.in).nextLine();
        ArrayDeque<String> innerExpressions = getInnerExpressions(inpExpression);
        printOutput(innerExpressions);
    }

    private static ArrayDeque<String> getInnerExpressions(String inpExpression) {
        ArrayDeque<String> innerExpressions = new ArrayDeque<>();
        ArrayDeque<Integer> openingBracketIndexes = new ArrayDeque<>();

        char[] inpExprAsChars = inpExpression.toCharArray();
        for (int i = 0; i < inpExprAsChars.length; i++) {
            char currChar = inpExprAsChars[i];
            if (OPENING_BRACKET == currChar) {
                openingBracketIndexes.addFirst(i);
            } else if (CLOSING_BRACKET == currChar) {
                int lastOpeningBracketIndex = openingBracketIndexes.removeFirst();
                innerExpressions.addLast(inpExpression.substring(lastOpeningBracketIndex, i + 1));
            }
        }
        return innerExpressions;
    }

    private static void printOutput(ArrayDeque<String> innerExpressions) {
        while (!innerExpressions.isEmpty()) {
            System.out.println(innerExpressions.removeFirst());
        }
    }
}