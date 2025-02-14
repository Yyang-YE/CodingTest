import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            // i보다 작은 제곱수들을 빼면서, 남은 값의 최소를 참고
            // 각각에 대해 구해서 그 중 최소를 구함
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(dp[i - j*j], min);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }
}
