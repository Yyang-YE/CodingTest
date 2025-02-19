import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static boolean isConnectedFlag;
    static int[] root;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        root = new int[V+1];
        for (int i = 1; i <= V; i++) {
            root[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(src, dst, cost));
        }

        int minTotalCost = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            int a = find(edge.src);
            int b = find(edge.dst);

            if(a != b) { // 아직 연결X
                union(a, b);
                minTotalCost += edge.cost;
            }
            if(isConnectedFlag) break;
        }
        System.out.println(minTotalCost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) {
            root[b] = a;

            if(!map.containsKey(a)) map.put(a, 1);
            if(!map.containsKey(b)) map.put(b, 1);

            map.replace(a, map.get(a) + map.get(b));
            map.remove(b);

            if(map.get(a) == V) isConnectedFlag = true;
        }
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
