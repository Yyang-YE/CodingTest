import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[][] ingredient;
    static int[][] arr;
    static boolean[] visited;
    static int totalSour = 1;
    static int totalBitter = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // N개 중 M개 뽑기
            arr = new int[i][2];
            visited = new boolean[N];
            dfs(N, i, 0, 0);
        }
        System.out.println(answer);
    }

    public static void dfs(int N, int M, int depth, int least) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                totalSour *= arr[i][0];
                totalBitter += arr[i][1];
            }
            answer = Math.min(answer, Math.abs(totalBitter - totalSour));
            // 초기화
            totalSour = 1;
            totalBitter = 0;
            return;
        }

        for (int i = least; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = ingredient[i];
                dfs(N, M, depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
