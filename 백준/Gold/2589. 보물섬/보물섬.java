import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'L') answer = Math.max(answer, dijkstra(new Node(i, j)));
            }
        }
        System.out.println(answer);
    }

    public static int dijkstra(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        boolean[][] visited = new boolean[N][M];
        visited[start.x][start.y] = true;

        int dist = 0;
        int qCnt = q.size();
        while(!q.isEmpty()) {
            Node now = q.poll();
            qCnt--;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(checkArrange(nx, ny) && !visited[nx][ny] && board[nx][ny] == 'L') {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            if(qCnt == 0) {
                qCnt = q.size();
                dist++;
            }
        }
        return dist - 1;
    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
