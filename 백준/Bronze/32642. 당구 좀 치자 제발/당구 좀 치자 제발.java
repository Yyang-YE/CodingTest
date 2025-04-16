import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long stress = 0;
		long total = 0;
		for (int i = 0; i < N; i++) {
			if(st.nextToken().equals("1")) stress++;
			else stress--;
			total += stress;
		}
		System.out.println(total);
	}
}