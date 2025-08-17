import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0) break;

            // 나무별 세기
            int count = 1;
            for (int i = 0; i < a; i++) {
                int sf = Integer.parseInt(st.nextToken());
                int cut = Integer.parseInt(st.nextToken());
                count = (count * sf) - cut;
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }
}
