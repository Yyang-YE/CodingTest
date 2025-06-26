import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ks = new HashMap<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            ks.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // N일에 ?번의 파스타 먹을 경우의 수
        Memo[][] memo = new Memo[N + 1][4];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                memo[i][j] = new Memo(0, 0);
            }
        }

        // 1일차 초기화
        if (ks.containsKey(1)) {
            int p = ks.get(1);
            memo[1][p].one = 1;
        } else {
            memo[1][1].one = 1;
            memo[1][2].one = 1;
            memo[1][3].one = 1;
        }

        // 2~N일차 점화식
        for (int day = 2; day <= N; day++) {
            if (ks.containsKey(day)) {
                int p = ks.get(day);
                // 연속해서 같은 파스타 3번 방지
                memo[day][p].one = 0;
                for (int prev = 1; prev <= 3; prev++) {
                    if (prev != p) {
                        memo[day][p].one = (memo[day][p].one + memo[day - 1][prev].one + memo[day - 1][prev].two) % MOD;
                    }
                }
                memo[day][p].two = memo[day - 1][p].one % MOD;

            } else {
                for (int p = 1; p <= 3; p++) {
                    memo[day][p].one = 0;
                    for (int prev = 1; prev <= 3; prev++) {
                        if (prev != p) {
                            memo[day][p].one = (memo[day][p].one + memo[day - 1][prev].one + memo[day - 1][prev].two) % MOD;
                        }
                    }
                    memo[day][p].two = memo[day - 1][p].one % MOD;
                }
            }
        }

        // 결과 계산
        int result = 0;
        for (int p = 1; p <= 3; p++) {
            result = (result + memo[N][p].one + memo[N][p].two) % MOD;
        }

        System.out.println(result);
    }

    public static class Memo {
        int one;
        int two;

        public Memo(int one, int two) {
            this.one = one;
            this.two = two;
        }
    }
}
