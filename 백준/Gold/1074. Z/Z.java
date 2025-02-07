import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int count = 0;

    // 도는 순서
    static int[] xs = {0, 0, 1, 1};
    static int[] ys = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열

        // 표 크기 계산
        int MS = 1;
        for (int i = 0; i < N; i++) {
            MS *= 2;
        }

        splitCountMap(MS, 0, 0);
        System.out.println(count);
    }

    public static void splitCountMap(int size, int startX, int startY) {
        if(size == 2) { // 더이상 쪼개지 못함
            for (int i = 0; i < 4; i++) {
                if(r == startX+xs[i] && c == startY+ys[i]) return;
                else count++;
            }
        } else {
            // 조건 달기
            int newMS = size / 2;
            int arrange = getArrange(newMS, startX, startY);

            if(arrange == 1) {
                splitCountMap(newMS, startX, startY);
            } else if(arrange == 2) {
                count += newMS * newMS;
                splitCountMap(newMS, startX, startY + newMS);
            } else if(arrange == 3) {
                count += newMS * newMS * 2;
                splitCountMap(newMS, startX + newMS, startY);
            } else if(arrange == 4) {
                count += newMS * newMS * 3;
                splitCountMap(newMS, startX + newMS, startY + newMS);
            }
        }
    }

    // r, c가 어느 사분면에 있는지 확인하는 메소드
    public static int getArrange(int newMS, int x, int y) {
        if(x <= r && r < x + newMS && y <= c && c < y+newMS) return 1;
        else if(x <= r && r < x + newMS && y+newMS <= c) return 2;
        else if(x+newMS <= r && y <= c && c < y+newMS) return 3;
        else return 4;
    }
}
