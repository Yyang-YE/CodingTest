import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        while(N > 0) {
            for (int i = 0; i < N; i++) {
                sb.append("*");
            }
            sb.append("\n");
            N--;
        }
        System.out.println(sb);
    }
}
