import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, totalHouseCount;
    static int[][] map;
    static boolean[][] visited;
    static List<Coord> houses;

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            houses = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                    if(num == 1) totalHouseCount++; // 총 집 수를 관리
                }
            }

            int max = 0;
            // 모든 좌표에 대해 완전 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    max = Math.max(max, getMaxHouse(new Coord(i, j)));
                    if(max == totalHouseCount) break;
                }
            }
            bw.write("#" + tc + " " + max + "\n");
        }
        br.close();
        bw.close();
    }

    public static int getMaxHouse(Coord center) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(center);
        visited[center.x][center.y] = true;
        int qCount = 1;
        int K = 2;
        int max = 0; //해당 범위에서의 max값
        int homeCount = 0; // 집 수 count

        if(map[center.x][center.y] == 1) {
            max++;
            homeCount++;
        }

        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            qCount--;

            //  주변의 집을 찾아서 count
            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];

                // 미방문 집에 대하여
                if(checkArrange(curX, curY) && !visited[curX][curY]) {
                    queue.add(new Coord(curX, curY));
                    visited[curX][curY] = true;
                    if(map[curX][curY] == 1) {
                        homeCount++;
                    }
                }
            }

            // K번째 주변 탐색 끝나면
            if(qCount == 0) {
                // 운영비용이 더 작거나 같으면 update
                if(K * K + (K-1) * (K-1) <= M * homeCount) {
                    max = Math.max(max, homeCount);
                }

                // 모든 집 찾은 경우
                if(homeCount == totalHouseCount) break;

                qCount = queue.size();
                K++;
            }
        }
        return max;
    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
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
