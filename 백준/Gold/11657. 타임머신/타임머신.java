import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final Long INF = Long.MAX_VALUE;
    static long[] dist;
    static List<Edge> graph = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(s, e, c));
        }

        dist = new long[N+1];
        if(!bellmanFord()) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord () {
        Arrays.fill(dist, INF);
        dist[1] = 0; // 1번 도시 출발

        // n-1번 반복 + 검증용 한번 = N번
        for (int i = 1; i <= N; i++) {
            for (Edge e : graph) {
                if(dist[e.start] == INF) continue;
                if(dist[e.end] > dist[e.start] + e.cost) {
                    dist[e.end] = dist[e.start] + e.cost;
                    // 음의 사이클 발생함
                    if(i == N)return false;
                }
            }
        }
        return true;
    }

    public static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
