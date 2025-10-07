import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int count = 0;
            int left = 0;
            while(M-- > 0) {
                int tmp = left + D;
                count += tmp / W;
                if(tmp % W != 0) count++;
                left = tmp % W;
            }
            bw.write("Case #" + t + ": " + count + "\n");
        }
        br.close();
        bw.close();
    }
}
