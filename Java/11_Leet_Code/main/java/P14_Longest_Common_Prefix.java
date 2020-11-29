import java.util.Arrays;
import java.util.Comparator;

public class P14_Longest_Common_Prefix {

    public String longestCommonPrefixMerge(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length -1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start >= end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String lcpLeft = longestCommonPrefix(strs, start, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int min = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < min; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i))
                return lcpLeft.substring(0, i);
        }
        return lcpLeft.substring(0, min);
    }


    public String longestCommonPrefixSort(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder str = new StringBuilder();

        String shortest = strs[0];
        for(int i = 0; i < shortest.length(); i++) {
            char c = shortest.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].equals("")) return "";
                if(c != strs[j].charAt(i)) {
                    return str.toString();
                }
            }
            str.append(c);
        }
        return str.toString();
    }
}
