import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        int T = Integer.parseInt(br.readLine());
        int curMax = 5;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N > curMax) { // 아직 계산되지 않은 경우
                for (int j = curMax+1; j <=N ; j++) {
                    dp[j] = dp[j-1] + dp[j-5];
                }
                curMax = N;
                sb.append(dp[N]).append("\n");
            } else { // 이전에 계산된 경우
                sb.append(dp[N]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
