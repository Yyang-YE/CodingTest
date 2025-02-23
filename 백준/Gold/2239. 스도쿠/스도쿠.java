import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean doneFlag = false;
    static int[][] map = new int[9][9];
    static List<Coord> blanks = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 입력받기
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(str.substring(j, j+1));
                map[i][j] = num;
                if(num == 0) blanks.add(new Coord(i, j));
            }
        }

        fillBlank(0);

        br.close();
        bw.close();
    }

    public static void fillBlank (int depth) throws IOException {
        // 조건 만족 시
        if(depth == blanks.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(String.valueOf(map[i][j]));
                }
                bw.write("\n");
            }
            doneFlag = true;
            return;
        }

        Coord now = blanks.get(depth);
        List<Integer> avail = getAvailableNumber(now);

        for (int i : avail) {
            map[now.x][now.y] = i;
            fillBlank(depth+1);
            map[now.x][now.y] = 0;
            if(doneFlag) return;
        }
    }

    public static List<Integer> getAvailableNumber(Coord node) {
        List<Integer> list =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < 9; i++) {
            // 가로 확인
            list.remove((Integer) map[node.x][i]);
            // 세로 확인
            list.remove((Integer) map[i][node.y]);
        }

        // 3*3 칸 확인
        int startX = (node.x / 3) * 3; // 해당 블록의 시작 x좌표
        int startY = (node.y / 3) * 3; // 해당 블록의 시작 y좌표
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.remove((Integer) map[startX + i][startY + j]);
            }
        }
        return list;
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
