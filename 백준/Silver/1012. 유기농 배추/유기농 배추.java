import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] garden;
    static int M, N;
    static int count; // 역으로 세고 마지막에 -1 곱하기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            garden = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                garden[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(garden[j][k] == 1) {
                        count--;
                        checkAround(j, k);
                    }
                }
            }

            sb.append(count * (-1)).append("\n");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    static void checkAround(int x, int y) {
        garden[x][y] = count;

        if(y-1 >= 0 && garden[x][y-1] == 1) checkAround(x, y-1);
        if(y+1 < N && garden[x][y+1] == 1) checkAround(x, y+1);
        if(x-1 >= 0 && garden[x-1][y] == 1) checkAround(x-1, y);
        if(x+1 < M && garden[x+1][y] == 1) checkAround(x+1, y);
    }
}