import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 투 포인터
        int pf = 0;
        int pl = 1;
        int min = Integer.MAX_VALUE;

        while(pf < N && pl < N) {
            int diff = arr[pl] - arr[pf];

            if(diff >= M) {
                min = Math.min(min, diff);
                pf++;
            } else {
                pl++;
            }
            if(pf == pl) pl++;
        }
        System.out.println(min);
    }
}
