import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static final int INF = 987654321;
    static int[] distance;
    static List<List<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            if(i > 0) items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, c));
            graph.get(e).add(new Edge(s, c));
        }

        // 전체 돌면서 각 경우의 최대값을 구하기
        int maxItem = 0;
        for (int i = 1; i <= n; i++) {
            distance = new int[n+1];
            dijkstra(i);

            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if(distance[j] <= m) temp += items[j];
            }
            maxItem = Math.max(maxItem, temp); // 더 큰 값으로 갱신
        }
        System.out.println(maxItem);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        boolean[] visited = new boolean[n+1];

        pq.offer(new Edge(start, 0));
        Arrays.fill(distance, INF);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Edge next : graph.get(now.idx)) {
                if(!visited[next.idx] && distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
                    pq.add(new Edge(next.idx, distance[next.idx]));
                }
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
