package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S09_Form_a_Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String line = input.readLine();
            System.out.println(maxCharsForPalindrome(line));
        }
    }

    private static int maxCharsForPalindrome(String line) {
        if (isPalindrome(line)) {
            return 0;
        }
        String reversed = new StringBuilder(line).reverse().toString();
        return line.length() - largestCommonSubsequence(line, reversed);
    }

    private static boolean isPalindrome(String line) {
        for (int i = 0; i < line.length() / 2; i++) {
            if (line.charAt(i) != line.charAt(line.length() - 1 - i))
                return false;
        }
        return true;
    }

    // еби му лелята
    private static int largestCommonSubsequence(String s1, String s2) {
        int[][] largest = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++ ){
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    largest[i][j] = largest[i - 1][j - 1] + 1;
                } else {
                    largest[i][j] = Integer.max(largest[i - 1][j], largest[i][j - 1]);
                }
            }
        }
        return largest[s1.length()][s2.length()];
    }
}
