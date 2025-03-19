import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] distance, answer;
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        distance = new long[N+1];
        answer = new long[N+1];
        Arrays.fill(distance, INF);

        dijkstra(1);

        long total = 0L;
        for (int i = 1; i <= N; i++) {
            total += answer[i];
        }
        System.out.println(total);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.cost));

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 현재 저장된 값이 최소면 아래 로직 불필요
            if(distance[now.idx] < now.cost) continue;

            for (Node next : graph.get(now.idx)) {
                long cost = distance[now.idx] + next.cost;
                if(distance[next.idx] > cost) {
                    answer[next.idx] = (long) (distance[now.idx] * 0.9) + next.cost;
                    distance[next.idx] = cost;
                    pq.offer(new Node(next.idx, cost));
                } else if(distance[next.idx] == cost) {
                    answer[next.idx] = Math.min(distance[next.idx], (long) (distance[now.idx] * 0.9) + next.cost);
                }
            }
        }
    }

    public static class Node {
        int idx;
        long cost;

        public Node (int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
