import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] xs = {0, 0, 1, -1};
        int[] ys = {1, -1, 0, 0};

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] map = new String[N][M];
        visited = new boolean[N][M];
        Coord now = new Coord(0, 0);
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                String letter = String.valueOf(str.charAt(j));
                map[i][j] = letter;
                if(letter.equals("I")) now = new Coord(i, j);
                if(letter.equals("X")) visited[i][j] = true;
            }
        }

        Queue<Coord> queue = new LinkedList<>();
        queue.add(now);

        int countFriend = 0;
        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int curX = now.x + xs[i];
                int curY = now.y + ys[i];
                
                if(checkRange(curX, curY) && !visited[curX][curY]) {
                    queue.add(new Coord(curX, curY));
                    visited[curX][curY] = true;
                    if(map[curX][curY].equals("P")) {
                        countFriend++;
                    }
                } // if
            } // for
        } // while
        System.out.println(countFriend == 0 ? "TT" : countFriend);
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
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
