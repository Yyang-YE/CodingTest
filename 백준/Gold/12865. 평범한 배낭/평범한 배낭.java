import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// Item
		Item[] items = new Item[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// N 까지의 아이템으로 K보다 작은 무게로 만들 수 있는 최대 가치
		int[][] dp = new int[N+1][K+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(items[i].w > j) { // i번째 무게를 담을 수 없음
					dp[i][j] = dp[i-1][j]; // i-1번째까지의 최대로 설정
				} else { // i번째 담을 수 있음
					// j-w의 최대에서 현재 것을 담았을 경우
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - items[i].w] + items[i].v);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

	public static class Item {
		int w; // 무게
		int v; // 가치

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}
