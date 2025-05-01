import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			char[] name = br.readLine().toCharArray();
			for (char c : name) {
				if('A' <= c && c <= 'Z') sb.append(Character.toLowerCase(c));
				else sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}