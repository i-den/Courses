import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> strAsChars = new ArrayDeque<>();
        boolean isPalindrome = true;

        char[] strToCheck = scanner.nextLine()
                .toCharArray();

        for (char currChar : strToCheck) {
            strAsChars.push(currChar);
        }

        while (strAsChars.size() > 1) {
            char leftChar = strAsChars.removeFirst();
            char rightChar = strAsChars.removeLast();

            if (leftChar != rightChar) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);
    }
}