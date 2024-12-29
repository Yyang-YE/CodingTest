import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] hang = new int[N][M];
        for (int i = 0; i < N; i++) {
            hang[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        // 더하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                hang[i][j] += sc.nextInt();
            }
        }
        
        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(hang[i][j]);
                if(j != M-1) sb.append(" ");
            }
            if(i != N-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}