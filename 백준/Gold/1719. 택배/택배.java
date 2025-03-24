import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 987654321;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c, 0));
            graph.get(e).add(new Node(s, c, 0));
        }

        int[][] route = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            route[i] = dijkstra(i).clone();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) bw.write("- ");
                else bw.write(route[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        pq.add(new Node(start, 0, start));

        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        int[] first = new int[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.cost > distance[now.idx]) continue;
            for (Node next : graph.get(now.idx)) {
                if(distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;

                    // 첫 노드값 확인
                    first[next.idx] = first[next.idx] == 0 && now.cost == 0 ? next.idx : now.first;

                    pq.add(new Node(next.idx, distance[next.idx], first[next.idx]));
                }
            }
        }
        return first;
    }

    public static class Node {
        int idx;
        int cost;
        int first;

        public Node(int idx, int cost, int first) {
            this.idx = idx;
            this.cost = cost;
            this.first = first;
        }
    }
}
