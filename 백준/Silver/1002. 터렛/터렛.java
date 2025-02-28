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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                bw.write("-1\n");
                continue;
            }

            // 조규현-백승환의 거리
            double distance = Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
            if(distance + Math.min(r1, r2) < Math.max(r1, r2) || r1 + r2 < distance) {
                bw.write("0\n");
            } else if(distance + Math.min(r1, r2) == Math.max(r1, r2) || r1 + r2 == distance) {
                bw.write("1\n");
            } else {
                bw.write("2\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
