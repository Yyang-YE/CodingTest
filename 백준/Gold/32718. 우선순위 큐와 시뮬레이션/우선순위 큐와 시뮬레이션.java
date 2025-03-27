import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()) % K;
        }
        Arrays.sort(nums);

        int A = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            A = (A + Integer.parseInt(st.nextToken())) % K;

            int ansIdx = -1;
            int criterion = K - A; // 얘보다 작은 수 중 가장 큰 값 찾기

            int ps = 0;
            int pl = N-1;

            while(ps <= pl) {
                int mid = (ps + pl) / 2;

                if(nums[mid] < criterion) {
                    ansIdx = mid;
                    ps = mid + 1;
                } else {
                    pl = mid - 1;
                }
            }

            // 전부 기준보다 크거나 같다면, 제일 큰 수가 답
            if(ansIdx == -1) ansIdx = N-1;

            // 정답 입력
            sb.append((nums[ansIdx] + A) % K).append(" ");
        }
        System.out.println(sb);
    }
}
