import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 987654321;
    static int[][] bus;
    static int[][] prev; // i -> j 까지의 최단 경로 가기 위한 j 직전 노드 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        bus = new int[N+1][N+1];
        prev = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(bus[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus[a][b] = Math.min(bus[a][b], c);
            prev[a][b] = a;
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) { // 경유지
            for (int i = 1; i <= N; i++) { // 출발지
                if(k == i) continue;
                for (int j = 1; j <= N; j++) { // 도착지
                    if(k == j || i == j) continue;
                    if(bus[i][j] > bus[i][k] + bus[k][j]) {
                        bus[i][j] = bus[i][k] + bus[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }

        // 전체 비용 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write((bus[i][j] == INF ? 0 : bus[i][j]) + " ");
            }
            bw.write("\n");
        }

        // 경로 출력
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(bus[i][j] == INF) {
                    bw.write("0\n");
                    continue;
                }

                // 경로 존재
                int k = j;
                while(true) {
                    stack.push(prev[i][k]);
                    if(prev[i][k] == i) break;
                    k = prev[i][k];
                }

                bw.write(stack.size()+1 + " ");
                while(!stack.isEmpty()) {
                    bw.write(stack.pop() + " ");
                }
                bw.write(j + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
