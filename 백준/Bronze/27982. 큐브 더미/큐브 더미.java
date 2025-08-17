import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][][] cube = new boolean[N+1][N+1][N+1];
        List<int[]> points = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cube[i][j][k] = true;
            points.add(new int[]{i, j, k});
        }

        int count = 0;
        for (int[] p : points) {
            if((checkArrange(p[0]+1) && cube[p[0]+1][p[1]][p[2]])
                && (checkArrange(p[0]-1) && cube[p[0]-1][p[1]][p[2]])
                && (checkArrange(p[1]+1) && cube[p[0]][p[1]+1][p[2]])
                && (checkArrange(p[1]-1) && cube[p[0]][p[1]-1][p[2]])
                && (checkArrange(p[2]+1) && cube[p[0]][p[1]][p[2]+1])
                && (checkArrange(p[2]-1) && cube[p[0]][p[1]][p[2]-1])) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean checkArrange(int x) {
        return 1 <= x && x <= N;
    }
}
