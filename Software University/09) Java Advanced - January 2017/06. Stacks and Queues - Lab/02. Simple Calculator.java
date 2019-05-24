import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> calculatedExprsn = new ArrayDeque<>();

        String[] mathExprsn = scanner.nextLine()
                .split("\\s+");

        Collections.addAll(calculatedExprsn, mathExprsn);

        while (calculatedExprsn.size() > 1) {
            int leftNum = Integer.valueOf(calculatedExprsn.pop());
            String operator = calculatedExprsn.pop();
            int rightNum = Integer.valueOf(calculatedExprsn.pop());

            if (operator.equals("+")) {
                calculatedExprsn.push(Integer.toString(leftNum + rightNum));
            } else {
                calculatedExprsn.push(Integer.toString(leftNum - rightNum));
            }
        }

        System.out.println(calculatedExprsn.pop());
    }
}