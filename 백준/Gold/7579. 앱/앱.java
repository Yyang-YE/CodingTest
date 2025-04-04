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

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] memory = new int[N]; // 천만까지... 평범하게는 무리
        int[] cost = new int[N];
        int maxCost = 0;
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            maxCost += cost[i];
        }

        // DP - 냅색 문제
        int minCost = Integer.MAX_VALUE;
        int[][] dp = new int[N][maxCost + 1]; // 앱 100 * 비용 100
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= maxCost; j++) {
                if(i == 0) { // 0번째 앱에 대해 처리
                    if(j >= cost[i]) dp[i][j] = memory[i];
                } else {
                    if(j >= cost[i]) {
                        // i번째 안 넣을 때, 넣을 때 중 최대로 선택
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost[i]] + memory[i]);
                    } else { // i번째 못넣으니까 그냥 원래거 넣기
                        dp[i][j] = dp[i-1][j];
                    }
                }
                // M보다 큰 메모리 확보 중 가장 작은 cost
                if (dp[i][j] >= M) minCost = Math.min(j, minCost);
            }
        }
        System.out.println(minCost);
    }
}
