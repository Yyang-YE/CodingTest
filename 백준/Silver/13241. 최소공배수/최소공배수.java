import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.println(getLCM(A, B));
	}

	private static long getGCD(long num1, long num2) {
		long result;
		while (num2 != 0) {
			result = num1 % num2;
			num1 = num2;
			num2 = result;
		}
		return num1;
	}

	private static long getLCM(long a, long b) {
		return a * b / getGCD(a, b);
	}
}
