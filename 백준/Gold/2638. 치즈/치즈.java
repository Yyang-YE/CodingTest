import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] air; // 외부면 true, 내부면 false
    static List<Coord> cheeses = new ArrayList<>();

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map 정보 입력 받기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 1) cheeses.add(new Coord(i, j));
            }
        }

        // 돌면서 확인하기
        int hours = 0;
        while(!cheeses.isEmpty()) {
            meltCheese();
            hours++;
        }
        System.out.println(hours);
    }

    public static void meltCheese() {
        List<Coord> temp = new ArrayList<>();
        List<Coord> toZero = new ArrayList<>();

        setAir();

        for (Coord cheese : cheeses) { // 각 치즈에 대해
            int count = 0; // 공기 수
            for (int i = 0; i < 4; i++) {
                int curX = cheese.x + xs[i];
                int curY = cheese.y + ys[i];

                // 공기면 확인
                if(checkArrange(curX, curY) && map[curX][curY] == 0) {
                    if(air[curX][curY]) count++; // 외부 공기 여부 확인
                    if(count == 2) {
                        toZero.add(cheese); // 1시간 후 녹을 애들
                        break;
                    }
                }

                if(i == 3) { // 공기가 2변이 되지 않음
                    temp.add(cheese);
                }
            }
        }

        // map update
        for (Coord c : toZero) {
            map[c.x][c.y] = 0;
        }

        //cheeses update
        cheeses.clear();
        cheeses.addAll(temp);
    }

    public static void setAir() {
        boolean[][] visited = new boolean[N][M];
        air = new boolean[N][M];

        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0));
        visited[0][0] = true;
        air[0][0] = true;

        // 외부공기와 연결되면 모두 외부공기
        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];
                // 미방문 중 0인 것들
                if(checkArrange(curX, curY) && !visited[curX][curY] && map[curX][curY] == 0) {
                    queue.offer(new Coord(curX, curY));
                    visited[curX][curY] = true;
                    air[curX][curY] = true;
                }
            }
        }
    }

    public static boolean checkArrange (int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
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
