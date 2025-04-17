import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j+1));

                // 0이면 그대로 0 ->불가
                if(map[i][j] == 0) continue;

                dp[i][j] = 1; // 기본 1
                if(i > 0 && j > 0) {
                    int minus = 0;
                    while (dp[i - 1][j - 1] - minus > 0) {
                        // 수를 줄여가면서 가능한지 확인
                        if (dp[i - 1][j] >= dp[i - 1][j - 1] - minus && dp[i][j - 1] >= dp[i - 1][j - 1] - minus) {
                            dp[i][j] = dp[i - 1][j - 1] - minus + 1; // 조건 만족하면 올리기
                            break;
                        }
                        minus++;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max*max);
    }
}
