import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }

        // 그래프 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(src).add(new Node(dst, cost));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dijkstra(S);
        System.out.println(distance[E]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.idx]) continue;
            else visited[cur.idx] = true;

            for (Node next : graph.get(cur.idx)) {
                if(!visited[next.idx] && distance[next.idx] > distance[cur.idx] + next.cost) {
                    distance[next.idx] = distance[cur.idx] + next.cost;
                    pq.add(new Node(next.idx, distance[next.idx]));
                }
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
