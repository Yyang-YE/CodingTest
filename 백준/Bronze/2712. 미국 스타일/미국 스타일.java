import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			double n = Double.parseDouble(st.nextToken());
			String unit = st.nextToken();

			if(unit.equals("kg")) { // to pound
				bw.write(String.format("%.4f", n * 2.2046) + " lb\n");
			} else if(unit.equals("lb")) { // to kg
				bw.write(String.format("%.4f", n * 0.4536) + " kg\n");
			} else if(unit.equals("l")) {
				bw.write(String.format("%.4f", n * 0.2642) + " g\n");
			} else if(unit.equals("g")) {
				bw.write(String.format("%.4f", n * 3.7854) + " l\n");
			}
		}
		br.close();
		bw.close();
	}
}
