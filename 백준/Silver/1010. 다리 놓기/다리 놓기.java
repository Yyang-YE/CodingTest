import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long bunmo = 1;
            long bunja = 1;
            for (int i = 1; i <= M; i++) {
                if(i > Math.max(M-N, N)) bunmo *= i;
                if(i <= Math.min(M-N, N)) bunja *= i;
            }
            bw.write(bunmo / bunja + "\n");
        }
        br.close();
        bw.close();
    }
}
