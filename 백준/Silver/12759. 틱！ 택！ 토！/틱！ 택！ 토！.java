import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y;
    static int[][] paper = new int[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int player = Integer.parseInt(br.readLine());

        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            paper[x][y] = player;

            if(i >= 4 && checkWin()) {
                flag = true;
                break;
            }
            player = (player == 1) ? 2 : 1;
        }
        System.out.println(flag ? player : 0);
    }

    private static boolean checkWin() {
        return (paper[x][0] == paper[x][1] && paper[x][1] == paper[x][2])
            || (paper[0][y] == paper[1][y] && paper[1][y] == paper[2][y])
            || (x == y && paper[0][0] == paper[1][1] && paper[1][1] == paper[2][2])
            || (x + y == 2 && paper[0][2] == paper[1][1] && paper[1][1] == paper[2][0]);
    }
}
