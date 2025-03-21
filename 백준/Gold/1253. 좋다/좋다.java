import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int total = 0;
        for (int i = N-1; i >= 0; i--) {
            int need = num[i]; // 만들어야하는 값

            // 투포인터
            int ps = (i == 0) ? 1 : 0;
            int pl = (i == N-1) ? N-2 : N-1;
            while(ps < pl) {
                int sum = num[ps] + num[pl];
                if (sum > need) {
                    pl = (pl-1 == i) ? pl-2 : pl-1;
                } else if(sum == need) {
                    total++; // 하나라도 있으면 "좋다"
                    break;
                } else {
                    ps = (ps+1 == i) ? ps+2 : ps+1;
                }
            }
        }
        System.out.println(total);
    }
}
