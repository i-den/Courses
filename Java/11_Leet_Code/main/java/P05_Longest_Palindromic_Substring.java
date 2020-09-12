public class P05_Longest_Palindromic_Substring {

    public String longestPalindromeExpandCenter(String string) {
        if (string == null || string.isEmpty())
            return "";
        int subStrStartIdx = 0;
        int subStrEndIdx = 0;

        for (int i = 0; i < string.length(); i++) {
            int expansionFromCurrChar = expandAroundCenter(string, i, i);
            int expansionFromNextChar = expandAroundCenter(string, i, i + 1); //account for two chars one to another, i.e. "xxc" <- xx
            int expansionLength = Integer.max(expansionFromCurrChar, expansionFromNextChar);
            if (expansionLength > (subStrEndIdx - subStrStartIdx)) {
                subStrStartIdx = i - (expansionLength - 1) / 2;
                subStrEndIdx = i + expansionLength / 2;
            }
        }

        return string.substring(subStrStartIdx, subStrEndIdx + 1);
    }

    private int expandAroundCenter(String string, int left, int right) {
        while (left >= 0 && right < string.length() && (string.charAt(left) == string.charAt(right))) {
            left--;
            right++;
        }
        return  right - left - 1;
    }



    private String longestPalindromeBruteForce(String string) {
        if (string.isEmpty())
            return "";
        String largestPalindrome = "";
        for (int i = 0; i < string.length(); i++) {
            char leftChar = string.charAt(i);
            int lastCharIdx = string.lastIndexOf(leftChar);
            while (lastCharIdx > 0 && lastCharIdx != i) {
                if (isPalindrome(string, i, lastCharIdx - 1)) {
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

    private boolean isPalindrome(String string, int leftIdx, int rightIdx) {
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
