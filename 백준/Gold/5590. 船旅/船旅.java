import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 987654321;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0) {
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                bw.write(dijkstra(src, dst) + "\n");
            } else { // 추가
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Edge(e, c));
                graph.get(e).add(new Edge(s, c));
            }
        }
        br.close();
        bw.close();
    }

    public static int dijkstra(int src, int dst) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(distance, INF);
        distance[src] = 0;
        pq.offer(new Edge(src, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Edge next : graph.get(now.idx)) {
                if(!visited[next.idx] && distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
                    pq.offer(new Edge(next.idx, distance[next.idx]));
                }
            }
        }
        return distance[dst] == INF ? -1 : distance[dst];
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
