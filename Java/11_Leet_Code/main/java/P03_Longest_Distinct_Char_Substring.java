import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P03_Longest_Distinct_Char_Substring {

    public static void main(String[] args) {
        P03_Longest_Distinct_Char_Substring solution = new P03_Longest_Distinct_Char_Substring();
        System.out.println(solution.lengthOfLongestSubstring2("abcdcaaz"));
    }

    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int prevOccurringIdx = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                prevOccurringIdx = Integer.max(prevOccurringIdx, map.get(c) + 1);
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, i - prevOccurringIdx + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String str) {
        char[] sChars = str.toCharArray();
        int maxLen = 0;// Keep record for max length;
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        while(fast < str.length()) {
            if (set.contains(sChars[fast])) {
                set.remove(sChars[slow++]);
            } else {
                set.add(sChars[fast++]);
                maxLen = Math.max(fast - slow, maxLen);
            }
        }
        return maxLen;
    }

    public int gfgSolution(String line) {
        if  (line.isEmpty()) {
            return 0;
        }
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
