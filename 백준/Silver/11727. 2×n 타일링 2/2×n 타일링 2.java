import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(i == 1) memo[i] = 1;
            else if(i == 2) memo[i] = 3;
            else memo[i] = (memo[i-1] + (memo[i-2] * 2)) % 10007;
        }
        System.out.println(memo[n]);
    }
}
