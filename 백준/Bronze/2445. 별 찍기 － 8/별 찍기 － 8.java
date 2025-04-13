import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int blank = 0;
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (j <= blank || j >= 2*N-1-blank) sb.append("*");
                else sb.append(" ");
            }
            blank += (i < N-1) ? 1 : -1;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}