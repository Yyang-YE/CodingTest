import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lines = new long[K];

        long lower = 1;
        long upper = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());;
            lines[i] = temp;
            upper = Math.max(upper, temp);
        }

        long maxCount = 0;
        while(lower <= upper) {
            long count = 0;
            long mid = (lower + upper) / 2;

            for (int i = 0; i < K; i++) {
                count += lines[i] / mid;
            }

            if(count >= N) {
                maxCount = Math.max(maxCount, mid);
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        System.out.println(maxCount);
    }
}
