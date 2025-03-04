import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // M, M은 항상 4 이상
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1*4 확인
                if(j <= M - 4) check14(i, j);

                // 2*3 확인
                if(i <= N - 2 && j <= M - 3) check23(i, j);

                // 3*2 확인
                if(i <= N - 3 && j <= M - 2) check32(i, j);

                // 4*1 확인
                if(i <= N - 4) check41(i, j);
            }
        }
        System.out.println(max);
    }

    public static void check14(int i, int j) {
        int temp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3];
        max = Math.max(max, temp);
    }

    public static void check23(int x, int y) {
        int[][] fst = {{0, 0}, {0, 0}, {0, 0}, {0, 0},
                        {0, 1}, {0, 2}, {0, 2},
                        {1, 0}, {1, 0}, {1, 1}};
        int[][] sec = {{0, 1}, {0, 2}, {1, 0}, {1, 2},
                        {0, 2}, {1, 0}, {1, 2},
                        {1, 1}, {1, 2}, {1, 2}};
        int min = 10000;
        for (int i = 0; i < 10; i++) {
            min = Math.min(min, paper[x+fst[i][0]][y+fst[i][1]] + paper[x+sec[i][0]][y+sec[i][1]]);
        }

        int total = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                total += paper[x+i][y+j];
            }
        }
        max = Math.max(max, total-min);
    }

    public static void check32(int x, int y) {
        int[][] fst = {{0, 0}, {0, 0}, {0, 0}, {0, 0},
                        {0, 1}, {0, 1}, {0, 1},
                        {1, 0}, {1, 1}, {2, 0}};
        int[][] sec = {{0, 1}, {1, 0}, {2, 0}, {2, 1},
                        {1, 1}, {2, 0}, {2, 1},
                        {2, 0}, {2, 1}, {2, 1}};

        int min = 10000;
        for (int i = 0; i < 10; i++) {
            min = Math.min(min, paper[x+fst[i][0]][y+fst[i][1]] + paper[x+sec[i][0]][y+sec[i][1]]);
        }

        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                total += paper[x+i][y+j];
            }
        }
        max = Math.max(max, total-min);
    }

    public static void check41(int i, int j) {
        int temp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+3][j];
        max = Math.max(max, temp);
    }
}
