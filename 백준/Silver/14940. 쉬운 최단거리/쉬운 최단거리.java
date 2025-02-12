import java.io.*;
import java.util.*;

public class Main {
    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    static int[][] graph, distance;
    static boolean[][] visited;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        Coord start = new Coord(0, 0);
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 2) {
                    start = new Coord(i, j);
                } else if(graph[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(start);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    distance[i][j] = -1;
                }
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(Coord node) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;

        while(!queue.isEmpty()) {
            Coord temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curX = temp.x + xs[i];
                int curY = temp.y + ys[i];

                if(checkArrange(curX, curY) && !visited[curX][curY] && graph[curX][curY] == 1) {
                    visited[curX][curY] = true;
                    distance[curX][curY] = distance[temp.x][temp.y] + 1;
                    queue.add(new Coord(curX, curY));
                }
            }
        }
    }

    public static boolean checkArrange(int x, int y) {
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
