import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int total;
    static boolean[][] visited;
    static int[][] map;
    static List<Coord> union = new ArrayList<>();
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        boolean doneFlag = false;
        while(!doneFlag) {
            doneFlag = true;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 주변에 범위 내의 index 있으면
                    boolean aroundFlag = false;
                    for (int k = 0; k < 4; k++) {
                        // 주변에 다른 것이 없으면 걍 continue
                        if(checkRange(i+xs[k], j + ys[k]) && checkPeople(Math.abs(map[i][j] - map[i+xs[k]][j+ys[k]]))) {
                            aroundFlag = true;
                        }
                    }

                    // 같은 연합을 List에 저장
                    if(aroundFlag && !visited[i][j]) {
                        doneFlag = false;
                        visited[i][j] = true;
                        getVillage(new Coord(i, j));

                        // list 내의 모든 값들을 더하고 나눈 값으로 전체 재설정
                        if (union.size() > 1) {
                            int newPeople = total / union.size();
                            for (Coord coord : union) {
                                map[coord.x][coord.y] = newPeople;
                            }
                        }
                        total = 0;
                        union.clear();
                    }
                }
            }
            if(!doneFlag) days++;
        }
        System.out.println(days);
    }

    public static void getVillage(Coord country) {
        union.add(country);
        total += map[country.x][country.y];
        for (int i = 0; i < 4; i++) {
            int curX = country.x + xs[i];
            int curY = country.y + ys[i];
            if(checkRange(curX, curY) && !visited[curX][curY] && checkPeople(Math.abs(map[country.x][country.y] - map[curX][curY]))) {
                visited[curX][curY] = true;
                getVillage(new Coord(curX, curY));
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean checkPeople(int diff) {
        return L <= diff && diff <= R;
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
