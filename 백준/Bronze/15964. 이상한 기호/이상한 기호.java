import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        System.out.println(operand(N, M));
    }

    private static long operand(long a, long b) {
        return (a + b) * (a - b);
    }
}