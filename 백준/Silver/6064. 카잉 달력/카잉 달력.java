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
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = 0;
            boolean flag = false;
            while(count <= N) {
                int num = (count * M + x) % N;
                if(num == 0) num = N;
                if(y == num) {
                    bw.write((count * M + x) + "\n");
                    flag = true;
                    break;
                }
                count++;
            }
            if(!flag) {
                bw.write(-1 + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
