import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] count;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        count = new int[N+1];
        visited = new boolean[N+1];
        visited[R] = true;
        dfs(R);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            bw.write(count[q] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int dfs(int cur) {
        int total = 1;
        for (int next : graph.get(cur)) {
            if(!visited[next]) {
                visited[next] = true;
                total += dfs(next);
            }
        }
        return count[cur] = total;
    }
}
