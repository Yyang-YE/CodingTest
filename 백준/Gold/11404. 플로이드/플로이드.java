import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // A -> B의 버스가 여러대 존재할 수도 있음
            // 따라서 그 중 최소 비용을 선택
            if(graph[src][dst] > cost) graph[src][dst] = cost;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(graph[j][i] != INF && graph[i][k] != INF) { // 연결되어 있다면
                        graph[j][k] = Math.min(graph[j][i] + graph[i][k], graph[j][k]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) bw.write("0 ");
                else bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
