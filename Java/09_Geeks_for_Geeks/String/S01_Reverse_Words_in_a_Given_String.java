package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S01_Reverse_Words_in_a_Given_String {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String wordsSeparatedWithDot = input.readLine();
            System.out.println(reverseWords(wordsSeparatedWithDot));
        }
    }

    private static String reverseWords(String wordsSeparatedWithDot) {
        String[] allWords = wordsSeparatedWithDot.split("\\.");
        StringBuilder reversedWordsJoinedWithDot = new StringBuilder(wordsSeparatedWithDot.length());

        for (int i = allWords.length - 1; i > 0; i--) {
            reversedWordsJoinedWithDot.append(allWords[i]);
            reversedWordsJoinedWithDot.append('.');
        }
        reversedWordsJoinedWithDot.append(allWords[0]);

        return reversedWordsJoinedWithDot.toString();
    }
}
