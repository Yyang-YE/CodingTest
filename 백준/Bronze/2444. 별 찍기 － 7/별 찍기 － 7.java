import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            printStar(N, i);
            System.out.println();
        }
        for (int i = N-2; i >= 0; i--) {
            printStar(N, i);
            if(i != 0) System.out.println();
        }
    }

    private static void printStar(int N, int i) {
        for (int j = 1; j <= N + i; j++) {
            if(N - i <= j && j <= N + i) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
    }
}