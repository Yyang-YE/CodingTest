import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()) * 30;
		int V = Integer.parseInt(st.nextToken()) * 30;

		int level =Integer.parseInt(br.readLine());

		int count = 0;
		int time = 0;

		while(level < 250) {
			if(V > 0) {
				count += C;
				V--;
			} else if(S > 0) {
				count += B;
				S--;
			} else {
				count += A;
			}

			if(count >= 100) {
				count -= 100;
				level++;
			}
			time++;
		}
		System.out.println(time);
	}
}
