import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(L > 0) {
			if(L >= 5) L -= 5;
			else L = 0;
			cnt++;
		}
		System.out.println(cnt);
	}
}
