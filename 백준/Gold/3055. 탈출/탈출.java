import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, time;
    static char[][] map;
    static Queue<Coord> water = new LinkedList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());

        map = new char[R][C];
        Coord goCur = new Coord(-1, -1);
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') {
                    goCur = new Coord(i, j);
                    map[i][j] = '.'; // 고슴도치 위치도 물이 찰 수 있음
                } else if(map[i][j] == '*') {
                    water.offer(new Coord(i, j));
                }
            }
        }
        if(moveGosum(goCur)) System.out.println(time);
        else System.out.println("KAKTUS");
    }

    public static boolean moveGosum(Coord start) {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        
        int qCnt = 1;
        queue.offer(start); // 시작 위치
        visited[start.x][start.y] = true;

        time = 1;
        flood(); // 초반 불리기
        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            qCnt--;

            for (int i = 0; i < 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];

                if(checkArrange(cx, cy) && !visited[cx][cy]) {
                    if(map[cx][cy] == '.') {
                        queue.offer(new Coord(cx, cy));
                        visited[cx][cy] = true;
                    } else if(map[cx][cy] == 'D') {
                        return true;
                    }
                }
            }
            if(qCnt == 0) {
                time++;
                qCnt = queue.size();
                flood(); // 다음을 위해 물불리기
            }
        }
        return false;
    }

    // 1초동안 물불리기
    public static void flood() {
        int cnt = water.size();
        while(!water.isEmpty()) {
            Coord now = water.poll();
            cnt--;

            for (int i = 0; i < 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];

                if(checkArrange(cx, cy) && map[cx][cy] == '.') {
                    map[cx][cy] = '*';
                    water.offer(new Coord(cx, cy));
                }
            }
            if(cnt == 0) return;
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
