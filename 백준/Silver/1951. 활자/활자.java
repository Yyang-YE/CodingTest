import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long total = 0;
        int len = String.valueOf(N).length();
        long cur = 1;

        // len-1 자리까지는 무조건 전부 참
        for (int i = 1; i < len; i++) {
            total += 9L * cur * i; // (숫자 * 각 개수) * 자리수
            cur *= 10;
            total %= 1234567;
        }

        // 가장 큰 수
        total += (N - cur + 1) * len;
        System.out.println(total % 1234567);
    }
}
