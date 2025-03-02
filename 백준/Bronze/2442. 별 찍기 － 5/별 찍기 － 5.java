import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int len = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N + len; j++) {
                if(j < N-len-1) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
            len++;
        }
        System.out.println(sb);
    }
}
