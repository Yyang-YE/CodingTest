import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 1;
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] alphabet = new boolean[26];
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited[0][0] = true;
        alphabet[map[0][0] - 'A'] = true;
        dfs(new Coord(0, 0), 1);
        System.out.println(max);
    }

    public static void dfs(Coord now, int depth) {
        // 이미 해당 알파벳 true이면
        for (int i = 0; i < 4; i++) {
            int curX = now.x + xs[i];
            int curY = now.y + ys[i];

            // 현재를 확인하고 다음으로 넘어감
            if(checkArrange(curX, curY) && !visited[curX][curY]) {
                int newIdx = map[curX][curY] - 'A';
                if(!alphabet[newIdx]) {
                    visited[curX][curY] = true;
                    alphabet[newIdx] = true;
                    max = Math.max(max, depth+1);
                    dfs(new Coord(curX, curY), depth + 1);
                    visited[curX][curY] = false;
                    alphabet[newIdx] = false;
                }
            }
        }
    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
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
