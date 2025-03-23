import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Cost[][] cost = new Cost[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cost[i][j] = new Cost(0, 0, 0);
            }
        }

        cost[0][1].garo = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(map[i][j] == 1) continue;
                if(i == 0 && j == 2 && map[i][j] == 0) {
                    cost[i][j].garo = 1;
                    continue;
                }

                // 가로에서 넘어오는 경우
                if(map[i][j-1] != 1) {
                    cost[i][j].garo = cost[i][j-1].garo + cost[i][j-1].dae;
                }
                // 세로에서 넘어오는 경우
                if(i > 0 && map[i-1][j] != 1) {
                    cost[i][j].sero = cost[i-1][j].sero + cost[i-1][j].dae;
                }
                // 대각선에서 넘어오는 경우
                if(i > 0 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1) {
                    cost[i][j].dae = cost[i-1][j-1].garo + cost[i-1][j-1].sero + cost[i-1][j-1].dae;
                }
            }
        }
        System.out.println(cost[N-1][N-1].garo + cost[N-1][N-1].sero + cost[N-1][N-1].dae);
    }

    public static class Cost {
        int garo;
        int sero;
        int dae;

        public Cost (int garo, int sero, int dae) {
            this.garo = garo;
            this.sero = sero;
            this.dae = dae;
        }
    }
}
