import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] memo = new int[N+1];
        memo[0] = 1;
        memo[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            memo[i] = (memo[i-2] * 3);
            for (int j = i - 4; j >= 0; j -= 2) {
                memo[i] += memo[j] * 2;
            }
        }
        System.out.println(memo[N]);
    }
}
