import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : set) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}