package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S03_Longest_Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String strToGetLongestPalindromeOf = input.readLine();
            System.out.println(getLongestPalindrome(strToGetLongestPalindromeOf));
        }
    }

    private static String getLongestPalindrome(String string) {
        String largestPalindrome = "";
        for (int i = 0; i < string.length(); i++) {
            char leftChar = string.charAt(i);
            int lastCharIdx = string.lastIndexOf(leftChar);
            while (lastCharIdx > 0 && lastCharIdx != i) {
                if (isPalindrome(string, i + 1, lastCharIdx - 1)) {
                    String palindrome = string.substring(i, lastCharIdx + 1);
                    if (largestPalindrome.length() < palindrome.length())
                        largestPalindrome = palindrome;
                }
                lastCharIdx = string.lastIndexOf(leftChar, lastCharIdx - 1);
            }
        }
        if ("".equals(largestPalindrome))
            return string.charAt(0) + "";
        return largestPalindrome;
    }

    private static boolean isPalindrome(String string, int leftIdx, int rightIdx) {
        while (leftIdx < rightIdx) {
            if (string.charAt(leftIdx) != string.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}
