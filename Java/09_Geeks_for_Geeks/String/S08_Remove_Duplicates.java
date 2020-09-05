package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class S08_Remove_Duplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String line = input.readLine();
            System.out.println(arr(line));
        }
    }

    private static String arr(String line) {
        int[] mappedChars = new int[256];
        StringBuilder distinctWord = new StringBuilder(line.length());
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (mappedChars[c] != 1) {
                mappedChars[c] = 1;
                distinctWord.append(c);
            }
        }
        return distinctWord.toString();
    }

    private static String hashSet(String line) {
        Set<Character> uniqueChars = new HashSet<>(line.length());
        StringBuilder distinctWord = new StringBuilder(line.length());
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (!uniqueChars.contains(c)) {
                distinctWord.append(c);
                uniqueChars.add(c);
            }
        }
        return distinctWord.toString();
    }

    private static String linkedHashSet(String line) {
        LinkedHashSet<Character> distinct = new LinkedHashSet<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            distinct.add(line.charAt(i));
        }
        StringBuilder str = new StringBuilder(distinct.size());
        for (Character character : distinct) {
            str.append(character);
        }
        return str.toString();
    }
}
