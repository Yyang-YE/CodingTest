import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean flag;
    static int[] color;
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph.get(s).add(e);
                graph.get(e).add(s);
            }

            flag = true;
            color = new int[N+1];
            visited = new boolean[N+1];
            for (int i = 1; i <= N; i++) {
                if(!flag) break;
                if(!visited[i]) bfs(i);
            }
            bw.write(flag ? "possible\n" : "impossible\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        color[start] = 1;

        int c = 2;
        int qCount = 1;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            qCount--;

            for (int next : graph.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    color[next] = c;
                    queue.add(next);
                } else if(visited[next] && color[next] != c) {
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
