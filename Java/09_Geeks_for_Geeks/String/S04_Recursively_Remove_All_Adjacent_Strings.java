package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class S04_Recursively_Remove_All_Adjacent_Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String string = input.readLine();
            System.out.println(removeStack(string));
        }
    }

    private static String removeStack(String string) {
        if (string.isEmpty())
            return "";
        if (string.length() == 1)
            return string;

        ArrayDeque<Character> stack = new ArrayDeque<>(string.length());
        stack.addLast(string.charAt(0));

        int ptr = 1;
        while (ptr < string.length()) {
            char prev = string.charAt(ptr - 1);
            char curr = string.charAt(ptr);

            if (prev != curr) {
                stack.addLast(curr);
                ptr++;
            } else {
                while (ptr < string.length() && string.charAt(ptr) == prev) {
                    ptr++;
                }
                stack.removeLast();
            }
        }
        StringBuilder cleaned = new StringBuilder();
        while (!stack.isEmpty()) {
            cleaned.append(stack.removeFirst());
        }
        if (!string.equals(cleaned.toString())) {
            return removeStack(cleaned.toString());
        }
        return cleaned.toString();
    }

    private static void bruteForce(BufferedReader input, int numberOfTestCases) throws IOException {
        for (int i = 0; i < numberOfTestCases; i++) {
            String strToRemoveAdjacentDuplicates = input.readLine();
            String removed = removeAdjacentDuplicates(strToRemoveAdjacentDuplicates);
            if (!removed.equals(strToRemoveAdjacentDuplicates)) {
                while (!removed.equals(removeAdjacentDuplicates(removed))) {
                    removed = removeAdjacentDuplicates(removed);
                }
            }
            System.out.println(removed);
        }
    }

    private static String removeAdjacentDuplicates(String string) {
        StringBuilder cleanedWord = new StringBuilder(string.length());

        int currCharPtr = 0;

        while (currCharPtr < string.length()) {
            char currChar = string.charAt(currCharPtr);
            if ((currCharPtr + 1) < string.length()) {
                char nextChar = string.charAt(currCharPtr + 1);
                if (currChar == nextChar) {
                    while (currCharPtr < string.length() && string.charAt(currCharPtr) == currChar) {
                        currCharPtr++;
                    }
                } else {
                    cleanedWord.append(currChar);
                    currCharPtr++;
                }
            } else {
                cleanedWord.append(string.charAt(currCharPtr));
                break;
            }
        }


        return cleanedWord.toString();
    }
}
