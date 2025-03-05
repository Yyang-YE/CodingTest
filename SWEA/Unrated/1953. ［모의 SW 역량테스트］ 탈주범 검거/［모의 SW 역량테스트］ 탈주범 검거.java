import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Coord> queue = new LinkedList<>();
            queue.add(new Coord(R, C));
            visited[R][C] = true;

            int qCount = queue.size();
            int answer = 1;
            L--;
            while(!queue.isEmpty() && L > 0) {
                Coord cur = queue.poll();
                qCount--;

                // 상
                if(cur.x > 0 && !visited[cur.x-1][cur.y] && checkUp(cur.x, cur.y) && checkDown(cur.x-1, cur.y)) {
                    visited[cur.x-1][cur.y] = true;
                    queue.add(new Coord(cur.x-1, cur.y));
                }

                // 하
                if(cur.x < N-1 && !visited[cur.x+1][cur.y] && checkDown(cur.x, cur.y) && checkUp(cur.x+1, cur.y)) {
                    visited[cur.x+1][cur.y] = true;
                    queue.add(new Coord(cur.x+1, cur.y));
                }

                // 좌
                if(cur.y > 0 && !visited[cur.x][cur.y-1] && checkLeft(cur.x, cur.y) && checkRight(cur.x, cur.y-1)) {
                    visited[cur.x][cur.y-1] = true;
                    queue.add(new Coord(cur.x, cur.y-1));
                }

                // 우
                if(cur.y < M-1 && !visited[cur.x][cur.y+1] && checkRight(cur.x, cur.y) && checkLeft(cur.x, cur.y+1)) {
                    visited[cur.x][cur.y+1] = true;
                    queue.add(new Coord(cur.x, cur.y+1));
                }

                if(qCount == 0) {
                    answer += queue.size();
                    qCount = queue.size();
                    L--;
                }
            }
            bw.write("#" + tc + " " + answer + "\n");
        }
        br.close();
        bw.close();
    }

    public static boolean checkUp(int x, int y) {
        return map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 7;
    }

    public static boolean checkDown(int x, int y) {
        return map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 5 || map[x][y] == 6;
    }

    public static boolean checkLeft(int x, int y) {
        return map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 6 || map[x][y] == 7;
    }

    public static boolean checkRight(int x, int y) {
        return map[x][y] == 1 || map[x][y] == 3 || map[x][y] == 4 || map[x][y] == 5;
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