import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Node[] graph = new Node[N+1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new Node(i, Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].adjacentList.add(y);
                graph[y].indegree++;
            }

            // indegree == 0 이면 Queue에 넣기
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if(graph[i].indegree == 0) {
                    queue.offer(i);
                }
            }

            // 위상정렬
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for (int i : graph[node].adjacentList) {
                    graph[i].result = Math.max(graph[i].result, graph[node].result + graph[i].cost);
                    graph[i].indegree--;

                    if(graph[i].indegree == 0) {
                        queue.offer(i);
                    }
                }
            }
            int W = Integer.parseInt(br.readLine());
            bw.write(graph[W].result + "\n");
        }
        br.close();
        bw.close();
    }

    public static class Node {
        int idx;
        int cost;
        int result;
        int indegree = 0;
        List<Integer> adjacentList = new ArrayList<>();

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
            this.result = cost;
        }
    }
}
