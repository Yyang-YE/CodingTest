import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] memo = new int[K+1];
        Arrays.fill(memo, INF);
        memo[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                memo[j] = Math.min(memo[j], memo[j-coins[i]] + 1);
            }
        }
        System.out.println(memo[K] == INF ? -1 : memo[K]);
    }
}
