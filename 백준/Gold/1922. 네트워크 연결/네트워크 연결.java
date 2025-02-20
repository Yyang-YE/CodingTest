import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(src, dst, cost));
        }

        int totalMinCost = 0;
        int edgeCount = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int a = find(edge.src);
            int b = find(edge.dst);

            if(a != b) {
                union(a, b);
                totalMinCost += edge.cost;
            }
            if(edgeCount == N-1) break;
        }
        System.out.println(totalMinCost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) root[b] = a;
    }

    private static int find(int node) {
        if(root[node] == node) return node;
        root[node] = find(root[node]);
        return root[node];
    }

    public static class Edge {
        int src;
        int dst;
        int cost;

        public Edge(int src, int dst, int cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }
    }
}
