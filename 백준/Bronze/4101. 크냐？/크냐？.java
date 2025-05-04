import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while(true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A == 0 && B == 0) break;
			if (A > B) sb.append("Yes\n");
			else sb.append("No\n");
		}
		System.out.println(sb);
	}
}