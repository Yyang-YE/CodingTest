import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[][] map;
    static List<Coord> virus = new ArrayList<>();
    static List<Coord> blank = new ArrayList<>();

    static int[] xs = {1, -1, 0, 0};
    static int[] ys = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2) virus.add(new Coord(i, j));
                else if(num == 0) blank.add(new Coord(i, j));
            }
        }
        selectBlank(0, 0);
        System.out.println(max);
    }

    private static void selectBlank(int idx, int depth) {
        if(depth == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = idx; i < blank.size(); i++) {
            Coord now = blank.get(i);

            map[now.x][now.y] = 1;
            selectBlank(i+1, depth+1);
            map[now.x][now.y] = 0;
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<Coord> queue = new LinkedList<>(virus);

        int spreadCount = 0;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = xs[i] + now.x;
                int cy = ys[i] + now.y;

                if(checkArrange(cx, cy) && map[cx][cy] == 0 && !visited[cx][cy]) {
                    visited[cx][cy] = true;
                    queue.add(new Coord(cx, cy));
                    spreadCount++;
                }
            }
        }
        return blank.size() - 3 - spreadCount;
    }

    private static boolean checkArrange(int x, int y) {
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
