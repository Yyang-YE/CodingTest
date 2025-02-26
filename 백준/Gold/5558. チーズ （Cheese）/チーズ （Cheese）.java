import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int H, W, N;
    static int countTime;
    static char[][] map;
    static Coord[] factories;

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        factories = new Coord[N+1];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                map[i][j] = c;

                // 공장 위치 정보 관리
                if('1' <= c && c <= '9') {
                    factories[c - '0'] = new Coord(i, j);
                } else if(c == 'S') {
                    factories[0] = new Coord(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            // 순차적으로 방문
            route(factories[i], factories[i+1]);
        }

        System.out.println(countTime);
    }

    // BFS로 찾기
    public static void route(Coord src, Coord dst) {
        boolean[][] visited = new boolean[H][W];

        Queue<Coord> queue = new LinkedList<>();
        Queue<Coord> tempQ = new LinkedList<>();
        queue.add(src);
        visited[src.x][src.y] = true;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];

                if(curX == dst.x && curY == dst.y) {
                    countTime++;
                    return;
                }

                if(checkRange(curX, curY) && map[curX][curY] != 'X' && !visited[curX][curY]) {
                    tempQ.add(new Coord(curX, curY));
                    visited[curX][curY] = true;
                }
            }

            if(queue.isEmpty()) {
                queue.addAll(tempQ);
                tempQ.clear();
                countTime++;
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
