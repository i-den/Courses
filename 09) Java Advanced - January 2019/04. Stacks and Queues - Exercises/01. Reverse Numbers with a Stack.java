import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithAStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> numberStack = new ArrayDeque<>();

        Collections.addAll(numberStack, scanner.nextLine().split("\\s+"));

        while (!numberStack.isEmpty()) {
            System.out.print(String.format("%s ",numberStack.removeLast()));
        }
    }
}