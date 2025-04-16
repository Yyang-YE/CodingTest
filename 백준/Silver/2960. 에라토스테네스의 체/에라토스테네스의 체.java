import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] nums = new boolean[N+1];

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(nums[i]) continue;
            int cur = i;
            while(cur <= N) {
                if(nums[cur]) {
                    cur += i;
                    continue;
                }
                if(++count == K) {
                    System.out.println(cur);
                    return;
                }
                nums[cur] = true;
                cur += i;
            }
        }
    }
}
