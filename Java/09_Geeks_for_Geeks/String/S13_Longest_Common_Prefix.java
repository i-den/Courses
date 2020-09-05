package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


public class S13_Longest_Common_Prefix {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            input.readLine();
            String[] words = input.readLine().split("\\s+");
            System.out.println(iterate(words));
        }
    }

    private static String iterate(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String shortest = words[0];
        StringBuilder longestPrefix = new StringBuilder(shortest.length());
        for (int i = 0; i < shortest.length(); i++) {
            char curr = shortest.charAt(i);
            for (int j = 1; j < words.length; j++) {
                String currWord = words[j];
                if (currWord.charAt(i) != curr) {
                    return longestPrefix.toString().length() > 0 ? longestPrefix.toString() : "-1";
                }
            }
            longestPrefix.append(curr);
        }
        return longestPrefix.toString().length() > 0 ? longestPrefix.toString() : "-1";
    }

    private static String bruteForceSubstr(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<Integer> wordsThatContainThePrefixIdxs = new HashSet<>(words.length);
        String shortest = words[0];

        while (!"".equals(shortest)) {
            boolean containedInAll = true;
            for (int i = 1; i < words.length; i++) {
                if (wordsThatContainThePrefixIdxs.contains(i)) {
                    continue;
                }
                if (!words[i].startsWith(shortest)) {
                    containedInAll = false;
                    break;
                } else {
                    wordsThatContainThePrefixIdxs.add(i);
                }
            }
            if (containedInAll) {
                return shortest;
            } else {
                shortest = shortest.substring(0, shortest.length() - 1);
                wordsThatContainThePrefixIdxs.clear();
            }
        }
        return "-1";
    }
}
