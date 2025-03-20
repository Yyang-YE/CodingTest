import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 8000000;
    static int N, E;
    static List<List<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, c));
            graph.get(e).add(new Edge(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[] oneDist = dijkstra(1);
        int[] uDist = dijkstra(u);
        int[] vDist = dijkstra(v);

        int oneUVN = oneDist[u] + uDist[v] + vDist[N];
        int oneVUN = oneDist[v] + vDist[u] + uDist[N];
        System.out.println((oneUVN >= INF && oneVUN >= INF) ? -1 : Math.min(oneUVN, oneVUN));
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Edge next : graph.get(now.idx)) {
                if(!visited[next.idx] && distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
                    pq.add(new Edge(next.idx, distance[next.idx]));
                }
            }
        }
        return distance;
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
