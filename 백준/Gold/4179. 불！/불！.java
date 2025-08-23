import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static int[][] fireTime;
    static boolean[][] visited;
    static List<Coord> fire = new ArrayList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        fireTime = new int[R][C];

        Coord jihoon = new Coord(0, 0, 0);
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(board[i][j] == 'J') {
                    jihoon = new Coord(i, j, 0);
                    board[i][j] = '.';
                } else if(board[i][j] == 'F') {
                    fire.add(new Coord(i, j, 0));
                }
            }
        }

        setFire();
        int time = move(jihoon);
        System.out.println(time == -1 ? "IMPOSSIBLE" : time);
    }

    private static int move(Coord jihoon) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(jihoon);
        visited = new boolean[R][C];
        visited[jihoon.x][jihoon.y] = true;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            // 지훈이 이동
            for (int i = 0; i < 4; i++) {
                int cx = dx[i] + now.x;
                int cy = dy[i] + now.y;
                if(!checkArrange(cx, cy)) {
                    return now.time + 1;
                }

                if(!visited[cx][cy] && board[cx][cy] == '.' && (fire.isEmpty() || fireTime[cx][cy] > now.time + 1)) {
                    queue.offer(new Coord(cx, cy, now.time + 1));
                    visited[cx][cy] = true;
                }
            }
        }
        return -1;
    }

    private static void setFire() {
        if(fire.isEmpty()) return;

        Queue<Coord> queue = new LinkedList<>();
        queue.addAll(fire);

        Coord tmp = queue.peek();
        visited = new boolean[R][C];
        visited[tmp.x][tmp.y] = true;

        int qCount = fire.size();
        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            qCount--;

            for (int i = 0; i < 4; i++) {
                int cx = dx[i] + now.x;
                int cy = dy[i] + now.y;

                if(checkArrange(cx, cy) && !visited[cx][cy] && board[cx][cy] == '.') {
                    queue.offer(new Coord(cx, cy, now.time + 1));
                    fireTime[cx][cy] = now.time + 1;
                    visited[cx][cy] = true;
                }
            }

            if(qCount == 0) {
                qCount = queue.size();
            }
        }
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    public static class Coord {
        int x;
        int y;
        int time;

        public Coord(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
