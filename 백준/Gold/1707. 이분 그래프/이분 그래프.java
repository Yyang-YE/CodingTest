import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static boolean flag;
    static boolean[] visited;
    static int[] color;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            visited = new boolean[V+1];
            color = new int[V+1];
            flag = true;
            for (int i = 1; i <= V; i++) {
                if(!flag) break;
                if(!visited[i]) {
                    bfs(i);
                }
            }
            bw.write(flag ? "YES\n" : "NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int start) {
        // BFS로 돌면서 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        visited[start] = true;

        int qCount = 1;
        int c = 2;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            qCount--;

            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    color[next] = c;
                    queue.add(next);
                } else if(color[next] != c) { // 이미 방문 && 색이 다름
                    flag = false;
                    return;
                }
            }

            if(qCount == 0) {
                qCount = queue.size();
                c = c == 1 ? 2 : 1;
            }
        }
    }
}
