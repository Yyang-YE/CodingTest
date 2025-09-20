import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 미리 채워놓기
        long[][] dp = new long[31][31];
        dp[1][0] = 1;
        for (int w = 0; w <= 30; w++) {
            for (int h = 0; h <= 30; h++) {
                if(w < 30) dp[w + 1][h] += dp[w][h]; // 아래로
                if(h < w) dp[w][h+1] += dp[w][h]; // 오른쪽으로
            }
        }

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            sb.append(dp[N][N]).append("\n");
        }
        System.out.println(sb);
    }
}
