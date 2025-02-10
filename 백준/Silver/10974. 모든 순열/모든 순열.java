import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        permutation(N, N, 0);

        bw.flush();
        bw.close();
    }

    public static void permutation(int N, int M, int depth) throws IOException {
        // 전부 찾으면 sb에 입력
        if(depth == N) {
            for (int i = 0; i < N; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                arr[depth] = i + 1;
                visited[i] = true;
                permutation(N, M-1,depth+1);
                visited[i] = false;
            }
        }
    }
}
