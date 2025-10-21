import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        // 화폐 정렬
        Arrays.sort(money);

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0; i < money.length; i++) {
            int m = money[i];
            for(int j = money[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - m]) % 1000000007;
            }
        }
        return dp[n];
    }
}