import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            // 홀수 : 1이 필요하므로 항상 n
            if(a % 2 == 1) {
                bw.write(n + "\n");
                continue;
            }

            // 짝수
            long gold = 1L << n;
            int count = 0;

            while(a > 0) {
                if(a >= gold) {
                    a -= gold;
                } else {
                    gold >>= 1;
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }
}
