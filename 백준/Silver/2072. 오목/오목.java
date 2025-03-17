import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 흑1, 백2
public class Main {
    static int[][] map = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean endFlag = false;
        int answer = -1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int stone = i % 2 == 0 ? 1 : 2;
            map[x][y] = stone;

            if(N < 8 || endFlag) continue; // 각 4개까지는 완성될 수 X

            // 검사 로직
            endFlag = checkBingo(new Coord(x, y));
            if(endFlag) answer = i+1;
        }

        System.out.println(answer);
    }

    private static boolean checkBingo(Coord start) {
        int color = map[start.x][start.y];
        int x = start.x;
        int y = start.y;

        // 가로 확인
        int rowCount = 1;
        boolean lCheck = true;
        boolean rCheck = true;
        for (int i = 1; i <= 4; i++) {
            // 가로 확인
            if(lCheck && y-i >= 0) {
                if(map[x][y-i] != color) lCheck = false;
                else rowCount++;
            }
            if(rCheck && y+i < 19) {
                if(map[x][y+i] != color) rCheck = false;
                else rowCount++;
            }
        }
        if(rowCount == 5) return true;

        // 세로 확인
        int colCount = 1;
        boolean uCheck = true;
        boolean dCheck = true;
        for (int i = 1; i <= 4; i++) {
            // 위 확인
            if(uCheck && x-i >= 0) {
                if(map[x-i][y] != color) uCheck = false;
                else colCount++;
            }
            // 아래 확인
            if(dCheck && x+i < 19) {
                if(map[x+i][y] != color) dCheck = false;
                else colCount++;
            }
        }
        if(colCount == 5) return true;

        // 왼 대각선 확인
        int ldCount = 1;
        boolean luCheck = true;
        boolean rdCheck = true;
        for (int i = 1; i <= 4; i++) {
            // 위 확인
            if(luCheck && x-i >= 0 && y-i >= 0) {
                if(map[x-i][y-i] != color) luCheck = false;
                else ldCount++;
            }
            // 아래 확인
            if(rdCheck && x+i < 19 && y+i < 19) {
                if(map[x+i][y+i] != color) rdCheck = false;
                else ldCount++;
            }
        }
        if(ldCount == 5) return true;

        // 대각선 확인
        int ruCount = 1;
        boolean ruCheck = true;
        boolean ldCheck = true;
        for (int i = 1; i <= 4; i++) {
            // 우위 확인
            if(ruCheck && x-i >= 0 && y+i < 19) {
                if(map[x-i][y+i] != color) ruCheck = false;
                else ruCount++;
            }
            // 좌아래 확인
            if(ldCheck && x+i < 19 && y-i >= 0) {
                if(map[x+i][y-i] != color) ldCheck = false;
                else ruCount++;
            }
        }
        if(ruCount == 5) return true;

        return false;
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
