import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y;
    static int[] dice = {0, 0, 0, 0, 0, 0}; // 반대편 정보를 저장 (i, 5-i가 세트)
    static int[] curWay = {0, 1, 2}; // 위, 북(옆), 동(옆) 순으로 idx 저장
    static int[][] map;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // K번 명령 실행
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            if(!checkArrange(cmd, x, y)) continue; // 진행 불가시 넘어가기

            // 돌리고 다음 값 찾기
            if(cmd == 1) { // 동
                y++;
                roll(curWay[2]);
                // 위: 기존 서
                // 북: 동일
                // 동: 기존 위
                int tmp = curWay[0];
                curWay[0]= 5 - curWay[2];
                curWay[2] = tmp;
            } else if(cmd == 2) { // 서
                y--;
                roll(5 - curWay[2]);
                // 위: 기존 동
                // 북: 동일
                // 동: 기존 밑
                int tmp = curWay[0];
                curWay[0] = curWay[2];
                curWay[2] = 5 - tmp;
            } else if(cmd == 3) { // 북
                x--;
                roll(curWay[1]);
                // 위: 기존 남
                // 북: 기존 위
                // 동: 동일
                int tmp = curWay[0];
                curWay[0] = 5 - curWay[1];
                curWay[1] = tmp;
            } else { // 남
                x++;
                roll(5 - curWay[1]);
                // 위: 기존 북
                // 북: 기존 밑
                // 동: 동일
                int tmp = curWay[0];
                curWay[0] = curWay[1];
                curWay[1] = 5 - tmp;
            }
            // 윗 값 출력
            bw.write(dice[curWay[0]] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void roll(int nextIdx) throws IOException {
        if(map[x][y] == 0) {
            map[x][y] = dice[nextIdx];
        } else {
            dice[nextIdx] = map[x][y];
            map[x][y] = 0;
        }
    }

    public static boolean checkArrange(int way, int x, int y) {
        switch (way) {
            case 1: // 동
                return y < M-1;
            case 2: // 서
                return y > 0;
            case 3: // 북
                return x > 0;
            case 4: // 남
                return x < N-1;
        }
        return false;
    }
}
