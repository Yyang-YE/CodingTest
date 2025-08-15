import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited; // 섬 기록용
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소 다리 길이 구하기
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int length = getMinLength(new Coord(i, j, 0));
                    minLen = Math.min(minLen, length);
                }
            }
        }
        System.out.println(minLen);
    }

    private static int getMinLength(Coord start) {
        boolean[][] tmpVisited = new boolean[N][N];

        PriorityQueue<Coord> pq = new PriorityQueue<>(Comparator.comparing(c -> c.len));
        pq.offer(start);

        visited[start.x][start.y] = true;
        tmpVisited[start.x][start.y] = true;

        int minLen = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Coord now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + xs[i];
                int ny = now.y + ys[i];

                if(checkArrange(nx, ny) && !tmpVisited[nx][ny]) {
                    tmpVisited[nx][ny] = true;

                    if(map[nx][ny] == 1) {
                        if(now.len > 0) { // 다른 섬을 만남
                            minLen = Math.min(minLen, now.len);
                        } else { // 현재 섬
                            pq.offer(new Coord(nx, ny, 0));
                            visited[nx][ny] = true;
                        }
                    } else {
                        pq.offer(new Coord(nx, ny, now.len + 1));
                    }
                }
            }
        }
        return minLen;
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Coord {
        int x;
        int y;
        int len;

        public Coord(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
