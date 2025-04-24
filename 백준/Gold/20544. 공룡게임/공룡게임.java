import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long MOD = 1_000_000_007L;

        // i 번째가 바닥 : 2가 나옴 / 안나옴
        long[][] dp = new long[N+3][2];

        dp[0][1] = 1; // 트리거용
        dp[1][0] = 1; // 1번이 바닥인 경우
        dp[2][0] = 1; // 00 (시작이 바닥이어야 함)
        dp[3][0] = 2; // 000 010
        dp[3][1] = 1; // 020

        for (int i = 4; i <= N+1; i++) {
            // ??00 / ?010 / 0110
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0];
            // i-1 + 0 / i-2(2X) + 20 / i-2(2O) + 10,20 / i-3(2X) + 020,200 / i-3(2O) + 110,120,210
            dp[i][1] = dp[i - 1][1] + dp[i - 2][0] + dp[i - 2][1] * 2 + dp[i - 3][0] * 2 + dp[i - 3][1] * 3;
            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
        }
        System.out.println(dp[N+1][1]);
    }
}
