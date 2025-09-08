import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int C = 0;
        for (int i = 0; i < N; i++) {
            if(str.charAt(i) == 'C') C++;
        }
        
        if(C == 0) {
            System.out.println(0);
            return;
        }

        // 계산
        int cur = 1;
        while(cur <= N) {
            // C 덩어리 수
            int tmpC = C / (cur) + (C % (cur) == 0 ? 0 : 1);
            if(N - C >= tmpC - 1) break;
            else cur++;
        }
        System.out.println(cur);
    }
}
