import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] triangle = new int[3];

			triangle[0] = Integer.parseInt(st.nextToken());
			triangle[1] = Integer.parseInt(st.nextToken());
			triangle[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(triangle);

			bw.write("Scenario #" + i + ":\n");
			bw.write((Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2], 2) ? "yes" : "no") + "\n\n");
		}

		br.close();
		bw.close();
	}
}