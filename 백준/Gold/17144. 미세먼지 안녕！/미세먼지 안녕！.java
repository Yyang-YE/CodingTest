import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, T;
    static Coord cleaner = new Coord(-1, -1);
    static int[][] map;
    static Set<Coord> dusts = new HashSet<>();

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num > 0) {
                    dusts.add(new Coord(i, j, num));
                }
                // 청정기 윗칸을 저장
                if(num == -1 && cleaner.x == -1) {
                    cleaner = new Coord(i, j);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            diffuseDust();
            operateCleaner();
        }
        System.out.println(countTotalDust());
    }

    private static void diffuseDust() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = map[i].clone();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] <= 0) continue;
                int aroundCount = 0;

                for (int k = 0; k < 4; k++) {
                    int curX = i + xs[k];
                    int curY = j + ys[k];

                    if(checkArrange(curX, curY) && map[curX][curY] != -1) {
                        if(map[i][j]/5 != 0) {
                            temp[curX][curY] += map[i][j]/5 ;
                        }
                        aroundCount++;
                    }
                }
                temp[i][j] = Math.max((temp[i][j] - (map[i][j]/5 * aroundCount)), 0);
            }
        }
        for (int i = 0; i < R; i++) {
            map[i] = temp[i].clone();
        }

    }

    private static void operateCleaner() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp[i] = map[i].clone();
        }

        for (int i = 0; i < C; i++) {
            // 맨 윗줄
            temp[0][i] = (i == C-1) ? map[1][i] : map[0][i+1];
            // 중간줄
            if(i != cleaner.y) {
                temp[cleaner.x][i] = (i == 1) ? 0 : map[cleaner.x][i - 1];
                temp[cleaner.x + 1][i] = (i == 1) ? 0 : map[cleaner.x + 1][i - 1];
            }
            // 맨 맽줄
            temp[R-1][i] = (i == C-1) ? map[R-2][i] : map[R-1][i+1];
        }

        for (int i = 0; i < R; i++) {
            // 맨 왼쪽줄 & 오른쪽줄
            if(i < cleaner.x) {
                temp[i][0] = (i == 0) ? map[i][1] : map[i-1][0];
                temp[i][C-1] = map[i+1][C-1];
            } else if(i > cleaner.x+1) {
                temp[i][0] = (i == R-1) ? map[i][1] :  map[i+1][0];
                temp[i][C-1] = map[i-1][C-1];
            } else {
                temp[i][C-1] = map[i][C-2];
            }
        }

        for (int i = 0; i < R; i++) {
            map[i] = temp[i].clone();
        }
    }

    private static int countTotalDust() {
        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1) total += map[i][j];
            }
        }
        return total;
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    public static class Coord {
        int x;
        int y;
        int curDust;

        public Coord(int x, int y, int curDust) {
            this.x = x;
            this.y = y;
            this.curDust = curDust;
        }

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
