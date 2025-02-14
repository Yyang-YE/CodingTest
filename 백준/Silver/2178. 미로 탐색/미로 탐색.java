import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(str.substring(j, j+1));
                map[i][j] = num;
                if(num == 0) {
                    visited[i][j] = true;
                }
            }
        }

        Queue<Coord> queue = new LinkedList<>();
        Queue<Coord> tempQ = new LinkedList<>();
        queue.add(new Coord(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Coord node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curX = node.x + xs[i];
                int curY = node.y + ys[i];

                if(rangeCheck(curX, curY) && !visited[curX][curY]) {
                    visited[curX][curY] = true;
                    map[curX][curY] = map[node.x][node.y] + 1;
                    tempQ.add(new Coord(curX, curY));
                }
            }

            if(queue.isEmpty()) {
                queue.addAll(tempQ);
                tempQ.clear();
            }
        }
        System.out.println(map[N-1][M-1]);
    }

    private static boolean rangeCheck(int x, int y) {
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
