import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int maxH = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                maxH = Math.max(maxH, num);
                minH = Math.min(minH, num);
            }
        }

        // 돌면서 확인
        int minTime = Integer.MAX_VALUE;
        int finalHeight = 0;
        for (int i = minH; i <= maxH; i++) {
            int time = leveling(i, B);
            if(minTime >= time) {
                minTime = time;
                finalHeight = i;
            }
        }
        System.out.println(minTime + " " + finalHeight);
    }

    private static int leveling(int height, int inventory) {
        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int diff = map[i][j] - height;
                if(diff > 0) { // 파내기
                    time += diff * 2;
                    inventory += diff;
                } else if (diff < 0) { // 채우기
                    time += (diff * -1);
                    inventory += diff;
                }
            }
        }
        return inventory >= 0 ? time : Integer.MAX_VALUE;
    }
}
