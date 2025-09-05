import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, P, X;
    static int total = 0;
    static int[][] changed = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 최고 층
        K = Integer.parseInt(st.nextToken()); // 자리 수
        P = Integer.parseInt(st.nextToken()); // 반전 최대 개수
        X = Integer.parseInt(st.nextToken()); // 현재 층

        int[] bit = {0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011, 0b1011111, 0b1110000, 0b1111111, 0b1111011};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int diff = bit[i] ^ bit[j];
                changed[i][j] = Integer.bitCount(diff);
            }
        }

        // 개수 count
        dfs(0, X, 0, 1);
        System.out.println(total);
    }

    private static void dfs(int depth, int num, int changeCnt, int prefix) {
        if(depth == K) {
            if(num > 0 && num != X && num <= N){
                total++;
            }
            return;
        }

        // 현재 자리수 올리기
        for (int i = 0; i < 10; i++) {
            int original = (num / prefix) % 10;
            int nextNum = (num - original * prefix) + i * prefix;
            int nextCnt = changeCnt + changed[original][i];

            if(nextCnt <= P) dfs(depth + 1, nextNum, nextCnt, prefix * 10);
        }
    }
}
