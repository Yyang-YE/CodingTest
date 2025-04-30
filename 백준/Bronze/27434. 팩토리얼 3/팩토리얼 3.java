import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N == 0 || N == 1) System.out.println(1);
		else System.out.println(factorial(1, N));
	}

	private static BigInteger factorial(int s, int e) {
		if(s == e) return BigInteger.valueOf(e);
		// 반복 자체보다 BigInteger 생성하면서 시간소요 -> 줄이기 위해 분할 정복
		return factorial(s, (s+e) / 2).multiply(factorial((s + e) / 2 + 1, e));
	}
}