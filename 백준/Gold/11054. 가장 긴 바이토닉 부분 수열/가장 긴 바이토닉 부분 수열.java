import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp 기준으로 증가 시의 dp, 감소 시의 dp... 각각 저장하기
        for (int i = 0; i < N; i++) {
            // 본인이 최대 / 최소인 경우
            dp[i][0] = dp[N-i-1][1] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
                if(arr[N-i-1] > arr[N-j-1]) {
                    dp[N-i-1][1] = Math.max(dp[N-i-1][1], dp[N-j-1][1] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i][0] + dp[i][1]);
        }
        System.out.println(answer - 1);
    }
}
