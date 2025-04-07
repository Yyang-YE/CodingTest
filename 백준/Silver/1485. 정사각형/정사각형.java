import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            Coord[] square = new Coord[4];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                square[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            double[] len = new double[6];
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = i+1; j < 4; j++) {
                    long dx = Math.abs(square[i].x - square[j].x);
                    long dy = Math.abs(square[i].y - square[j].y);
                    double num = Math.sqrt(dx*dx + dy*dy);
                    len[cnt] = num;
                    cnt++;
                }
            }
            Arrays.sort(len);

            boolean flag = true;
            for (int i = 1; i < 4; i++) {
                if (len[0] != len[i]) {
                    flag = false;
                    break;
                }
            }
            if(len[4] != len[5]) flag = false;

            if(flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.print(sb);
    }

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
