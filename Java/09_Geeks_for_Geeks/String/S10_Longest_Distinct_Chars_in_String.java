package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class S10_Longest_Distinct_Chars_in_String {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String line = input.readLine();
            System.out.println(maxDistinctChars(line));
        }
    }

    private static int maxDistinctChars(String line) {
        Set<Character> repeatingChars = new HashSet<>(line.length());
        int maxCharsTotal = 1;

        int ptr = 0;
        int startingIdx = ptr;
        while (ptr < line.length()) {
            char curr = line.charAt(ptr);
            repeatingChars.add(curr);

            for (int i = ptr + 1; i < line.length(); i++, ptr++) {
                char next = line.charAt(i);
                if (repeatingChars.contains(next)) {
                    repeatingChars.clear();
                    ptr = line.indexOf(next, startingIdx);
                    break;
                } else {
                    repeatingChars.add(next);
                    maxCharsTotal = Integer.max(maxCharsTotal, repeatingChars.size());
                }
            }
            ptr++;
            startingIdx = ptr;
        }
        return maxCharsTotal;
    }

}
