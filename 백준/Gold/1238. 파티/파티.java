import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE - 500;
    static int N, M, X;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance, result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(d, c));
        }

        result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            distance = new int[N+1];
            visited = new boolean[N+1];
            Arrays.fill(distance, INF);

            dijkstra(i);

            // 결과 업데이트
            if(i == X) {
                for (int j = 1; j <= N; j++) {
                    if(j == X) continue;
                    result[j] += distance[j];
                }
            } else {
                result[i] += distance[X];
            }
        }

        // 최대 찾기
        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            maxCost = Math.max(maxCost, result[i]);
        }
        System.out.println(maxCost);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Node next : graph.get(now.idx)) {
                if(!visited[next.idx] && distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
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
