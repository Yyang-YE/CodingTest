import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(calculate(A, B, C));
    }

    private static long calculate(long a, long b, long c) {
        if(b == 1) return a % c;
        long halfval = calculate(a, b/2, c);

        if(b % 2 == 1) {
            // 홀수(ex.9) : 4*4*1
            return (halfval * halfval % c) * a % c;
        } else { // 짝수 : 4*4
            return halfval * halfval % c;
        }
    }
}
