import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int INF = Integer.MAX_VALUE;
    static int[][] distance, map;
    static boolean[][] visited;
    static int[] xs = {1, -1, 0, 0};
    static int[] ys = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int probCount = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            distance = new int[N][N];
            map = new int[N][N];
            visited = new boolean[N][N];

            // map 업데이트
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = INF;
                }
            }

            djikstra(new Coord(0, 0));

            // 출력 양식
            bw.write("Problem " + probCount + ": " + distance[N-1][N-1] + "\n");
            probCount++;
        }
        br.close();
        bw.close();
    }

    public static void djikstra(Coord start) {
        PriorityQueue<Coord> pq = new PriorityQueue<>(Comparator.comparing(c -> distance[c.x][c.y]));
        distance[start.x][start.y] = map[start.x][start.y];
        pq.add(start);

        while(!pq.isEmpty()) {
            Coord cur = pq.poll();
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + xs[i];
                int nextY = cur.y + ys[i];

                if(checkRange(nextX, nextY) && !visited[nextX][nextY] && distance[nextX][nextY] > distance[cur.x][cur.y] + map[nextX][nextY]) {
                    distance[nextX][nextY] = distance[cur.x][cur.y] + map[nextX][nextY];
                    pq.add(new Coord(nextX, nextY));
                }
            }
        }
    }

    private static boolean checkRange(int nextX, int nextY) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N;
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
