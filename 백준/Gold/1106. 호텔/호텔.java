import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 인원 많아도 더 낮은 가격일 가능성 존재
        int[] dp = new int[C+100];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int ppl = Integer.parseInt(st.nextToken());

            // j명의 최소 비용 vs 현재 도시 추가 홍보 시 j명 최소 비용
            for (int j = ppl; j < C + 100; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - ppl]);
            }
        }

        // 최소 인원 탐색
        int answer = MAX;
        for (int i = C; i < C + 100; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
