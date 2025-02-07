import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int houseCount;
    static int[][] map;
    static boolean[][] visited;

    static int[] xs = {0, 0, 1, -1};
    static int[] ys = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(str.substring(j, j+1));
                map[i][j] = temp;
            }
        }

        int danjiCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    // dfs 돌리고, 받은 결과 queue에 넣기
                    houseCount = 0;
                    dfs(i, j);
                    list.add(houseCount);
                    danjiCount++;
                }
            }
        }
        Collections.sort(list);

        sb.append(danjiCount);
        for (Integer i : list) {
            sb.append("\n").append(i);
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        houseCount++;

        for (int i = 0; i < 4; i++) {
            int curX = xs[i] + x;
            int curY = ys[i] + y;
            if(checkIndex(curX, curY) && !visited[curX][curY] && map[curX][curY] != 0) {
                dfs(curX, curY);
            }
        }
    }

    public static boolean checkIndex(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
