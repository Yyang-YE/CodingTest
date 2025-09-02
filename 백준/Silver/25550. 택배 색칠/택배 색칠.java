import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long count = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    min = Math.min(min, box[i + dx[k]][j + dy[k]]);
                }
                if(min < box[i][j]) count += min;
                else if(box[i][j] != 0) count += (box[i][j] - 1);
            }
        }
        System.out.println(count);
    }
}
