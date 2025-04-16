import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] three = {{0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4}, {5, 1, 3}, {5, 2, 1}, {5, 2, 4}, {5, 3, 4}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;

        // 입력 & 1개 보이는 면 - (N-2)^2 * 5면 + (N-2) * 4개
        int oneWay = Integer.MAX_VALUE;
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            oneWay = Math.min(oneWay, dice[i]);
        }

        if(N == 1) { // 한 칸인 경우 예외처리
            int ans = 0;
            int max = 0;
            for (int i : dice) {
                ans += i;
                max = Math.max(max, i);
            }
            System.out.println(ans - max);
            return;
        }
        total += (((long) (N - 2) * (N-2) * 5) + ((N-2) * 4L)) * oneWay;

        // 2개 보이는 면 - (N-2) * 8개 + 4
        int twoWay = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 6; j++) {
                if((i == 0 && j == 5) || (i == 1 && j == 4) || (i == 2 && j == 3)) continue;
                twoWay = Math.min(twoWay, dice[i] + dice[j]);
            }
        }
        total += ((N-2)*4L + (N-1)*4L) * twoWay;

        // 3개 보이는 면 - 4개 (윗꼭짓점)
        int threeWay = Integer.MAX_VALUE;
        for (int[] tr : three) {
            threeWay = Math.min(threeWay, (dice[tr[0]] + dice[tr[1]] + dice[tr[2]]));
        }
        total += threeWay * 4L;

        System.out.println(total);
    }
}
