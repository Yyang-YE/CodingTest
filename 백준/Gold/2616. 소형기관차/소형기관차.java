import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] train = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            train[i] = train[i-1] + Integer.parseInt(st.nextToken());
        }
        int C = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][N + 1];
        for (int i = 1; i < 4; i++) {
            for (int j = i * C; j <= N; j++) {
                dp[i][j] = Math.max(dp[i-1][j-C] + (train[j] - train[j-C]), dp[i][j-1]);
            }
        }
        System.out.println(dp[3][N]);
    }
}
