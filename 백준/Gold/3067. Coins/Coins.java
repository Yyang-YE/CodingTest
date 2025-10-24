import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            long[] dp = new long[M+1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                int c = coins[i];
                for (int j = c; j <= M; j++) {
                    dp[j] += dp[j - c];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
