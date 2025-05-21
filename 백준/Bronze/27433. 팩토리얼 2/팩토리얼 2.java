import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 0 || N == 1) {
			System.out.println(1);
			return;
		}

		long num = 1;
		for (int i = 2; i <= N; i++) {
			num *= i;
		}
		System.out.println(num);
	}
}