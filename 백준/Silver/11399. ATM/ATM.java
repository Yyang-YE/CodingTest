import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }
        sc.nextLine();
        Arrays.sort(P);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i] * (N-i);
        }
        System.out.println(sum);
    }
}