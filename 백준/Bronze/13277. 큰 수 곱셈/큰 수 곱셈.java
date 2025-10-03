import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		BigInteger A = new BigInteger(num[0]);
		BigInteger B = new BigInteger(num[1]);
		System.out.println(A.multiply(B));
	}
}
