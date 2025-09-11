import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs() ? "HaruHaru" : "Hing");
    }

    private static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int nx = now.x + board[now.x][now.y] * dx[i];
                int ny = now.y + board[now.x][now.y] * dy[i];

                if(checkArrange(nx, ny) && !visited[nx][ny]) {
                    if(nx == N-1 && ny == N-1) return true;
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
