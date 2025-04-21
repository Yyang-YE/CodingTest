import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int shootCnt;
    static int[] archers = new int[3]; // 궁수 위치
    static int[][] map, tmpMap;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickArcher(0, 0);
        System.out.println(shootCnt);
    }

    public static void pickArcher(int idx, int depth) {
        if(depth == 3) {
            // map 업뎃
            for (int i = 0; i < N; i++) {
                tmpMap[i] = map[i].clone();
            }

            // 시뮬레이션
            int kill = 0;
            for (int i = 0; i < N; i++) {
                // 죽일 애들 탐색 (BFS)
                Coord[] shot = new Coord[3];
                for (int j = 0; j < 3; j++) {
                    shot[j] = getShooted(new Coord(N - 1, archers[j]));
                }

                // map 업데이트 (쏴죽이기)
                for (int j = 0; j < 3; j++) {
                    if (shot[j].x != -1 && shot[j].y != -1 && tmpMap[shot[j].x][shot[j].y] == 1) {
                        tmpMap[shot[j].x][shot[j].y] = 0;
                        kill++;
                    }
                }

                // 한칸 전진
                moveForward();
            }
            shootCnt = Math.max(shootCnt, kill);
            return;
        }

        for (int i = idx; i < M; i++) {
            archers[depth] = i;
            pickArcher(i+1, depth+1);
        }
    }

    public static void moveForward() {
        for (int i = N-1; i >= 0; i--) {
            if(i == 0) Arrays.fill(tmpMap[i], 0);
            else tmpMap[i] = tmpMap[i-1].clone();
        }
    }

    public static Coord getShooted(Coord archer) {
        if(tmpMap[archer.x][archer.y] == 1) return archer; // 가장 가까운 곳

        Queue<Coord> queue = new LinkedList<>();
        List<Coord> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];
        
        queue.offer(archer);
        visited[archer.x][archer.y] = true;

        int qCnt = 1;
        int distance = 2;
        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            qCnt--;
            if(distance > D) break; // 거리 제한

            for (int i = 0; i < 4; i++) {
                int cx = now.x + dx[i];
                int cy = now.y + dy[i];

                if(checkArrange(cx, cy) && !visited[cx][cy]) {
                    if(tmpMap[cx][cy] == 1) list.add(new Coord(cx, cy));
                    else queue.offer(new Coord(cx, cy));
                    visited[cx][cy] = true;
                }
            }

            if(qCnt == 0) {
                if(!list.isEmpty()) break; // 적 발견
                qCnt = queue.size();
                distance++;
            }
        }

        if(list.isEmpty()) { // 1이 없는 경우
            return new Coord(-1, -1);
        } else {
            // 가장 좌측의 적의 좌표 반환
            Coord answer = new Coord(100, 100);
            for (Coord c : list) {
                if(c.y < answer.y) {
                    answer = c;
                }
            }
            return answer;
        }
    }

    public static boolean checkArrange(int x, int y) {
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
