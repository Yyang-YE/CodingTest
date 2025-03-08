import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N, M, W;
    static int[] distance;
    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            distance = new int[N+1];
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // M: 양방향, W: 단방향 Edge
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(i < M) {
                    graph.get(s).add(new Edge(e, c));
                    graph.get(e).add(new Edge(s, c));
                } else {
                    graph.get(s).add(new Edge(e, c * -1));
                }
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if(bellmanFord(i)) { // 하나라도 음수 가중치이면 YES
                    isMinusCycle = true;
                    bw.write("YES\n");
                    break;
                }
            }
            if(!isMinusCycle) bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;

            // 최단 거리 초기화
            for (int j = 1; j <= N; j++) {
                for (Edge edge : graph.get(j)) {
                    if(distance[j] != INF && distance[edge.end] > distance[j] + edge.cost) {
                        distance[edge.end] = distance[j] + edge.cost;
                        update = true;
                    }
                }
            }

            // 더이상 최단거리 초기화가 일어나지 않으면 반복문 종료 (반복 횟수 줄이기용?)
            if(!update) break;
        }

        // 정점 개수-1까지 계속 업데이트 발생 & N번에도 업데이트 발생하면 음수 사이클 발생한 것
        if(update) {
            for (int i = 1; i <= N; i++) {
                for (Edge edge : graph.get(i)) {
                    if(distance[i] != INF && distance[edge.end] > distance[i] + edge.cost) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class Edge {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
