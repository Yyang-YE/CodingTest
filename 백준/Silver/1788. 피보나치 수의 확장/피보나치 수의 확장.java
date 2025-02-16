import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] dp = new int[Math.abs(n)+1];

        if (n == 0) {
            dp[0] = 0;
        } else if (n >= 0) {
            for (int i = 0; i <= n; i++) {
                if(i == 0) dp[i] = 0;
                else if(i == 1) dp[i] = 1;
                else dp[i] = (dp[i-1] + dp[i-2])  % 1000000000;
            }
        } else {
            for (int i = 0; i <= n*(-1); i++) {
                if(i == 0) dp[i] = 0;
                else if(i == 1) dp[i] = 1;
                else dp[i] = (dp[i-2] - dp[i-1]) % 1000000000;
            }
        }

        // 출력
        int answer = dp[Math.abs(n)];
        if (answer == 0) System.out.println(0);
        else if (answer < 0) System.out.println(-1);
        else System.out.println(1);
        System.out.println(Math.abs(answer));
    }
}
