import java.util.HashMap;
import java.util.Map;

public class P70_Climbing_Stairs {

    public int dp(int n) {
        if(n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return climb(0, n);
    }

    public int climb(int curr, int n) {
        if(map.containsKey(curr))
            return map.get(curr);

        if(curr == n) {
            map.put(curr, 1);
            return 1;
        }
        if(curr > n) {
            map.put(curr, 0);
            return 0;
        }

        int res = climb(curr + 1, n) + climb(curr + 2, n);
        map.put(curr, res);
        return res;
    }
}
