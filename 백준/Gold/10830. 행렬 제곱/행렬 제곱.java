import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000;
    static int N;
    static int[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int[][] pow(int[][] A, long cnt) {
        if(cnt == 1L) return A;

        // 절반만큼 구하기
        int[][] ans = pow(A, cnt/2);

        // 구한 값을 제곱
        ans = mul(ans, ans);

        if(cnt % 2 != 0) {
            ans = mul(ans, origin);
        }
        return ans;
    }

    // 행렬의 곱셈
    public static int[][] mul(int[][] m1, int[][] m2) {
        int[][] ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ans[i][j] += m1[i][k] * m2[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }
}
