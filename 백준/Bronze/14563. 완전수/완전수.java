import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(st.nextToken());
			if(N == 1) {
				bw.write("Deficient\n");
				continue;
			}
			int total = getTotal(N);

			if(N > total) bw.write("Deficient\n");
			else if(N == total) bw.write("Perfect\n");
			else bw.write("Abundant\n");
		}
		br.close();
		bw.close();
	}

	public static int getTotal(int N) {
		int total = 1; // 1은 모든 수의 약수
 		for (int i = 2; i <= Math.sqrt(N); i ++) {
			if(N % i == 0) {
				total += i;
				if (N != i * i) total += (N / i);
			}
		}
		return total;
	}
}
