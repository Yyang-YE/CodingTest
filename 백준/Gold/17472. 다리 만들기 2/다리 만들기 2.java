import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] root;
    static List<Coord> bridge = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.cost));

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS -> 섬 이름 바꾸기 & 방문 처리
        int idx = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] == 1) {
                    checkLand(idx, new Coord(i, j));
                    idx--;
                }
            }
        }

        // 경계선들에서 다리 만들기
        for (Coord c : bridge) {
            int len = 0;

            // 여기서 시작접 찍고 비교하기
            while (true) {
                c.x += xs[c.way];
                c.y += ys[c.way];
                if(!checkArrange(c.x, c.y)) break;

                if(board[c.x][c.y] == 0) {
                    len++;
                } else if(board[c.x][c.y] != c.landIdx && len > 1) { // 다른 섬을 만남
                    pq.offer(new Edge(c.landIdx * -1, board[c.x][c.y] * -1, len));
                    break;
                } else {
                    break;
                }
            }
        }

        // MST 구하기
        root = new int[idx * -1];
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }

        int minTotalCost = 0;
        int edgeCount = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            int a = find(edge.src);
            int b = find(edge.dst);
            if(a != b) {
                union(a, b);
                minTotalCost += edge.cost;
                edgeCount++;
            }
        }
        System.out.println((minTotalCost == 0 || edgeCount < idx * -1 - 2) ? -1 : minTotalCost);
    }

    private static void checkLand(int idx, Coord start) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] tmpVisited = new boolean[N][M];
        visited[start.x][start.y] = true;
        tmpVisited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            board[now.x][now.y] = idx;

            for (int i = 0; i < 4; i++) {
                int nx = xs[i] + now.x;
                int ny = ys[i] + now.y;
                if(checkArrange(nx, ny) && !tmpVisited[nx][ny]) {
                    if(board[nx][ny] == 1) {
                        queue.offer(new Coord(nx, ny));
                        visited[nx][ny] = true;
                        tmpVisited[nx][ny] = true;
                    } else { // 방향을 함께 저장
                        bridge.add(new Coord(now.x, now.y, idx, i));
                    }
                }
            } // for
        } // while
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            root[b] = a;
        }
    }

    private static int find(int idx) {
        if(root[idx] == idx) return idx;
        return root[idx] = find(root[idx]);
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static class Edge {
        int src;
        int dst;
        int cost;

        public Edge(int src, int dst, int cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }
    }

    public static class Coord {
        int x;
        int y;
        int landIdx;
        int way;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coord(int x, int y, int landIdx, int way) {
            this.x = x;
            this.y = y;
            this.landIdx = landIdx;
            this.way = way;
        }
    }
}
