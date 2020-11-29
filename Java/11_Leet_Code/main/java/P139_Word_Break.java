import java.util.ArrayList;
import java.util.List;

public class P139_Word_Break {

    public static void main(String[] args) {
        P139_Word_Break solution = new P139_Word_Break();
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        System.out.println(solution.wordBreak("leetcode", words));
    }

    public boolean wordBreak(String str, List<String> words) {
        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxLen = 0;
        for(String s: words) {
            if (s.length() > maxLen)
                maxLen = s.length();
        }


        for (int i = 0; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(i - j > maxLen)
                    continue;

                if (dp[j] && words.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
