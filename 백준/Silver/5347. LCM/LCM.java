import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(LCM(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static long LCM(long a, long b) {
        long gcd = GCD(a, b);
        return a*b/gcd;
    }

    private static long GCD(long a, long b) {
        if(b == 0) return a;
        else return GCD(b, a % b);
    }
}
