import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result = -1;
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            if(now.x == N-1 && now.y == M-1) {
                result = now.distance;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];

                if(checkArrange(curX, curY)) {
                    // 안부순 상태로 이동
                    if(map[curX][curY] == 0 && !visited[curX][curY][now.broken]) {
                        queue.offer(new Coord(curX, curY, now.distance+1, now.broken));
                        visited[curX][curY][now.broken] = true;
                    }

                    // 부수고 이동
                    if(map[curX][curY] == 1 && !visited[curX][curY][1] && now.broken == 0) {
                        queue.offer(new Coord(curX,curY, now.distance+1, 1));
                        visited[curX][curY][1] = true;
                    }
                }
            }
        }
    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static class Coord {
        int x;
        int y;
        int distance;
        int broken;

        public Coord(int x, int y, int distance, int broken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }
}
