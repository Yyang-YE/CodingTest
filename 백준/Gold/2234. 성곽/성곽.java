import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] roomInfo;
    static int[] dx = {0, -1, 0, 1}; // 서, 북, 동, 남
    static int[] dy = {-1, 0, 1, 0};

    static HashMap<Integer, Integer> roomSize = new HashMap<>();
    static List<int[]> connected = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        roomInfo = new int[N][M]; // 방 번호 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCnt = 0;
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(roomInfo[i][j] == 0) { // 미방문이면 작동
                    roomCnt++;
                    roomInfo[i][j] = roomCnt;
                    int size = bfs(new Coord(i, j), roomCnt);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        // 벽 부순 경우 최대 구하기
        int breakMax = 0;
        for (int[] info : connected) {
            breakMax = Math.max(breakMax, roomSize.get(info[0]) + roomSize.get(info[1]));
        }
        
        sb.append(roomCnt).append("\n").append(maxSize).append("\n").append(breakMax);
        System.out.println(sb);
    }

    public static int  bfs(Coord start, int roomNum) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(start);

        HashSet<Integer> set = new HashSet<>();

        int count = 1;
        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = dx[i] + now.x;
                int cy = dy[i] + now.y;

                if(checkArrange(cx, cy)) {
                    if(roomInfo[cx][cy] == 0) { // 빝마 넣어서 수정하기
                        if((map[now.x][now.y] & (1 << i)) == 0) { // 서북동남, 벽없으면
                            count++;
                            roomInfo[cx][cy] = roomNum; // 방 설정
                            queue.offer(new Coord(cx, cy));
                        }
                    } else if(roomInfo[cx][cy] != roomNum) {
                        set.add(roomInfo[cx][cy]);
                    }
                }
            }
        }

        // 해당 방 번호의 방 개수 저장
        roomSize.put(roomNum, count);

        // 연결 정보 저장
        for (Integer i : set) {
            connected.add(new int[] {roomNum, i});
        }

        return count;
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
