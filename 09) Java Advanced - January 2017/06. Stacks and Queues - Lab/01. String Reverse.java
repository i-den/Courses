import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> charsInReverse = new ArrayDeque<>();

        char[] inputStringAsChars = scanner.nextLine()
                .toCharArray();

        for (char currChar : inputStringAsChars) {
            charsInReverse.push(currChar);
        }

        while (!charsInReverse.isEmpty()) {
            System.out.print(charsInReverse.pop());
        }
    }
}