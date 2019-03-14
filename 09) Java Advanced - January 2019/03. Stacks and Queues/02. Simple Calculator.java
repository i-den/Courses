import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {

    private static final String ADDITION_SYMBOL = "+";
    private static final String SUBTRACTION_SYMBOL = "-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> expressionToCalc = new ArrayDeque<>();

        String[] inputToCalculate = scanner.nextLine().split("\\s+");
        Collections.addAll(expressionToCalc, inputToCalculate);

        while (expressionToCalc.size() > 1) {
            Integer leftNum = Integer.parseInt(expressionToCalc.removeFirst());
            String currOperation = expressionToCalc.removeFirst();
            Integer rightNum = Integer.parseInt(expressionToCalc.removeFirst());

            switch (currOperation) {
                case ADDITION_SYMBOL:
                    expressionToCalc.addFirst(Integer.toString(leftNum + rightNum));
                    break;
                case SUBTRACTION_SYMBOL:
                default:
                    expressionToCalc.addFirst(Integer.toString(leftNum - rightNum));
                    break;
            }
        }

        System.out.println(expressionToCalc.removeFirst());
    }
}