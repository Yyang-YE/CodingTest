import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int cnt = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(o == 0 && w == 0) break;

			boolean isDead = false;
			while(true) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				if(cmd == '#' && n == 0) break;
				if(isDead) continue;

				if(cmd == 'E') {
					w -= n;
					if(w <= 0) isDead = true;
				} else if(cmd == 'F') {
					w += n;
				}
			}

			bw.write(++cnt + " ");
			if(isDead) bw.write("RIP\n");
			else if(o / 2 < w && w < o * 2) bw.write(":-)\n");
			else bw.write(":-(\n");
		}
		br.close();
		bw.close();
	}
}
