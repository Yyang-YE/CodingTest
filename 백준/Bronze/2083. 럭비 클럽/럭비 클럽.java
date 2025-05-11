import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int kg = Integer.parseInt(st.nextToken());

			if(name.equals("#") && age == 0 && kg == 0) break;

			if(age > 17 || kg >= 80) bw.write(name + " Senior\n");
			else bw.write(name + " Junior\n");
		}
		br.close();
		bw.close();
	}
}
