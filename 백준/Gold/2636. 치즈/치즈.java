import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) cheeseCount++;
            }
        }

        int count = 0;
        while (cheeseCount > 0) {
            count++;

            List<Coord> changed = new ArrayList<>();
            Queue<Coord> queue = new LinkedList<>();
            queue.add(new Coord(0, 0));
            visited = new boolean[N][M];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Coord now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int curX = now.x + xs[i];
                    int curY = now.y + ys[i];

                    if (checkArrange(curX, curY) && !visited[curX][curY]) {
                        visited[curX][curY] = true;
                        if (map[curX][curY] == 0) { // 빈칸에 대해서만 탐색
                            queue.add(new Coord(curX, curY));
                        } else {
                            changed.add(new Coord(curX, curY));
                        }
                    }
                }
            }

            // 변한 애들 대상으로 map 바꾸기
            for (Coord c : changed) {
                map[c.x][c.y] = 0;
            }

            // 마지막이면 값 안바꾸고 break;
            if(cheeseCount - changed.size() == 0) {
                break;
            }

            cheeseCount -= changed.size();
        }
        System.out.println(count + "\n" + cheeseCount);
    }

    public static boolean checkArrange(int x, int y) {
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
