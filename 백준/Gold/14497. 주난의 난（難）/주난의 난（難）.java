import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Coord joonan = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Coord criminal = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        map = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j-1);
            }
        }

        int count = 1;
        while(!bfs(joonan)) {
            count++;
        }
        System.out.println(count);
    }

    // 탐색 중 범인 있으면 true 반환
    public static boolean bfs(Coord start) {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][M+1];
        List<Coord> list = new ArrayList<>();

        queue.offer(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Coord now  = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = now.x + xs[i];
                int cy = now.y + ys[i];

                if(checkArrange(cx, cy) && !visited[cx][cy]) {
                    if(map[cx][cy] == '1') { // 쓰러트림
                        list.add(new Coord(cx, cy));
                    } else if(map[cx][cy] == '0') { // 파동 계속
                        visited[cx][cy] = true;
                        queue.add(new Coord(cx, cy));
                    }else { // 발견
                        return true;
                    }
                }
            }
        }

        for (Coord c : list) {
            map[c.x][c.y] = '0';
        }
        return false;
    }

    public static boolean checkArrange(int x, int y) {
        return 0 < x && x <= N && 0 < y && y <= M;
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
