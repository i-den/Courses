package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S07_Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String[] line = input.readLine().split("\\s+");
            System.out.println(areAnagrams(line[0], line[1]));
        }
    }

    private static String areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return "NO";

        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += Character.hashCode(s1.charAt(i));
            sum -= Character.hashCode(s2.charAt(i));
        }
        return sum == 0 ? "YES" : "NO";
    }
}
