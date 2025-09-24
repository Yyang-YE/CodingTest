import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int SNAKE = 1;
    static final int APPLE = 2;
    static int N, K;
    static int[][] board;

    // 좌로 회전
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 보드 채우기
        board = new int[N][N];
        board[0][0] = SNAKE;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = APPLE;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            queue.offer(new Info(X, C));
        }

        int pointer = 1; // 최초 방향
        int turnCnt = queue.size();
        int time = 0;

        Info info = queue.poll(); // 다음 꺾기

        Queue<Point> snake = new LinkedList<>(); // 순서대로 꼬리가 됨
        snake.offer(new Point(0, 0));
        Point head = new Point(0, 0);

        while(true) {
            // 방향 전환
            if(turnCnt > 0 && time == info.time) {
                pointer = getNextPointer(info.way, pointer);
                if(--turnCnt > 0) info = queue.poll();
            }
            time++;

            // 머리 이동
            head.x += dx[pointer];
            head.y += dy[pointer];
            snake.offer(new Point(head.x, head.y));

            // 이동 불가면 게임 끝
            if(!checkBump(head.x, head.y)) break;

            // 사과면 꼬리 이동 안함
            if(board[head.x][head.y] == APPLE) {
                board[head.x][head.y] = SNAKE;
                continue;
            }

            // 꼬리 이동
            Point tail = snake.poll();
            board[head.x][head.y] = SNAKE;
            board[tail.x][tail.y] = 0;
        }
        System.out.println(time);
    }

    public static boolean checkBump(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N && board[x][y] != SNAKE;
    }

    public static int getNextPointer(char way, int pointer) {
        if(way == 'L') return (pointer - 1 < 0) ? 3 : pointer - 1;
        else return (pointer + 1 > 3) ? 0 : pointer + 1;
    }

    public static class Info {
        int time;
        char way;

        public Info(int time, char way) {
            this.time = time;
            this.way = way;
        }
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
