import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int count = 1;
    static int[][] board;

    // 북동남서 (순서대로 0123)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int d) {
        board[x][y] = -1; // 방문 처리

        // 다음 칸 찾기 (i 방향 확인 및 진행)
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(checkArrange(nx, ny) && board[nx][ny] == 0) {
                count++;
                dfs(nx, ny, d);
                return;
            }
        }

        // 만약 진행 불가 & 뒤가 벽이 아니라면 후진
        int backDir = (d + 2) % 4;
        int nx = x + dx[backDir];
        int ny = y + dy[backDir];
        if(checkArrange(nx, ny) && board[nx][ny] != 1) {
            dfs(nx, ny, d);
        }
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
