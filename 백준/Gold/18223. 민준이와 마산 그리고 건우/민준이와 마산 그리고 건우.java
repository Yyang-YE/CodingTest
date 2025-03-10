import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V, E, P;
    static int[] distance;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        // 민준 출발
        visited = new boolean[V+1];
        distance = new int[V+1];
        Arrays.fill(distance, INF);
        dijkstra(1);
        int minToEnd = distance[V];
        int minToGeon = distance[P];

        // 건우 출발
        Arrays.fill(visited, false);
        Arrays.fill(distance, INF);
        dijkstra(P);
        int geonToEnd = distance[V];

        if(minToEnd < minToGeon + geonToEnd) { // 안들르는게 더 빠름
            System.out.println("GOOD BYE");
        } else {
            System.out.println("SAVE HIM");
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if (visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Node node : graph.get(now.idx)) {
                if (!visited[node.idx] && distance[node.idx] > now.cost + node.cost) {
                    distance[node.idx] = now.cost + node.cost;
                    queue.offer(new Node(node.idx, distance[node.idx]));
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
