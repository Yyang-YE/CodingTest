import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[][] A = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if(N == 1 || N == 0) {
            System.out.println(N);
        } else {
            // A ^ N-1의 [0][0] 구하면 답!!
            System.out.println(fibo(N-1)[0][0]);
        }
    }

    // 재귀 피보나치
    public static long[][] fibo(long n) {
        if(n == 0 || n == 1) {
            return A;
        }
        long[][] tmp = fibo(n/2);

        if(n % 2 == 1) { // 홀수면 한번 더 곱해줌
            return mul(mul(tmp, tmp), A);
        } else { // 짝수면 그냥 제곱
            return mul(tmp, tmp);
        }
    }

    // 행렬의 곱
    public static long[][] mul(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
