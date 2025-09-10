import java.io.*;
import java.util.*;

public class Main {
    static int max;
    static Info[][] board = new Info[4][4];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int way = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = new Info(num, way);
            }
        }

        // 첫 등장 (상어 번호 : 먹은 점수)
        Info shark = new Info(0, 0, board[0][0].num, board[0][0].way);
        board[0][0].num = -1; // 상어는 -1

        dfs(shark);
        System.out.println(max);
    }

    public static void dfs(Info shark) {
        Info[][] tmp = new Info[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = new Info(board[i][j].num, board[i][j].way);
            }
        }

        // 이동하고 시작
        moveFish();

        int idx = 1;
        boolean eaten = false;
        while(true) {
            int nx = shark.x + (dx[shark.way] * idx);
            int ny = shark.y + (dy[shark.way] * idx);

            // 범위 밖이면 끝
            if(!checkArrange(nx, ny)) break;

            // 물고기 있으면 먹기
            if(board[nx][ny].num > 0) {
                int tmpNum = board[nx][ny].num;

                board[shark.x][shark.y].num = 0; // 기존 위치
                board[nx][ny].num = -1; // 새 위치로 이동

                Info nShark = new Info(nx, ny, shark.num + tmpNum, board[nx][ny].way);
                dfs(nShark);

                board[shark.x][shark.y].num = -1;
                board[nx][ny].num = tmpNum;
                eaten = true;
            }

            // 다음 위치 탐방
            idx++;
        }

        // 아무것도 못먹으면 max 구하기
        if(!eaten) max = Math.max(shark.num, max);

        // 물고기 이동 취소
        board = tmp;
    }

    // 물고기 이동
    public static void moveFish() {
        // 있는 애들만 map에 넣기
        Map<Integer, Info> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j].num > 0) map.put(board[i][j].num, new Info(i, j, board[i][j].num, board[i][j].way));
            }
        }

        // 작은 것부터 이동
        for (int i = 1; i <= 16; i++) {
            if(!map.containsKey(i)) continue;

            int cx = map.get(i).x;
            int cy = map.get(i).y;
            int cn = map.get(i).num;
            int cw = map.get(i).way;

            for (int t = 0; t < 8; t++) {
                int nx = cx + dx[cw];
                int ny = cy + dy[cw];
                if(checkArrange(nx, ny) && board[nx][ny].num >= 0) { // 자리 바꾸기
                    int nn = board[nx][ny].num;
                    int nw = board[nx][ny].way;
                    board[nx][ny] = new Info(cn, cw);
                    board[cx][cy] = new Info(nn, nw);

                    // map 정보 관리 (좌표만 갱신)
                    if(nn > 0) {
                        map.get(nn).x = cx;
                        map.get(nn).y = cy;
                    }
                    map.get(i).x = nx;
                    map.get(i).y = ny;
                    map.get(i).way = cw;
                    break;
                }

                // 못가면 반시계방향 확인
                cw = getNext(cw);
            }
        }
    }

    private static int getNext(int n) {
        return (n == 7) ? 0 : n + 1;
    }

    private static boolean checkArrange(int x, int y) {
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }

    public static class Info {
        int x;
        int y;
        int num;
        int way;

        public Info(int num, int way) {
            this.num = num;
            this.way = way;
        }

        public Info(int x, int y, int num, int way) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.way = way;
        }
    }
}
