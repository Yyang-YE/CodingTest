import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean searchDoneFlag = false;
    static int[][] sudoku = new int[9][9];
    static List<Coord> blanks = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                sudoku[i][j] = num;
                if(num == 0) blanks.add(new Coord(i, j));
            }
        }

        dfs(blanks.size(), 0);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int max, int depth) throws IOException {
        if (depth == max) { // 검사 완료
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            searchDoneFlag = true;
            return;
        }

        // 현재에서 가능한 값 리스트 만들기
        Coord curBlank = blanks.get(depth);
        curBlank.usable = checkPossibleNum(curBlank.x, curBlank.y);

        // 만약 usable에 true가 없으면 걍 return 해버리기 (다음 경우 고려)
        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            if(curBlank.usable[i]) flag = true;
        }
        if(!flag) return;

        for (int i = 0; i < 9; i++) {
            if(curBlank.usable[i]) { // 가능한 숫자들에 대해서만 돌기
                curBlank.usable[i] = false;
                sudoku[curBlank.x][curBlank.y] = i+1;

                dfs(max, depth+1);
                sudoku[curBlank.x][curBlank.y] = 0;
                if(searchDoneFlag) return;
            }
        }
    }

    private static boolean[] checkPossibleNum(int x, int y) {
        boolean[] usable = new boolean[9];
        Arrays.fill(usable, true);

        // 세로, 가로 확인
        for (int i = 0; i < 9; i++) {
            if(sudoku[x][i] != 0 && usable[sudoku[x][i]-1]) {
                usable[sudoku[x][i] - 1] = false;
            }
            if(sudoku[i][y] != 0 && usable[sudoku[i][y]-1]) {
                usable[sudoku[i][y] - 1] = false;
            }
        }

        // 네모칸 확인
        int sX = (x/3) * 3;
        int sY = (y/3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(sudoku[sX+i][sY+j] != 0 && usable[sudoku[sX+i][sY+j] - 1]) {
                    usable[sudoku[sX+i][sY+j] - 1] = false;
                }
            }
        }
        return usable;
    }

    public static class Coord {
        int x;
        int y;
        boolean[] usable;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
