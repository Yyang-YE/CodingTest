import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] box;
    static int M, N, H;
    static Queue<Tomato> matured = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        // box 초기값 설정
        boolean isAllMatured = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tomato;

                    if(tomato == 0) {
                        isAllMatured = false;
                    }
                    if(tomato == 1) matured.add(new Tomato(k, j, i));
                }
            }
        }
        if(!isAllMatured) { // 덜익음
            System.out.println(countDays());
        } else { // 처음부터 모두 익어 있음
            System.out.println(0);
        }
    }

    // 토마토 결과 확인
    private static int countDays () {
        int count = 0;

        int[] ms = {0, 0, 0, 0, 1, -1};
        int[] ns = {0, 0, 1, -1, 0, 0};
        int[] hs = {1, -1, 0, 0, 0, 0};

        while(true) {
            if(!hasUnmatured()) { // 다 익었으면 탈출
                break;
            } else {
                if(matured.isEmpty()) { // 덜익음
                    return -1;
                }
                Queue<Tomato> tempQ = new LinkedList<>();
                // 주변 확인 & 갱신
                while(!matured.isEmpty()) { // count마다 한바퀴
                    Tomato tmt = matured.poll();
                    for (int i = 0; i < 6; i++) {
                        int curM = tmt.m + ms[i];
                        int curN = tmt.n + ns[i];
                        int curH = tmt.h + hs[i];

                        // 이웃이 존재하고, 0이면 1로 변경 + matured에 추가
                        if (curM >= 0 && curM < M && curN >= 0 && curN < N && curH >= 0 && curH < H) {
                            if (box[curH][curN][curM] == 0) {
                                box[curH][curN][curM] = 1;
                                tempQ.add(new Tomato(curM, curN, curH));
                            }
                        }
                    } // for
                }
                matured = new LinkedList<>(tempQ);
                count++;
            }
        }
        return count;
    }

    // box에 0이 있는지 여부를 반환
    private static boolean hasUnmatured() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0) return true;
                }
            }
        }
        return false;
    }

    public static class Tomato {
        int m;
        int n;
        int h;

        Tomato(int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
    }
}