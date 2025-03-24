import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 987654321;
    static int[][] map, cost;

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Arrays.fill(cost[i], INF);
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(cost[N-1][N-1] == INF ? 0 : cost[N-1][N-1]);
    }

    public static void bfs() {
        PriorityQueue<Coord> pq = new PriorityQueue<>(Comparator.comparing(c -> c.changed));
        pq.offer(new Coord(0, 0, 0));

        while(!pq.isEmpty()) {
            Coord now = pq.poll();

            if(cost[now.x][now.y] < now.changed) continue;

            for (int i = 0; i < 4; i++) {
                int cx = xs[i] + now.x;
                int cy = ys[i] + now.y;

                if(!checkArrange(cx, cy)) continue;

                int plus = (map[cx][cy] == 0) ? 1 : 0;
                if(cost[cx][cy] > now.changed + plus) {
                    cost[cx][cy] = now.changed + plus;
                    pq.offer(new Coord(cx, cy, cost[cx][cy]));
                }
            }
        }
    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Coord {
        int x;
        int y;
        int changed;

        public Coord(int x, int y, int changed) {
            this.x = x;
            this.y = y;
            this.changed = changed;
        }
    }
}
