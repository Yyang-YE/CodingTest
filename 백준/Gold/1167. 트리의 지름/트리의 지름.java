import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 임의의 한 점에서 가장 먼 점과, 그 점에서 가장 먼 점이 지름의 양 끝단
public class Main {
    static int N, max, end;
    static boolean[] visited;
    static List<List<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            while(e != -1) {
                int c = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Edge(e, c));
                e = Integer.parseInt(st.nextToken());
            }
        }

        // 임의의 한 지점에서 돌려서 가장 먼 정점 구하기
        visited = new boolean[N+1];
        dfs(1, 0);
        
        // 지름 구하기
        visited = new boolean[N+1];
        dfs(end, 0);

        System.out.println(max);
    }

    public static void dfs(int now, int len) {
        if(len > max) {
            end = now; // 첫번째용
            max = len; // 두번째용
        }

        visited[now] = true;
        for (Edge next : graph.get(now)) {
            if(!visited[next.idx]) {
                dfs(next.idx, len+next.cost);
            }
        }
    }

    public static class Edge {
        int idx;
        int cost;

        public Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
