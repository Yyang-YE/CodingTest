import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int mingook = 0;
		int mansae = 0;
		for (int i = 0; i < 4; i++) {
			mingook += Integer.parseInt(st1.nextToken());
			mansae += Integer.parseInt(st2.nextToken());
		}
		System.out.println(Math.max(mingook, mansae));
	}
}
