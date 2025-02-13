import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[N][K+1];
        for (int i = 0; i < N; i++) { // item 개수
            for (int j = 1; j <= K; j++) { // 무게
                if(i==0) {
                    if(j < items[i].W) dp[i][j] = 0;
                    else dp[i][j] = items[i].V;
                } else {
                    if (j >= items[i].W) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i].W] + items[i].V);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[N-1][K]);
    }

    public static class Item {
        int W;
        int V;

        public Item(int W, int V) {
            this.W = W;
            this.V = V;
        }
    }
}
