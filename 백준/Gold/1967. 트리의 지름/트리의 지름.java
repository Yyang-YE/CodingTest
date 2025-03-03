import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Node(d, cost));
            graph.get(d).add(new Node(s, cost));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }

    public static void dfs(int node, int total) {
        max = Math.max(max, total);

        // 자식들에 대해 작업 수행
        for (Node n : graph.get(node)) {
            if(!visited[n.idx]) {
                visited[n.idx] = true;
                dfs(n.idx, total+n.cost);
                visited[n.idx] = false;
            }
        }
    }

    public static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
