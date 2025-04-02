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

        if(N <= K) {
            System.out.println(0);
            return;
        }

        int water = 1; // N보다 작은 Max Water 찾기
        while(true) {
            if(water << 1 < N) water <<= 1; // 2배씩
            else break;
        }

        // 최소 찾기
        while(K > 0) {
            if(N >= water) {
                N -= water;
                K--;
            } else {
                water /= 2;
            }
        }
        // N : 남은 물
        System.out.println(N == 0 ? 0 : water - N);
    }
}
