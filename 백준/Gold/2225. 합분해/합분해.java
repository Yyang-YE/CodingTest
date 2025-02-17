import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1); // 1개로 채우는 경우는 항상 1개

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                // 돌기
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
