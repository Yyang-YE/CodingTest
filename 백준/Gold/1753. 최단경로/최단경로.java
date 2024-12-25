import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        // 인풋의 index 그대로 사용하기 위해 0번을 버리고 사용
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if(dist[i] == INF) bw.write("INF");
            else bw.write(String.valueOf(dist[i]));
            if(i != V) bw.write("\n");
        }
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int cur = currentNode.end;

            if(check[cur]) continue;
            check[cur] = true;

            for (Node node : graph[cur]) {
                // 현재 dist보다 새로운 dist가 더 작다면 update
                if(dist[node.end] > dist[cur] + node.cost) {
                    dist[node.end] = dist[cur] + node.cost;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}