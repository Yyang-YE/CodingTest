import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][] visited;
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Coord> queue = new LinkedList<>();
        Queue<Coord> tempQ = new LinkedList<>();
        queue.add(new Coord(0, 0));
        visited[0][0] = true;

        int gramAnswer = Integer.MAX_VALUE;
        int answer = 0;
        boolean saved = false;
        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            if(map[now.x][now.y] == 2) {
                gramAnswer = answer + (N-now.x-1) + (M-now.y-1);
            }

            if(now.x == N-1 && now.y == M-1) {
                saved = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];

                if(checkArrange(curX, curY) && !visited[curX][curY] && map[curX][curY] != 1) {
                    tempQ.add(new Coord(curX, curY));
                    visited[curX][curY] = true;
                }
            }

            if(queue.isEmpty()) {
                queue.addAll(tempQ);
                tempQ.clear();
                answer++;
            }
        }

        if(saved) { // 일반 경로로 도달 가능
            answer = Math.min(gramAnswer, answer);
        } else if(gramAnswer != Integer.MAX_VALUE) { // 그램으로만 도달 가능
            answer = gramAnswer;
        } else { // 둘 다 불가능: Fail
            answer = Integer.MAX_VALUE;
        }

        if(answer > T) System.out.println("Fail");
        else System.out.println(answer);
    }

    private static boolean checkArrange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
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
