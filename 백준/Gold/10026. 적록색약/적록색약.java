import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[][] map;
    static boolean[][] twoVisited;
    static boolean[][] threeVisited;
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        twoVisited = new boolean[N][N];
        threeVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int threeColorCount = 0;
        int twoColorCount = 0;

        // DFS 돌면서 구역 COUNT
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!twoVisited[i][j]) { // 색약인 경우
                    dfs(i, j, true);
                    twoColorCount++;
                }
                if(!threeVisited[i][j]) {
                    dfs(i, j, false);
                    threeColorCount++;
                }
            }
        }
        System.out.println(threeColorCount + " " + twoColorCount);
    }

    private static void dfs(int x, int y, boolean isColorBlind) {
        for (int i = 0; i < 4; i++) {
            int curX = x + xs[i];
            int curY = y + ys[i];

            if(checkRange(curX, curY)) { // 범위 일치인 경우만 고려
                if (isColorBlind) { // 적록색약인 경우
                    if (map[x][y].equals("B")) {
                        if (!twoVisited[curX][curY] && map[x][y].equals(map[curX][curY])) {
                            twoVisited[curX][curY] = true;
                            dfs(curX, curY, isColorBlind);
                        }
                    } else { // R/G
                        if (!twoVisited[curX][curY] && (map[curX][curY].equals("R") || map[curX][curY].equals("G"))) {
                            twoVisited[curX][curY] = true;
                            dfs(curX, curY, isColorBlind);
                        }
                    }
                } else { // 아닌 경우
                    if (!threeVisited[curX][curY] && map[x][y].equals(map[curX][curY])) {
                        threeVisited[curX][curY] = true;
                        dfs(curX, curY, isColorBlind);
                    }
                }
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 & y < N;
    }
}
