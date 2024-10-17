import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        System.out.println(factorial(N-K+1, N) / factorial(1, K));
    }

    public static long factorial(int start, int end) {
        long result = 1L;
        for (int i = start; i <= end; i++) {
            result *= i;
        }
        return result;
    }
}