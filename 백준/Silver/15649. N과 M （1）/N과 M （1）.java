import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) { // M개 다 가져온 경우
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // depth번째 요소의 값 설정
                arr[depth] = i+1;
                dfs(N, M, depth+1); // 다음 값 확인하기
                visited[i] = false; // 다 돌고 나면 다시 false로 초기화(재귀돌며 전체 false됨)
            }
        }
    }
}