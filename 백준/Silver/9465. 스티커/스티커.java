import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int j = 0; j < N; j++) {
                if(j == 0) {
                    dp[0][j] = sticker[0][0];
                    dp[1][j] = sticker[1][0];
                    max = Math.max(dp[0][j], dp[1][j]);
                } else if (j == 1) {
                    dp[0][j] = dp[1][0] + sticker[0][1];
                    dp[1][j] = dp[0][0] + sticker[1][1];
                    max = Math.max(dp[0][j], dp[1][j]);
                } else {
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
                    max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
                }
            }
            bw.write(max + "\n");
        }
        br.close();
        bw.close();
    }
}
