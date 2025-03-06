import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int temp = 1;
    static int max;
    static Coord start;
    static int[][] map;
    static boolean[] visited = new boolean[101]; // 디저트 방문 여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            max = -1;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 전체 돌면서 확인 (\방향으로 출발: 모서리는 출발점이 될 수 없음)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    start = new Coord(i, j);
                    visited[map[i][j]] = true;

                    goRightDown(new Coord(i+1, j+1));

                    visited[map[i][j]] = false;
                }
            }

            bw.write("#" + tc + " " + max + "\n");
        }
        br.close();
        bw.close();

    }

    public static void goRightDown(Coord next) {
        // 다음칸에서 시작
        // 우하 노드가 미방문이면 아래 단계 진행
        if(checkArrange(next.x, next.y) && !visited[map[next.x][next.y]]) {
            visited[map[next.x][next.y]] = true;
            temp++;

            // 이어진 대각선 2개 확인(개수 동일)
            goLeftDownAndRightUp(new Coord(start.x+1, start.y-1), new Coord(next.x+1, next.y-1));

            // 다음 우하 확인
            goRightDown(new Coord(next.x+1, next.y+1));

            visited[map[next.x][next.y]] = false;
            temp--;
        }
    }

    public static void goLeftDownAndRightUp(Coord upNext, Coord downNext) {
        // 노드 범위 체크
        if(checkArrange(upNext.x, upNext.y) && checkArrange(downNext.x, downNext.y)) {
            // 디저트 확인
            if(!visited[map[upNext.x][upNext.y]] && !visited[map[downNext.x][downNext.y]] && map[upNext.x][upNext.y] != map[downNext.x][downNext.y]) {
                visited[map[upNext.x][upNext.y]] = true;
                visited[map[downNext.x][downNext.y]] = true;
                temp += 2;

                //up~down 확인
                checkUpDown(new Coord(upNext.x, upNext.y), new Coord(downNext.x, downNext.y));

                // 다음 확인
                goLeftDownAndRightUp(new Coord(upNext.x+1, upNext.y-1), new Coord(downNext.x+1, downNext.y-1));

                visited[map[upNext.x][upNext.y]] = false;
                visited[map[downNext.x][downNext.y]] = false;
                temp -= 2;
            }
        }

    }

    //up~down의 대각선 값들을 확인
    public static void checkUpDown(Coord up, Coord down) {
        up.x++;
        up.y++;

        // 만나면 성공
        if(up.x == down.x && up.y == down.y) {
            max = Math.max(max, temp);
            return;
        }

        // 다음이 down이 아니면 확인
        if(!visited[map[up.x][up.y]]) { // 미방문이면 ㄱㅊ
            visited[map[up.x][up.y]] = true;
            temp++;

            checkUpDown(new Coord(up.x, up.y), new Coord(down.x, down.y));

            visited[map[up.x][up.y]] = false;
            temp--;
        }

    }

    public static boolean checkArrange(int x, int y) {
        return 0 <= x && x < N && 0 <= y &&  y < N;
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
