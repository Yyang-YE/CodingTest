import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int max = W*W + H*H;
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());
			if(len*len <= max) sb.append("DA\n");
			else sb.append("NE\n");
		}
		System.out.println(sb);
	}
}