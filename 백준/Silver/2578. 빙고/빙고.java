import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 판 입력
        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
            }
        }

        boolean flag = false;
        int answer = 0;
        int bingoCnt = 0;

        int[] xCnt = new int[5];
        int[] yCnt = new int[5];
        int lDiagonal = 0;
        int rDiagonal = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(flag) break;

                Point now = map.get(num);

                // x, y 관리
                xCnt[now.x]++;
                yCnt[now.y]++;
                if(now.x == now.y) lDiagonal++;
                if(now.x + now.y == 4) rDiagonal++;

                // bingoCnt 관리
                if(xCnt[now.x] == 5) {
                    xCnt[now.x] = 0;
                    bingoCnt++;
                }

                if(yCnt[now.y] == 5) {
                    yCnt[now.y] = 0;
                    bingoCnt++;
                }

                if(lDiagonal == 5) {
                    lDiagonal = 0;
                    bingoCnt++;
                }

                if(rDiagonal == 5) {
                    rDiagonal = 0;
                    bingoCnt++;
                }

                // 정답 확인
                if(bingoCnt >= 3) {
                    flag = true;
                    answer = i * 5 + j + 1;
                }
            }
        }
        System.out.println(answer);
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
