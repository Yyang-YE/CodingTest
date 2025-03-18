import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static final int INF = 1000000001; // (V)10000 * (w)100000 기준
    static List<List<Edge>> graph = new ArrayList<>();
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(s).add(new Edge(e, w));
            graph.get(e).add(new Edge(s, w));
        }

        // 시작점 -> distance[] 정보 관리
        HashMap<Integer, int[]> map = new HashMap<>();

        // 아주머니 경로 저장
        int[] route = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            int rNum = Integer.parseInt(st.nextToken());
            route[i] = rNum;
        }

        // 나 -> 다른 노드 최소 경로 계산
        int mStart = Integer.parseInt(br.readLine());
        map.put(mStart, dijkstra(mStart));

        // 계산
        long yoTime = 0;
        int min = INF;
        if(route[0] != mStart) {
            // 이전 -> 현재 이동 시간 계산
            for (int i = 1; i < 10; i++) {
                int src = route[i-1]; // 시작점

                // 다익스트라 정보 넣기
                if(!map.containsKey(src)) map.put(src, dijkstra(src));
                int distance = map.get(src)[route[i]]; // i의 도착지
                while(distance == INF && ++i < 10) {
                    distance = map.get(src)[route[i]];
                }
                // dst가 10이상인 경우 잡기
                if(i == 10) break;

                yoTime += distance;
                int myTime = map.get(mStart)[route[i]];

                // 가능하면 최소 노드 번호 구하기
                if(yoTime != INF && myTime != INF && yoTime >= myTime) {
                    min = Math.min(min, route[i]);
                }
            }
        } else { // 동일 시작이면 무조건 바로 가능
            min = route[0];
        }
        System.out.println(min == INF ? -1 : min);
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));
        boolean[] visited = new boolean[V+1];
        int[] distance = new int[V+1];

        Arrays.fill(distance, INF);
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.idx]) continue;
            else visited[now.idx] = true;

            for (Edge next : graph.get(now.idx)) {
                if(!visited[next.idx] && distance[next.idx] > now.cost + next.cost) {
                    distance[next.idx] = now.cost + next.cost;
                    pq.add(new Edge(next.idx, distance[next.idx]));
                }
            }
        }
        return distance;
    }

    public static class Edge {
        int idx;
        int cost;

        public Edge (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
