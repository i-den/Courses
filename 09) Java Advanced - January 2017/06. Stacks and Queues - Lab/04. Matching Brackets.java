import java.util.ArrayDeque;
import java.util.Scanner;

public class DecToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> openBracketsInd = new ArrayDeque<>();

        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            
            if (currChar == '(') {
                openBracketsInd.push(i);
            } else if (currChar == ')') {
                System.out.println(expression.substring(openBracketsInd.pop(), i + 1));
            }
        }
    }
}