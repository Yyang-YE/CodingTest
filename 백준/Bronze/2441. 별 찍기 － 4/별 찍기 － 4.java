import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int temp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j < temp) sb.append(" ");
                else sb.append("*");
            }
            temp++;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
