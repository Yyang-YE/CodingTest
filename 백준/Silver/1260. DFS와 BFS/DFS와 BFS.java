import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1]; // 1부터 시작

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = graph[v2][v1] = 1; // 거리 고려X 이므로 1로 설정
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    // dfs (재귀)
    public static void dfs(int v) {
        visited[v] = true; // 현재 노드 방문 처리
        sb.append(v).append(" ");

        for (int i = 1; i < graph.length; i++) {
            // V와 연결되어 있는 노드 중 방문하지 않은 노드 -> 재귀호출
            if(graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

//    // dfs (스택)
//    public static void dfs(int v) {
//        Stack<Integer> stack = new Stack();
//        stack.push(v);
//
//        while(!stack.isEmpty()) {
//            int curV = stack.pop();
//            if(!visited[curV]) {
//                visited[curV] = true;
//                sb.append(curV).append(" ");
//
//                for (int i = graph.length - 1; i > 0; i--) {
//                    if(graph[curV][i] == 1 && !visited[i]) {
//                        stack.push(i);
//                    }
//                }
//            }
//        }
//    }


    // bfs (큐)
    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int curV = q.poll();
            sb.append(curV).append(" ");

            for (int i = 1; i < graph.length; i++) {
                if (graph[curV][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}