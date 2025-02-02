import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                count++;
                checkConnected(i);
            }
        }
        System.out.println(count);
    }

    private static void checkConnected(int start) {
        for (int i = 1; i <= N; i++) {
            if(graph[start][i] == 1 && !visited[i]) { // 연결된 노드, 아직 미방문
                visited[i] = true;
                checkConnected(i);
            }
        }
    }
}