import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;
    static int[] beforeCity;
    static List<List<Edge>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());

        beforeCity = new int[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);

        dijkstra(src);

        // 경로 추적하기
        Stack<Integer> route = new Stack<>();
        int cur = dst;
        while(cur != src) {
            route.add(cur);
            cur = beforeCity[cur];
        }
        route.add(cur); // 시작지 까지 넣어주기

        // 출력
        bw.write(distance[dst] + "\n");
        bw.write(route.size() + "\n");
        while(!route.isEmpty()) {
            bw.write(route.pop() + " ");
        }
        br.close();
        bw.close();
    }

    public static void dijkstra(int src) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        pq.add(new Edge(src, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(now.cost > distance[now.idx]) continue;

            for(Edge next : graph.get(now.idx)) {
                if(distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
                    pq.offer(new Edge(next.idx, distance[next.idx]));
                    beforeCity[next.idx] = now.idx;
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
