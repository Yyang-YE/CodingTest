import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cmd = br.readLine().toCharArray();

		int cnt = 0;
		for (int i = 1; i < cmd.length; i++) {
			char c = cmd[i];
			if('A' <= c && c <= 'Z' && (i + cnt) % 4 != 0) { // i+cnt: 완벽할 시 idx
				cnt += 4 - (i + cnt) % 4; // 부족한 만큼 추가
			}
		}
		System.out.println(cnt);
	}
}