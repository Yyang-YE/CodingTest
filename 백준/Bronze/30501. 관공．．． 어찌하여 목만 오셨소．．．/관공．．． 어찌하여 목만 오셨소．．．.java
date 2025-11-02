import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String answer = "";
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(!flag && tmp.contains("S")) {
				answer = tmp;
				flag = true;
			}
		}
		System.out.println(answer);
	}
}
