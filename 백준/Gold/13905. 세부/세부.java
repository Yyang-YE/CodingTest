import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        root = new int[N+1];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing((Edge e) -> e.cost).reversed());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(src, dst, cost));
        }

        int answer = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int a = find(cur.src);
            int b = find(cur.dst);

            if(a != b) {
                union(a, b);

                // src - dst가 연결되었는지 확인
                int srcR = find(S);
                int dstR = find(E);
                if(srcR == dstR) {
                    answer = cur.cost;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) root[b] = a;
    }

    public static int find(int n) {
        if(n == root[n]) return n;
        root[n] = find(root[n]);
        return root[n];
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
