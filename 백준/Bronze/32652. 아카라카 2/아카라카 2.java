import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("AKA");
		for (int i = 0; i < K; i++) {
			sb.append("RAKA");
		}
		System.out.println(sb);
	}
}