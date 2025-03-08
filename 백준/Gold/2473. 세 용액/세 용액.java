import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] liquid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] liquid = new long[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);

        int mid = 0;
        int end = N-1;
        long min = Long.MAX_VALUE;
        long[] res = new long[3];

        for (int i = 0; i < N-2; i++) {

            mid = i + 1;
            end = N - 1;

            while(mid < end) {
                long sum = liquid[i] + liquid[mid] + liquid[end];
                // 최소값 업데이트
                if(min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    res[0] = liquid[i];
                    res[1] = liquid[mid];
                    res[2] = liquid[end];
                }

                // 포인터 이동
                if(sum == 0) {
                    break;
                } else if(sum > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
