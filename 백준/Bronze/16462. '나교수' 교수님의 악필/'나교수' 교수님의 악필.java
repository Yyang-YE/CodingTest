import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int total = 0;
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(br.readLine());
			if(score >= 100) {
				total += 100;
			} else {
				int one = score % 10;
				int ten = score / 10;

				if(one == 0 || one == 6) total += 9;
				else total += one;

				// ten이 존재하지 않을 때 문제됨
				if(score >= 10) {
					if (ten == 0 || ten == 6) total += 90;
					else total += ten * 10;
				}
			}
		}
		System.out.println(Math.round((double) total / N));
	}
}