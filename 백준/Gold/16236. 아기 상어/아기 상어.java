import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, distance;
    static int babySize = 2;
    static Coord baby; // 아기 상어 위치
    static int[][] map;
    static int[] xs = {1, -1, 0, 0};
    static int[] ys = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    baby = new Coord(i, j);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0; // 소요 시간
        int eat = 0; // 먹은 물고기 수
        while(true) {
            // 먹을 수 있는 리스트 반환
            baby = findFish();
            if(baby.x == -1) break; // 못먹으면 끝

            // 먹음 - 상어, 맵 정보 갱신
            time += distance; // 시간 업데이트
            map[baby.x][baby.y] = 0; // 맵 갱신

            if(++eat == babySize) {
                eat = 0;
                babySize++;
            }
        }
        System.out.println(time);
    }

    // 아기 상어가 먹을 수 있는 물고기 리스트 뽑기
    public static Coord findFish() {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Coord> fish = new PriorityQueue<>(Comparator.comparing((Coord c) -> c.x).thenComparing(c -> c.y));

        queue.offer(baby);
        visited[baby.x][baby.y] = true;

        distance = 1;
        int qCount = 1;
        while(!queue.isEmpty()) {
            Coord now = queue.poll();
            qCount--;

            for (int i = 0; i < 4; i++) {
                int cx = xs[i] + now.x;
                int cy = ys[i] + now.y;

                // 지나갈 수 있음
                if(chechArrange(cx, cy) && !visited[cx][cy] && map[cx][cy] <= babySize) {
                    if(map[cx][cy] != 0 && map[cx][cy] < babySize) { // 먹을 수 있는 경우
                        fish.offer(new Coord(cx, cy));
                    }
                    visited[cx][cy] = true;
                    queue.add(new Coord(cx, cy));
                }
            }

            if(qCount == 0) {
                if(!fish.isEmpty()) break;
                distance++;
                qCount = queue.size();
            }
        }
        return (!fish.isEmpty()) ? fish.poll() : new Coord(-1, -1);
    }

    public static boolean chechArrange(int x, int y) {
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
