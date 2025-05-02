import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] paper = new char[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(paper[i], '.');
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				if (c != '.') {
					paper[i][j] = c;
					paper[i][M - j - 1] = c;
				}
			}

			for (int j = 0; j < M; j++) {
				sb.append(paper[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
